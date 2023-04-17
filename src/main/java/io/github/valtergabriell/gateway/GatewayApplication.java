package io.github.valtergabriell.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator router(RouteLocatorBuilder locatorBuilder) {
        return locatorBuilder.routes()
                .route(r -> r.path("/account/**").uri("lb://msaccount"))
                .route(r -> r.path("/credit/**").uri("lb://mscredit"))
                .route(r -> r.path("/card/**").uri("lb://mscard"))
                .route(r -> r.path("/products/**").uri("lb://msshopping"))
                .build();
    }

}
