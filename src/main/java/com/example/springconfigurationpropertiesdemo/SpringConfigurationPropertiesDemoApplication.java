package com.example.springconfigurationpropertiesdemo;

import com.example.springconfigurationpropertiesdemo.service.Run;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example")
public class SpringConfigurationPropertiesDemoApplication {

    public static void main(String[] args) {

        // https://for-each.dev/lessons/b/-configuration-properties-in-spring-boot

        // https://sky.pro/media/dostup-k-znacheniyam-iz-fajla-application-properties-v-spring-boot/#:~:text=%D0%A2%D0%B0%D0%BA%D0%B8%D0%BC%20%D0%BE%D0%B1%D1%80%D0%B0%D0%B7%D0%BE%D0%BC%2C%20%D0%B7%D0%BD%D0%B0%D1%87%D0%B5%D0%BD%D0%B8%D1%8F%20%D0%B8%D0%B7%20%D1%84%D0%B0%D0%B9%D0%BB%D0%B0,%D0%B7%D0%B0%D0%B4%D0%B0%D1%87%D0%B8%20%D0%B8%20%D0%BB%D0%B8%D1%87%D0%BD%D1%8B%D1%85%20%D0%BF%D1%80%D0%B5%D0%B4%D0%BF%D0%BE%D1%87%D1%82%D0%B5%D0%BD%D0%B8%D0%B9%20%D1%80%D0%B0%D0%B7%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%87%D0%B8%D0%BA%D0%B0.

        ApplicationContext context = SpringApplication.run(SpringConfigurationPropertiesDemoApplication.class, args);
        context.getBean(Run.class).run();

    }

}
