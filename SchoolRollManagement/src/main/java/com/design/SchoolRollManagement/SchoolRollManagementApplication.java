package com.design.SchoolRollManagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.design.SchoolRollManagement.mapper")
@ComponentScan(value="com.design")
public class SchoolRollManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolRollManagementApplication.class, args);
	}

}
