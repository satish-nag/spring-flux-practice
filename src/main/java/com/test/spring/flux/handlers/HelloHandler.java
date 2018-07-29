package com.test.spring.flux.handlers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@CrossOrigin
public class HelloHandler {

    public Mono<ServerResponse> sayHello(ServerRequest serverRequest){
        return ServerResponse.ok().body(BodyInserters.fromObject("Hello world Developer"));
    }

    public Mono<ServerResponse> greet(ServerRequest serverRequest){
        return ServerResponse.ok().body(BodyInserters.fromObject("Hi there from spring flux"));
    }

    public Mono<ServerResponse> greetHello(ServerRequest serverRequest){
        System.out.println(serverRequest);
        return ServerResponse.ok().body(BodyInserters.fromObject("Hi there from spring flux"));
    }

    public Mono<ServerResponse> greetHelloOnceMore(ServerRequest serverRequest){
        return ServerResponse.ok().body(BodyInserters.fromObject("Hi there from spring flux"));
    }

    public Mono<ServerResponse> greetHello1(ServerRequest serverRequest){
        System.out.println("serverrequest "+serverRequest);
        return ServerResponse.ok().body(BodyInserters.fromObject("Hi there from spring flux"));
    }
}
