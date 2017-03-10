package com.springboot.demo.usercenter.usermanager.serve;

import com.springboot.demo.usercenter.usermanager.dao.SysUserRepository;
import com.springboot.demo.usercenter.usermanager.domain.SysUserDomain;
import com.springboot.demo.usercenter.usermanager.dto.SysUserModuleVo;
import com.springboot.demo.util.base.entitypo.SysUser;
import com.springboot.demo.util.base.entityvo.BaseOutput;
import com.springboot.demo.util.base.serve.DynamicQuery;
import com.springboot.demo.util.base.serve.P;
import com.springboot.demo.util.sqlutil.LoadingSqlXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by zhangchao on 3/8/17.
 */
@Service
public class SysUserServiceImpl implements SysUserService {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private DynamicQuery dynamicQuery;


    //sql
    private HashMap<String, String> dbSqlMap = LoadingSqlXml.INSTANCE.findSqlMap(this.getClass().getName());


    //使用单表分页查询
    public BaseOutput<SysUser> findList(SysUserDomain sysUserDomain) {

        Pageable pageable = P.extractPageable(sysUserDomain.getBasePage());

        //分页
        Page<SysUser> pageSysUsers = sysUserRepository.findAll(pageable);

        //列表
        //排序
//        Sort sort = new Sort(Sort.Direction.DESC,"id");
//        List<SysUser> sysUserList = sysUserRepository.findAll(sort);

        return P.wrapBaseOutput(pageSysUsers);
    }

    //查询sql 使用原生sql
    public BaseOutput<SysUser> findListNativeSql(SysUserDomain sysUserDomain) {


        Pageable pageable = P.extractPageable(sysUserDomain.getBasePage());

        //查询用户菜单权限
//        String sql = " \tSELECT\n" +
//                "\t\tdistinct\n" +
//                "\t  XX.module_id,\n" +
//                "       XX.action_code,\n" +
//                "       XX.action_name,\n" +
//                "       ZZ.name module_name,\n" +
//                "       ZZ.url,\n" +
//                "       ZZ.order_id,\n" +
//                "       ZZ.module_desc,\n" +
//                "       ZZ.code module_code,\n" +
//                "        ZZ.parent_id\n" +
//                "FROM SYS_PRIVILEGE XX,\n" +
//                "     SYS_MODULE ZZ\n" +
//                "WHERE XX.module_id =ZZ.id\n" +
//                "  AND ZZ.enable_state='10'\n" +
//                "  and exists\n" +
//                "    ( SELECT 1\n" +
//                "     FROM SYS_USER_AUTH AA,SYS_ROLE BB\n" +
//                "     WHERE AA.user_id = ?1\n" +
//                "       AND AA.role_id = BB.id\n" +
//                "       AND BB.enable_state='10'\n" +
//                "        and AA.role_id = XX.role_id\n" +
//                "       AND EXISTS\n" +
//                "         ( SELECT 1\n" +
//                "          FROM sys_system SS\n" +
//                "          WHERE SS.id = BB.sys_id\n" +
//                "            AND SS.code = ?2  )\n" +
//                "       AND AA.role_id=BB.id)";


        String sql = dbSqlMap.get("findListNativeSql");


        Page<SysUserModuleVo> sysUserSelects2 = dynamicQuery.nativeQuery(SysUserModuleVo.class, pageable, sql, "HHYT00000000000002000760", "ENT");

        return P.wrapBaseOutput(sysUserSelects2);
    }

    //查询单个对象
    public SysUser findOne(String id) {
        return sysUserRepository.findOne(id);
    }


    //更新操作
    @Transactional(timeout = 7, rollbackFor = {RuntimeException.class})
    public int update(SysUser sysUser) throws RuntimeException {


        //新增操作
        if (StringUtils.isEmpty(sysUser.getId())) {
            sysUser.setId(sysUserRepository.getId24());

            logger.debug("用户新增操作");
            sysUserRepository.saveAndFlush(sysUser);

        } else {

            // 先执行jps 更新 (如果最后执行,同一表可能会覆盖掉后面的更新数据)
            sysUser.setUserType("1");
            sysUser.setEmail("email@333.com");
            sysUserRepository.saveAndFlush(sysUser);

            sysUserRepository.updateSysUserOtherInfoById("修改QQ3和key3", "11111", UUID.randomUUID().toString(), sysUser.getId());

            //本地sql 更新操作
            String sql = " update sys_user set creator=?1,last_modifier=?2,last_modifier_date = sysdate,data_source='03' where id = ?3 ";
            dynamicQuery.nativeExecuteUpdate(sql, "张三1", "李四2", sysUser.getId());


            logger.debug("用户更新操作");

            //测试抛出异常 下面会回滚
            //  throw new RuntimeException("我去异常了");

        }


        return 1;
    }


    public int delete(String id) {
        logger.debug("删除了用户");
        sysUserRepository.delete(id);
        return 1;
    }

}
