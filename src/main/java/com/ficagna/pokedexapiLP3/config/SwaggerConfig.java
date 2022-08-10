package com.ficagna.pokedexapiLP3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


    @Configuration
    @EnableWebMvc
    @EnableSwagger2
    public class SwaggerConfig {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.pokedex-api.pokedex-api"))
                    .build()
                    .apiInfo(metaData());
        }

        private ApiInfo metaData() {
            return new ApiInfoBuilder()
                    .title("SpringBoot RESTful Pokemon Api")
                    .description("\"Spring Boot REST API\"")
                    .version("1.0.0")
                    .license("Apache License Version 2.0")
                    .licenseUrl("https://www.apache.org/license/LICENSE'2.0\"")
                    .build();
        }
    }

