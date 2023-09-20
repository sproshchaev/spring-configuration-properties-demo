package com.example.springconfigurationpropertiesdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
@ConfigurationPropertiesScan
@PropertySource("classpath:application.properties") // можно не указывать
public class AppConfig {
    private String name;
    private String version;
    private String developer;

    public AppConfig() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", developer='" + developer + '\'' +
                '}';
    }
}
