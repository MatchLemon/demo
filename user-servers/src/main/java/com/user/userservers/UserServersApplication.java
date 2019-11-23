package com.user.userservers;

import com.user.userservers.annotation.MyImportBeanDefinitionRegistrar;
import com.user.userservers.annotation.Parent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Import(MyImportBeanDefinitionRegistrar.class)
public class UserServersApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context  = SpringApplication.run(UserServersApplication.class, args);
        Parent parent = (Parent) context.getBean("parent");
        parent.print("start");

    }

}
