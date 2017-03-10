package com.springboot.demo.usercenter.usermanager.dao;


import com.springboot.demo.util.base.baseRepository.JpaSequenceRepository;
import com.springboot.demo.util.base.entitypo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 数据层
 */
public interface SysUserRepository extends JpaRepository<SysUser, String>, JpaSequenceRepository, JpaSpecificationExecutor<SysUser>,
        PagingAndSortingRepository<SysUser, String> {


    @Modifying
    @Query(value = " update sys_user set  remark= ?1,qq= ?2,usbkey= ?3  where id = ?4 ", nativeQuery = true)
    int updateSysUserOtherInfoById(String remark, String qq, String usbkey, String id);

    //返回List<Object[]> 需要手动转化,不推荐使用
    //@Query(value = " select id,code,name,tel from SysUser where name like '%张%' ",nativeQuery = false)
    //List<SysUser> findSysUser();

}
