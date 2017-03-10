package com.springboot.demo.usercenter.usermanager.serve;


import com.springboot.demo.usercenter.usermanager.dao.SysUserRepository;
import com.springboot.demo.usercenter.usermanager.domain.SysUserDomain;
import com.springboot.demo.usercenter.usermanager.dto.SysUserModuleVo;
import com.springboot.demo.util.base.entitypo.SysUser;
import com.springboot.demo.util.base.entityvo.BaseOutput;
import com.springboot.demo.util.base.serve.DynamicQuery;
import com.springboot.demo.util.base.serve.P;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 *
 */
public interface SysUserService {


    //使用单表分页查询
    public BaseOutput<SysUser> findList(SysUserDomain sysUserDomain);

    //查询sql 使用原生sql
    public BaseOutput<SysUser> findListNativeSql(SysUserDomain sysUserDomain);

    //查询单个对象
    public SysUser findOne(String id);


    //更新操作
     public int update(SysUser sysUser) throws RuntimeException;


    public int delete(String id);


}
