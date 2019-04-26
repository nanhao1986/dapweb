package com.ucontrol.dapweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.ucontrol.dapweb.dao")
@ComponentScan(basePackages = {"com"})


public class DapwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DapwebApplication.class, args);
    }

}
