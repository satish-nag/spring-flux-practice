package com.test.spring.flux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        List<String> a = new ArrayList<>();
        a.add("satish");
        System.out.println(a);
        a.add("ranjit");

        SpringApplication.run(App.class,args);
        Mono<ClientResponse> responseMono = WebClient.create("http://localhost:8001")
                                                     .get()
                                                     .uri("/hello")
                                                     .accept(MediaType.TEXT_PLAIN)
                                                     .header("Content-Type",MediaType.TEXT_PLAIN_VALUE)
                                                     .exchange();
        System.out.println(responseMono.flatMap(resp -> resp.bodyToMono(String.class)).block());
    }

}
