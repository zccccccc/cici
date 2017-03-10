package com.springboot.demo.util.base.entitypo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class CatUser {

    @Id
    @Column(nullable = false, length = 24)
    private String id;

    //登录账号
    private String code;

    //用户昵称
    private String nickName;

    //用户类型
    private String userType;

    //用户密码
    private String pwd;

    //创建日期
    private Date createDate;

    private String userCodeValue;

    public String getUserCodeValue() {
        return userCodeValue;
    }

    public void setUserCodeValue(String userCodeValue) {
        this.userCodeValue = userCodeValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
