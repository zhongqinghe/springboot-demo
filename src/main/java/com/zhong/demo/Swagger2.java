package com.zhong.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 添加描述
 *
 * @author zhongqinghe
 * @create 2017/12/20 17:59
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.zhong.demo")).paths(PathSelectors.any()).build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SpringBoot的使用swagger的RestApi").description("更多资料待续。。。").termsOfServiceUrl("127.0.0.1:8080").contact("哈哈").version("1.0").build();
    }
}
