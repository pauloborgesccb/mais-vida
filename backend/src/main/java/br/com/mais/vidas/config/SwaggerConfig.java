package br.gov.ibama.cdm.config;

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

    @Value("${api-version:#{null}}")
    private String apiVersion;
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo())
                .protocols(protocols())
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("IBAMA - CDM")
                .description("Conversão de Multas Ambientais")
                .contact(new Contact("IBAMA", "http://www.ibama.gov.br", "atendimento@ibama.gov.br"))
                .version(apiVersion)
                .build();
    }

    private Set<String> protocols() {
        Set<String> protocols = new HashSet<>();
        protocols.add("http");
        return protocols;
    }

    private List<? extends SecurityScheme> securitySchemes() {
        List<SecurityScheme> authorizationTypes = Arrays.asList(new ApiKey("token", "Authorization", "header"));
        return authorizationTypes;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts   = Arrays.asList(SecurityContext.builder().forPaths(PathSelectors.any()).securityReferences(securityReferences()).build());
        return securityContexts;
    }

    private List<SecurityReference> securityReferences() {
        List<SecurityReference> securityReferences = Arrays.asList(SecurityReference.builder().reference("token").scopes(new AuthorizationScope[0]).build());
        return securityReferences;
    }

}
