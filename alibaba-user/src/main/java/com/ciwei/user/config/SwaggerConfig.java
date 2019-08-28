//package com.ciwei.user.config;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.UiConfiguration;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @NAME SwaggerConfig
// * @USER Ciwei
// * @DATE 2019/8/27 22:11
// **/
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//	@Bean
//	public Docket createRestApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.ciwei.user.controller"))
//				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//				.paths(PathSelectors.any())
//				.build();
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder()
//				.title("用户服务api")
//				.description("用户服务接口文档说明")
//				.contact(new Contact("Ciwei", "", "ciwei@qq.com"))
//				.version("0.1")
//				.license("swagger2")
//				.build();
//	}
//
//	@Bean
//	UiConfiguration uiConfig() {
//		return new UiConfiguration(null, "list", "alpha", "schema",
//				UiConfiguration.Constants.NO_SUBMIT_METHODS, false, true, 60000L);
//	}
//
//}