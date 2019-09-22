package com.god.web.zeus.conf;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@Configuration
@EnableSwagger2 // 作用是启用Swagger2相关功能。
@ComponentScan(basePackages="com.god.web.zeus.controller")
public class SwaggerConfig {
	
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select() // 选择那些路径和api会生成document
//				.apis(RequestHandlerSelectors.any()) // 对所有api进行监控
//				.paths(PathSelectors.any()) // 对所有路径进行监控
//				.build();
//	}

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()    // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any()) // 对所有api进行监控
                .paths(PathSelectors.any())     // 对所有路径进行监控
                .build()
                .apiInfo(apiInfo());
    }
    

    private ApiInfo apiInfo() {
        return new ApiInfo("Spring Web 项目集成 Swagger 实例文档", "欢迎大家访问。", "API V1.0",
                "Terms of service", 
                new Contact("OpenApi", "http://127.0.0.1:8080", "123456@163.com"), 
                "Apache",
                "http://www.apache.org/", 
                Collections.emptyList());
    }
}
