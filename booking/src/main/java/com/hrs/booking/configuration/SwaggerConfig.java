package com.hrs.booking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

/**
 * The type Swagger config.
 */
@Configuration

public class SwaggerConfig {

    /**
     * Produce api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket produceApi(){
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.hrs.booking.controller")).paths(paths()).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Booking Information").description("This is an app to get booking information").version("0.1").build();
    }

    private Predicate<String> paths(){
        return PathSelectors.regex("/.*");
    }
}
