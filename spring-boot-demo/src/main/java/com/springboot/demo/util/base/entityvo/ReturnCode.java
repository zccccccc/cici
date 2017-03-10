package com.springboot.demo.util.base.entityvo;

/**
 *
 */
public class ReturnCode {

    private int code;
    private String promptMsg;
    private String errorMsg;

    public ReturnCode() {
    }

    public ReturnCode(int code, String promptMsg) {
        this.code = code;
        this.promptMsg = promptMsg;
    }

    public ReturnCode(int code, String promptMsg, String errorMsg) {
        this.code = code;
        this.promptMsg = promptMsg;
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPromptMsg() {
        return promptMsg;
    }

    public void setPromptMsg(String promptMsg) {
        this.promptMsg = promptMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
