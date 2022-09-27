package com.onlie.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author csz
 * @Date 2022/9/22 14:20
 */
@MapperScan("com.onlie.edu.Mapper")
@SpringBootApplication
public class eduApp {
    public static void main(String[] args) {
        SpringApplication.run(eduApp.class,args);
    }
}
