package com.study.swagger.config;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.google.common.base.Predicates;
import com.study.swagger.annotation.CrovApi;
import com.study.swagger.annotation.DobaApi;
import com.study.swagger.annotation.MicApi;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String DOBA_GROUP = "doba_group";
    public static final String CROV_GROUP = "crov_group";
    public static final String MIC_GROUP = "mic_group";

    /**
     * 创建API
     */
    @Bean
    public Docket createCorvRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(CROV_GROUP)
                .apiInfo(apiCorvInfo("3.0.0"))
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.focustech.silk.volcanoland.web.controller"))
                //.apis(RequestHandlerSelectors.withClassAnnotation(CrovApi.class))
                .apis(RequestHandlerSelectors.withMethodAnnotation(CrovApi.class))
                //.apis(Predicates.or(RequestHandlerSelectors.withMethodAnnotation(CrovApi.class),RequestHandlerSelectors.withClassAnnotation(CrovApi.class)))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createDobaRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(DOBA_GROUP)
                .apiInfo(apiDobaInfo("3.0.0"))
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.focustech.silk.volcanoland.web.controller"))
                //.apis(RequestHandlerSelectors.withClassAnnotation(DobaApi.class))
                .apis(Predicates.or(RequestHandlerSelectors.withMethodAnnotation(DobaApi.class),RequestHandlerSelectors.withClassAnnotation(DobaApi.class)))
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    public Docket createMICRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(MIC_GROUP)
                .apiInfo(apiMICInfo("3.0.0"))
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.focustech.silk.volcanoland.web.controller"))
                .apis(RequestHandlerSelectors.withClassAnnotation(MicApi.class))
                .paths(PathSelectors.any())
                .build();
    }


    @Bean
    public RequestMappingInfoHandlerMapping requestMapping() {
        return new RequestMappingHandlerMapping();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiCorvInfo(String version) {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("CROV Order Api Documentation")
                .version(version)
                .build();
    }


    /**
     * 添加摘要信息
     */
    private ApiInfo apiDobaInfo(String version) {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("DOBA Order Api Documentation")
                .version(version)
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiMICInfo(String version) {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("MIC Order Api Documentation")
                .version(version)
                .build();
    }
}
