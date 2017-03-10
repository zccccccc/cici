package com.springboot.demo.util.base.serve;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 扩展SpringDataJpa, 支持动态jpql/nativesql查询并支持分页查询<br/>
 * 使用方法：注入ServiceImpl
 *
 * @author wanghui
 * @lastModified wanghui 2014-9-11 10:26:22
 */
public interface DynamicQuery {

    // -====================================== jpql查询 ======================================-

    /**
     * 执行jpql查询
     *
     * @param jpql
     * @param params 占位符参数(例如?1)绑定的参数值
     * @return
     * @see <T> List<T> query(Class<T> columnClass, String jpql, Object... params);
     */
    List<?> query(String jpql, Object... params);

    /**
     * 执行jpql查询
     *
     * @param resultClass 查询结果类型
     * @param jpql
     * @param params      占位符参数(例如?1)绑定的参数值
     * @return
     */
    <T> List<T> query(Class<T> resultClass, String jpql, Object... params);

    /**
     * 执行jpql查询一行
     *
     * @param resultClass 查询结果类型
     * @param jpql
     * @param params      占位符参数(例如?1)绑定的参数值
     * @return
     */
    <T> T querySingleResult(Class<T> resultClass, String jpql, Object... params);

    /**
     * 执行jpql分页查询
     *
     * @param pageable 分页数据
     * @param jpql
     * @param params   占位符参数(例如?1)绑定的参数值
     * @return 分页结果
     * @see <T> List<T> queryPagingList(Class<T> resultClass, Pageable pageable, String jpql, Object... params);
     */
    List<?> queryPagingList(Pageable pageable, String jpql, Object... params);

    /**
     * 执行jpql分页查询
     *
     * @param resultClass 查询结果类型
     * @param pageable    分页数据
     * @param jpql
     * @param params      占位符参数(例如?1)绑定的参数值
     * @return 分页结果
     */
    <T> List<T> queryPagingList(Class<T> resultClass, Pageable pageable, String jpql, Object... params);

    /**
     * 执行jpql分页查询
     *
     * @param pageable 分页数据
     * @param jpql
     * @param params   占位符参数(例如?1)绑定的参数值
     * @return 分页对象
     * @see <T> Page<T> query(Class<T> resultClass, Pageable pageable, String jpql, Object... params);
     */
    @SuppressWarnings("rawtypes")
    Page query(Pageable pageable, String jpql, Object... params);

    /**
     * 执行jpql分页查询
     *
     * @param resultClass 查询结果类型
     * @param pageable    分页数据
     * @param jpql
     * @param params      占位符参数(例如?1)绑定的参数值
     * @return 分页对象
     */
    <T> Page<T> query(Class<T> resultClass, Pageable pageable, String jpql, Object... params);

    /**
     * 执行jpql统计查询
     *
     * @param jpql
     * @param params 占位符参数(例如?1)绑定的参数值
     * @return 统计条数
     */
    Long queryCount(String jpql, Object... params);

    /**
     * 执行jpql的update,delete操作
     *
     * @param nativeSql
     * @param params
     * @return
     */
    int executeUpdate(String nativeSql, Object... params);

    // -====================================== 本地查询 ======================================-


    /**
     * 执行nativeSql查询
     *
     * @param nativeSql
     * @param params    占位符参数(例如?1)绑定的参数值
     * @return
     */
    List<Object[]> nativeQuery(String nativeSql, Object... params);

    /**
     * 执行nativeSql查询
     *
     * @param resultClass 查询结果类型
     * @param nativeSql
     * @param params      占位符参数(例如?1)绑定的参数值
     * @return
     */
    <T> List<T> nativeQuery(Class<T> resultClass, String nativeSql, Object... params);

    /**
     * 执行nativeSql查询一行
     *
     * @param resultClass 查询结果类型
     * @param nativeSql
     * @param params      占位符参数(例如?1)绑定的参数值
     * @return
     */
    <T> T nativeQuerySingleResult(Class<T> resultClass, String nativeSql, Object... params);

    /**
     * 执行nativeSql分页查询
     *
     * @param pageable  分页数据
     * @param nativeSql
     * @param params    占位符参数(例如?1)绑定的参数值
     * @return 分页结果
     */
    List<Object[]> nativeQueryPagingList(Pageable pageable, String nativeSql, Object... params);

    /**
     * 执行nativeSql分页查询
     *
     * @param resultClass 查询结果类型
     * @param pageable    分页数据
     * @param nativeSql
     * @param params      占位符参数(例如?1)绑定的参数值
     * @return 分页结果
     */
    <T> List<T> nativeQueryPagingList(Class<T> resultClass, Pageable pageable, String nativeSql, Object... params);

    /**
     * 执行nativeSql分页查询
     *
     * @param pageable  分页数据
     * @param nativeSql
     * @param params    占位符参数(例如?1)绑定的参数值
     * @return 分页对象
     */
    @SuppressWarnings("rawtypes")
    Page nativeQuery(Pageable pageable, String nativeSql, Object... params);

    /**
     * 执行nativeSql分页查询
     *
     * @param resultClass 查询结果类型
     * @param pageable    分页数据
     * @param nativeSql
     * @param params      占位符参数(例如?1)绑定的参数值
     * @return 分页对象
     */
    <T> Page<T> nativeQuery(Class<T> resultClass, Pageable pageable, String nativeSql, Object... params);

    /**
     * 执行nativeSql统计查询
     *
     * @param nativeSql
     * @param params    占位符参数(例如?1)绑定的参数值
     * @return 统计条数
     */
    Long nativeQueryCount(String nativeSql, Object... params);

    /**
     * 执行nativeSql的update,delete操作
     *
     * @param nativeSql
     * @param params
     * @return
     */
    int nativeExecuteUpdate(String nativeSql, Object... params);

}
