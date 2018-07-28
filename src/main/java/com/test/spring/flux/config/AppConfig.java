package com.test.spring.flux.config;

import com.test.spring.flux.handlers.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AppConfig {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(HelloHandler helloHandler){
        return RouterFunctions.route(RequestPredicates.GET("/hello")
                              .and(RequestPredicates.accept(MediaType.TEXT_PLAIN,MediaType.TEXT_HTML))
                              ,helloHandler::sayHello);
    }
}
