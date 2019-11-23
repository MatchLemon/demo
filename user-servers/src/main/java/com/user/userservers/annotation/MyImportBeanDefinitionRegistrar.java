package com.user.userservers.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Map;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
//        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(Open.class.getName());
//
//        String[] basePackages = (String[]) annotationAttributes.get("basePackages");
//
//        //扫描类
//        ClassPathBeanDefinitionScanner scanner =
//                new ClassPathBeanDefinitionScanner(registry, false);
//        //TypeFilter helloServiceFilter = new AssignableTypeFilter(HelloService.class);
//
//        //scanner.addIncludeFilter(helloServiceFilter);
//        scanner.scan(basePackages);

        MyClasssPathBeanDefinitionScanner scanner = new MyClasssPathBeanDefinitionScanner(registry,false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Open.class));
        scanner.doScan("com.user.userservers.annotation");



        System.out.println("111111");
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

    }
}
