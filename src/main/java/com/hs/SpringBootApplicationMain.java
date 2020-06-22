package com.hs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-01 21:29
 **/
@SpringBootApplication
@MapperScan("com.hs.mapper")
public class SpringBootApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationMain.class,args);
    }
}
