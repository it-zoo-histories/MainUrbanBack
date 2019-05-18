package com.stopysinger.core.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RoutesApi {
    public static void  main(String[] args) {
        SpringApplication.run(RoutesApi.class, args);
    }
}
