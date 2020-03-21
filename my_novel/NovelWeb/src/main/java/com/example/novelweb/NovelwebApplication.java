package com.example.novelweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.novelweb.mapper")
@SpringBootApplication
public class NovelwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovelwebApplication.class, args);
		System.out.println("                      ==========启动成功==========");
		System.out.println("                      ==========启动成功==========");
		System.out.println("                      ==========启动成功==========");
	}

}
