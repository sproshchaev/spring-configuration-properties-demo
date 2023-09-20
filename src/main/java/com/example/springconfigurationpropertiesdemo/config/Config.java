package com.example.springconfigurationpropertiesdemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@Configuration
public class Config {

    @Bean(name = "MyDataSource")
    @Primary
    @ConditionalOnProperty(name = "app.name", havingValue = "1")
    public String dataSource1() {
        System.out.println("Создание dataSource1()");
        return "DataSource 1";
    }

    @Bean(name = "MyDataSource")
    @ConditionalOnProperty(name = "app.name", havingValue = "2")
    public String dataSource2() {
        System.out.println("Создание dataSource2()");
        return "DataSource 2";
    }

    @Profile("local")
    @Bean(name = "MyDataSource2")
    public String dataSource3() {
        System.out.println("Создание dataSource3()");
        return "DataSource 3";
    }

    @Profile("global")
    @Bean(name = "MyDataSource2")
    public String dataSource4() {
        System.out.println("Создание dataSource4()");
        return "DataSource 4";
    }


    // https://medium.com/@ekaterina.khudiakova/https-medium-com-ekaterina-khudiakova-spring-environment-profiles-and-properties-c712685ea7a7
    /*@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:sql/schema.sql", "classpath:sql/data.sql")
                .build();
    } */


}
