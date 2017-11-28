package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Application class to run the whole application
@SpringBootApplication  // brings @Configuration, @EnableAutoConfiguration and @ComponentScan
public class Application {

    // psvm and SpringApplication.run(Application.class, args) to run the Application
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}