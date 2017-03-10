package com.springboot.demo.usercenter.usermanager.web;

import com.springboot.demo.usercenter.usermanager.domain.SysUserDomain;
import com.springboot.demo.usercenter.usermanager.serve.SysUserService;
import com.springboot.demo.util.base.entitypo.SysUser;
import com.springboot.demo.util.base.entityvo.BaseOutput;
import com.springboot.demo.util.base.entityvo.ReturnCode;
import com.springboot.demo.util.base.entityvo.ReturnCodeDict;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统用户管理
 */
@Api(value = "系统用户管理", description = "com.springboot.demo.usercenter.usermanager.web.SysUserController")
@RestController
@RequestMapping("/api/sysUser")
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    /***
     * 列表页面传入json 参数转化对象 使用 post
     */
    @ApiOperation(value = "获取用户列表", notes = "需要传入json参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysUserDomain", value = "系统用户实体", required = true, dataType = "SysUserDomain")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = BaseOutput.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping(value = "list")
    public BaseOutput<SysUser> list(HttpServletRequest request, HttpServletResponse response, @RequestBody SysUserDomain sysUserDomain) {
        BaseOutput<SysUser> baseOutput = null;
        try {

            baseOutput = sysUserService.findList(sysUserDomain);

        } catch (Exception ex) {

            baseOutput = baseOutput == null ? (baseOutput = new BaseOutput<SysUser>()) : baseOutput;
            baseOutput.setReturnCode(new ReturnCode(ReturnCodeDict.ERROR.k, ReturnCodeDict.ERROR.m, ex.getMessage()));


        } finally {
            return baseOutput;
        }

    }

    //获取数据
    @ApiOperation(value = "获取用户数据", notes = "根据用户ID获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户唯一ID", required = true, dataType = "String", paramType = "String")
    })
    @GetMapping(value = "update/{id}")
    public SysUser get(@PathVariable("id") String id) {
        return sysUserService.findOne(id);
    }

    //新增
    @ApiOperation(value = "新增用户", notes = "新增用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysUser", value = "用户信息实体对象", required = true, dataType = "SysUser", paramType = "SysUser")
    })
    @PostMapping(value = "update")
    public BaseOutput add(@RequestBody SysUser sysUser) {
        BaseOutput baseOutput = new BaseOutput();

        try {

            sysUserService.update(sysUser);
            baseOutput.setReturnCode(new ReturnCode(ReturnCodeDict.OK.k, ReturnCodeDict.OK.m));
        } catch (Exception ex) {
            baseOutput.setReturnCode(new ReturnCode(ReturnCodeDict.ERROR.k, ReturnCodeDict.ERROR.m, ex.getMessage()));
        } finally {
            return baseOutput;
        }


    }

    //更新
    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysUser", value = "用户信息实体对象", required = true, dataType = "SysUser", paramType = "SysUser")
    })
    @PutMapping(value = "update")
    public BaseOutput update(@RequestBody SysUser sysUser) {

        BaseOutput baseOutput = new BaseOutput();
        try {
            sysUserService.update(sysUser);
            baseOutput.setReturnCode(new ReturnCode(ReturnCodeDict.OK.k, ReturnCodeDict.OK.m));
        } catch (Exception ex) {
            baseOutput.setReturnCode(new ReturnCode(ReturnCodeDict.ERROR.k, ReturnCodeDict.ERROR.m, ex.getMessage()));

        } finally {
            return baseOutput;
        }
    }

    //删除
    @ApiOperation(value = "删除用户", notes = "删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户唯一ID", required = true, dataType = "String", paramType = "SysUser")
    })
    @DeleteMapping(value = "update/{id}")
    public int add(@PathVariable("id") String id) {
        return sysUserService.delete(id);
    }
}
