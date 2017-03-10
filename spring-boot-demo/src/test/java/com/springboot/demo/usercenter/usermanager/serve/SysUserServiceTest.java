package com.springboot.demo.usercenter.usermanager.serve;

import com.springboot.demo.usercenter.usermanager.domain.SysUserDomain;
import com.springboot.demo.util.base.entitypo.SysUser;
import com.springboot.demo.util.base.entityvo.BaseOutput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * 严重问题,测试方法不能自动回滚,系统发布时候砸搞?
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {

    @Autowired
    SysUserService sysUserService;




    @Test
    public void findListNativeSql() {
       try{
         BaseOutput<SysUser> sysUserBaseOutput= sysUserService.findListNativeSql(new SysUserDomain());
//
           sysUserBaseOutput.getData();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Test
    public void update() {
//
//        SysUser sysUser = sysUserService.findOne("HHYT00000000000002000760");
//
//        //新增
//        sysUser.setId(null);
//        int result =  sysUserService.update(sysUser);


    }
}
