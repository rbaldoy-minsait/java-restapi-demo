package org.minsait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application entrypoint.
 *
 */
@SpringBootApplication(scanBasePackages = "org.minsait")
public class PruebaJavaRestApi {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(PruebaJavaRestApi.class);
        application.run(args);
    }
}