package com.example.online_shopping_platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com/example/online_shopping_platform/mapper")
@ServletComponentScan
public class OnlineShoppingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingPlatformApplication.class, args);
	}

}
