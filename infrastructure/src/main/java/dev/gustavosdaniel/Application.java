package dev.gustavosdaniel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //serve para permitir que você se comunique com outras APIs HTTP de forma declarativa usando interfaces
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}