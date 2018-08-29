package br.med.maisvidas.config;

import java.util.*;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo())
                .protocols(protocols());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Mais vidas")
                .description("Api - Mais vidas")
                .contact(new Contact("Mais vidas", "http://maisvida.med.br", "mais.vida@maisvida.med.br"))
                .version("0.0.1")
                .build();
    }

    private Set<String> protocols() {
        Set<String> protocols = new HashSet<>();
        protocols.add("http");
        return protocols;
    }

}
