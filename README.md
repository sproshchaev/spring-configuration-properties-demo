# spring-configuration-properties-demo

В этом Demo пример работы с application.properties на основе:
1) Чтения данных из application.properties через @Value, конфигурационный класс AppConfig.class
2) Создание разных версий бинов в зависимости от значения application.properties через @ConditionalOnProperty(name = "app.name", havingValue = "2")
3) Использование @Profile при создании бинов в контексте через AnnotationConfigApplicationContext
4) Перерегистрация бина в контексте через DefaultSingletonBeanRegistry

### References
1. Легко деплоить сервисы в разные среды https://medium.com/@ekaterina.khudiakova/https-medium-com-ekaterina-khudiakova-spring-environment-profiles-and-properties-c712685ea7a7
2. Перерегистрация бина в контексте https://www.baeldung.com/spring-reinitialize-singleton-bean
