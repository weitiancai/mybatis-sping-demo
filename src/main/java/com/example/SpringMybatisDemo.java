package com.example;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = {"classpath:mybatis-config.xml"})
//等价于 properties 中的mybatis.config-location=classpath:mybatis-config.xml
@SpringBootApplication
@MapperScan("com.example.dao") //等价于mapper 接口带@Mapper
public class SpringMybatisDemo {
    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisDemo.class, args);
    }

}
