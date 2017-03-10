package com.springboot.demo.usercenter.usermanager.domain;

import com.springboot.demo.util.base.entityvo.BaseInput;
import com.springboot.demo.util.base.entityvo.BasePage;

/**
 * 独立模型
 * 查询使用
 */
public class SysUserDomain extends BaseInput {

    private String searchName;
    private String searchCode;

    private BasePage basePage = new BasePage();

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getSearchCode() {
        return searchCode;
    }

    public void setSearchCode(String searchCode) {
        this.searchCode = searchCode;
    }

    public BasePage getBasePage() {
        return basePage;
    }

    public void setBasePage(BasePage basePage) {
        this.basePage = basePage;
    }
}
