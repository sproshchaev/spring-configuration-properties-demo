package com.example.springconfigurationpropertiesdemo.service;


@org.springframework.stereotype.Service
public class ServiceA implements Service {

    public ServiceA() {
        System.out.println("создание ServiceA");
    }

    @Override
    public void runService() {
        System.out.println("Run Service A");
    }
}
