package com.springboot.demo.util.sqlutil;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 初始化sql到内存中  自定义异常
 */

public class InitDataSqlReaderException extends Exception {


    public InitDataSqlReaderException() {
        super();
    }

    public InitDataSqlReaderException(String msg) {
        super(msg);
    }


}
