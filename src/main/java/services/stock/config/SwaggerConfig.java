package services.stock.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .genericModelSubstitutes(ResponseEntity.class)
                .globalResponseMessage(RequestMethod.POST, globalResponseMessages())
                .globalResponseMessage(RequestMethod.GET, globalResponseMessages())
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(false)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("JWT", authorizationScopes));
    }

    private List<ResponseMessage> globalResponseMessages() {
        List<ResponseMessage> messages = new ArrayList<>();

        messages.add(response(HttpStatus.UNAUTHORIZED, "HTTP basic auth parameters are wrong or empty"));
        messages.add(response(HttpStatus.FORBIDDEN, "Credentials are not enough to view requested resource"));

        messages.add(response(HttpStatus.OK, "Request processed successfully"));
        messages.add(response(HttpStatus.CREATED, "New resource created successfully"));

        messages.add(response(HttpStatus.BAD_REQUEST, "Request parameters are invalid"));
        messages.add(response(HttpStatus.NOT_FOUND, "Requested resource was not found"));
        messages.add(response(HttpStatus.INTERNAL_SERVER_ERROR, "Server was unable to process the request"));

        messages.add(response(HttpStatus.BAD_GATEWAY, "Downstream server returned unknown response"));
        messages.add(response(HttpStatus.GATEWAY_TIMEOUT, "Downstream server did not return in time"));
        messages.add(response(HttpStatus.SERVICE_UNAVAILABLE, "Downstream server is not available"));

        return messages;
    }

    private ResponseMessage response(HttpStatus status, String message) {
        return new ResponseMessageBuilder().code(status.value()).message(message).build();
    }
}
