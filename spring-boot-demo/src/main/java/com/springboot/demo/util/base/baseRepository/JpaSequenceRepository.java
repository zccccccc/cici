package com.springboot.demo.util.base.baseRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by zhangchao on 3/7/17.
 */
@NoRepositoryBean
public interface JpaSequenceRepository {


    @Query(value = " select 'DATA'||lpad(ORIG_ID.Nextval, 20, '0') from DUAL ", nativeQuery = true)
    String getId24();

    @Query(value = " select 'DATA'||lpad(ORIG_ID.Nextval, 32, '0') from DUAL ", nativeQuery = true)
    String getId36();

    @Query(value = " select ORIG_ID.Nextval from DUAL ", nativeQuery = true)
    Integer getIdNumber();


}
