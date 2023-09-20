package com.example.springconfigurationpropertiesdemo.service;

import com.example.springconfigurationpropertiesdemo.config.AppConfig;
import com.example.springconfigurationpropertiesdemo.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;

@Service
public class Run {
    private final AppConfig appConfig;
    private final ApplicationContext context;
    private final ConfigurableEnvironment configurableEnvironment;

    @Value("${app.name}")
    private String appName;

    public Run(AppConfig appConfig, GenericApplicationContext context, ConfigurableEnvironment configurableEnvironment) {
        this.appConfig = appConfig;
        this.context = context;
        this.configurableEnvironment = configurableEnvironment;
    }

    public void run() {
        System.out.println("1) Чтение из @Value appName=" + appName);
        System.out.println("2) Чтение из класса appName=" + appConfig.getName());
        System.out.println("3) Создание бина MyDataSource в зависимости от app.name=1/2 из application.properties: " + context.getBean("MyDataSource"));
        System.out.println();

        // Теперь меняем app.name=1 на app.name=2 - ничего не происходит, так как в контексте по прежнему app.name=1
        appConfig.setName("2");
        System.out.println("4) Хоть мы и изменили appConfig.setName(\"2\"), но по прежнему бин " + context.getBean("MyDataSource"));

        // Чтение переменных из Окружения контекста
        System.out.println("5) Чтение переменных из Окружения контекста:");
        System.out.println(" ${app.name}=" + context.getEnvironment().resolvePlaceholders("${app.name}"));
        System.out.println(" ${app.version}=" + context.getEnvironment().resolvePlaceholders("${app.version}"));
        System.out.println(" ${app.version}=" + context.getEnvironment().getProperty("app.version"));
        System.out.println("app.name=" + configurableEnvironment.getPropertySources().get("configurationProperties").getProperty("app.name"));
        System.out.println("");

        // Создаем профиль "local" и активируем его
        System.out.println("6) Создаем профиль \"local\" и активируем его, в нем появляется бин с @Profile('local')");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("local");
        ctx.register(Config.class);
        ctx.refresh();
        System.out.println(ctx.getBean("MyDataSource2"));

        // Создаем профиль "global" и активируем его
        System.out.println("7) Создаем профиль \"global\" и активируем его, в нем появляется бин с @Profile('global')");
        AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
        ctx2.getEnvironment().setActiveProfiles("global");
        ctx2.register(Config.class);
        ctx2.refresh();
        System.out.println("\"MyDataSource2\"=" + ctx2.getBean("MyDataSource2"));

        // Регистрируем новый бин в контексте https://www.baeldung.com/spring-reinitialize-singleton-bean
        System.out.println("8) Регистрация бина в контексте:");
        DefaultSingletonBeanRegistry registry = (DefaultSingletonBeanRegistry) context.getAutowireCapableBeanFactory();
        // registry.destroySingleton("..."); <- удаляем
        registry.registerSingleton("MyDataSource2", ctx.getBean("MyDataSource2"));
        System.out.println("  \"MyDataSource2\"=" + context.getBean("MyDataSource2"));

        System.out.println("9) Перерегистрация бина в контексте:");
        registry.destroySingleton("MyDataSource2"); // удаляем бин из контекста
        registry.registerSingleton("MyDataSource2", ctx2.getBean("MyDataSource2")); // регистрируем новый бин
        System.out.println("  \"MyDataSource2\"=" + context.getBean("MyDataSource2"));

    }

}
