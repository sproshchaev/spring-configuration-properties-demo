package com.example.springconfigurationpropertiesdemo.service;

@org.springframework.stereotype.Service
public class ServiceB implements Service {

    public ServiceB() {
        System.out.println("создание ServiceB");
    }

    @Override
    public void runService() {
        System.out.println("Run Service B");
    }
}
