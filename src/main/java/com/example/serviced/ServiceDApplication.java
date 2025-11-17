package com.example.serviced;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceDApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDApplication.class, args);
    }

    @Value("${spring.application.name:ServiceD}")
    private String serviceName;

    @GetMapping("/data")
    public String getSimpleData() {
        return String.format("Data from %s (fast response)", serviceName);
    }

    @GetMapping("/healthz")
    public String healthCheck() {
        return "{\"status\":\"healthy\"}";
    }
}
