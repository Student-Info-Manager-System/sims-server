package com.cloud.sims.common.config.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.base.Predicates;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    @Value("${cloud.title}")
    private String title;

    @Value("${cloud.desc}")
    private String desc;

    @Value("${cloud.version}")
    private String version;

    @Value("${cloud.user.author}")
    private String author;

    @Value("${cloud.user.email}")
    private String email;

    @Value("${cloud.user.url}:${server.port}")
    private String url;

    @Value("${swagger.enabled}")
    private Boolean enabled;





//    @Bean
//    public Docket createApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(enabled)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
//                .build();
//    }




    @Bean(value = "SIMS")
    public Docket lsst() {
//        Predicate<RequestHandler> model = RequestHandlerSelectors.basePackage("com.cloud.sims.business.lost.lost.**.web.rest");
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enabled)
                .apiInfo(apiInfo())
                .groupName("Main")
                .select()
//                .apis(model)
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }





    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BootStage API")
                .licenseUrl(url + "/doc.html")
                .license("API 接口文档")
                .contact(new Contact(author, url, email))
                .description(desc)
                .version(version)
                .title(title)
                .build();
    }
}
