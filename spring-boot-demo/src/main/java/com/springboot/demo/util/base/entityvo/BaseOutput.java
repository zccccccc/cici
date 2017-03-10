package com.springboot.demo.util.base.entityvo;

/**
 * 顶级输出类
 */
public class BaseOutput<T> {

    //页面
    private BasePage page;

    //处理状态
    private ReturnCode returnCode;

    private T data;

    public BasePage getPage() {
        return page;
    }

    public void setPage(BasePage page) {
        this.page = page;
    }

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
