package com.example.coco.config;

import com.example.coco.command.AppleVO;
import com.example.coco.controller.AppController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/apple1.properties")
public class WebConfig {

    @Value("${server.port}")
    String port;

    @Value("${coco}")
    String coco;

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public AppleVO appleVO(){
        return new AppleVO();
    }

    @Bean
    public void apple(){
        System.out.println("스프링 설정파일 시작!");

        int result = applicationContext.getBeanDefinitionCount();
        System.out.println("context안 빈 개수  "  + result);

        AppController app = applicationContext.getBean(AppController.class);
        System.out.println("app 컨트롤러~   "+ app);

        System.out.println("properties server : " + port);

        System.out.println("delicious  " + coco);

    }



}
