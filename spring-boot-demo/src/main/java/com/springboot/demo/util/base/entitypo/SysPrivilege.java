package com.springboot.demo.util.base.entitypo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 系统角色模块授权表
 **/
@Entity
public class SysPrivilege extends BaseDomain {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYS_PRIVILEGE.ID
     *
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    @Id
    @Column(nullable = false, length = 24)
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYS_PRIVILEGE.ROLE_ID
     *
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYS_PRIVILEGE.MODULE_ID
     *
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    private String moduleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYS_PRIVILEGE.ACTION_CODE
     *
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    private String actionCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SYS_PRIVILEGE.ACTION_NAME
     *
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    private String actionName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PRIVILEGE.ID
     *
     * @return the value of SYS_PRIVILEGE.ID
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PRIVILEGE.ID
     *
     * @param id the value for SYS_PRIVILEGE.ID
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PRIVILEGE.ROLE_ID
     *
     * @return the value of SYS_PRIVILEGE.ROLE_ID
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PRIVILEGE.ROLE_ID
     *
     * @param roleId the value for SYS_PRIVILEGE.ROLE_ID
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PRIVILEGE.MODULE_ID
     *
     * @return the value of SYS_PRIVILEGE.MODULE_ID
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    public String getModuleId() {
        return moduleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PRIVILEGE.MODULE_ID
     *
     * @param moduleId the value for SYS_PRIVILEGE.MODULE_ID
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PRIVILEGE.ACTION_CODE
     *
     * @return the value of SYS_PRIVILEGE.ACTION_CODE
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PRIVILEGE.ACTION_CODE
     *
     * @param actionCode the value for SYS_PRIVILEGE.ACTION_CODE
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    public void setActionCode(String actionCode) {
        this.actionCode = actionCode == null ? null : actionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SYS_PRIVILEGE.ACTION_NAME
     *
     * @return the value of SYS_PRIVILEGE.ACTION_NAME
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    public String getActionName() {
        return actionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SYS_PRIVILEGE.ACTION_NAME
     *
     * @param actionName the value for SYS_PRIVILEGE.ACTION_NAME
     * @mbggenerated Mon Mar 06 14:07:00 CST 2017
     */
    public void setActionName(String actionName) {
        this.actionName = actionName == null ? null : actionName.trim();
    }
}