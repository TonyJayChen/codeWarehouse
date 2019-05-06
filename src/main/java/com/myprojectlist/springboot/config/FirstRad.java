package com.myprojectlist.springboot.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 注解配置的两种路径写法，一种是file:./config/
 * 另外一种是classpath:/config/
 */
@Component
@ConfigurationProperties(prefix="config")
@PropertySource("file:./config/config.properties")
public class FirstRad {
    private String pname;

    private String password;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
