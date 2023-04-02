package com.zxt.helper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

@Bean
    public ApiInfo apiInfo(){
         return new ApiInfoBuilder()
                 //设置文档的标题
                 .title("全过程监督助手")
                 .contact(new Contact("TanXiao","",""))
                 //设置文档的描述
                 .description("专为 <h1>全过程监督助手</h1>提供的在线文档，可根据各个api接口的规范来调用各种接口")
                 //设置文档的版本信息
                 .version("1.0.0.SNAPSHOT")
                 .build();
    }
    @Bean
    public  List<Parameter> params(){
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("x-access-token")
                .description("认证token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build());
        return parameters;
    }

    @Bean
    public Docket createPortalRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("门户展示API")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zxt.helper.controller"))
                //可以根据url路径设置哪些请求加入文档，忽略哪些请求。
                .paths(PathSelectors.any())
                .build()
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts())
                .globalOperationParameters(params());

    }

    @Bean
    public Docket createManRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("后台管理API").apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zxt.helper.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(params());
    }





//    private List<ApiKey> securitySchemes() {
//        List<ApiKey> apiKeyList = new ArrayList<>();
//        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
//        return apiKeyList;
//    }

//    private List<SecurityContext> securityContexts() {
//        List<SecurityContext> securityContexts = new ArrayList<>();
//        securityContexts.add(SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex("^(?!app).*$")).build());
//        return securityContexts;
//    }

//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        List<SecurityReference> securityReferences = new ArrayList<>();
//        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
//        return securityReferences;
//    }



}
