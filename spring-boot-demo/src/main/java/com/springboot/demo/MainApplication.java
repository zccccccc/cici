package com.springboot.demo;

import com.springboot.demo.util.intercept.UserSecurityInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 程序入口
 */

@ServletComponentScan
@SpringBootApplication
public class MainApplication extends WebMvcConfigurerAdapter {

    //第一种
    //1 cd  /Users/zhangchao/AAAIDEA_WORKBASE_NEWNEWNEWE/cici
    //1 mvn spring-boot:run

    //第二种
    //2 cd  /Users/zhangchao/AAAIDEA_WORKBASE_NEWNEWNEWE/cici
    //2. mvn install
    //2.  cd target/
    //2. java -jar cici-log.jar

    //第三种
    //直接运行main方法

    //启动时候选择配置文件启动
    //3 application.yml application-dev.yml application-pro.yml
    //3. mvn install
    //3.  cd target/
    //3. java -jar cici-log.jar -spring.profies.active=pro

    //后台启动

    /**
     * nohup java -jar cici-log.jar &
     * nohup java -jar cici-log.jar  /dev/null 2>&1 &
     */
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    /**
     * 配置拦截器
     *
     * @param registry
     * @author zc
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/*");
    }
}
