package com.pedix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com"})
public class PedixBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PedixBackendApplication.class, args);
    }

}
