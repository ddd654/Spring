package com.simple.basic.config;

import com.simple.basic.command.TestVO;
import com.simple.basic.controller.HomeController;
import com.simple.basic.interceptor.UserAuthHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //1. 스프링 설정파일

//hello.properties 만들고 키값 넣은 후에 아래추가
//@PropertySource("classpath:/hello.properties") //여기 값들을 쓰겠다
public class WebConfig implements WebMvcConfigurer {

    //userAuthHandler를 자바 빈 등록하기
    @Bean
    public UserAuthHandler userAuthHandler(){
        return new UserAuthHandler();
    }

    //인터셉터로 userQuthHandler
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(userAuthHandler())
//                .addPathPatterns("/users/mypage")
//                .addPathPatterns("/users/success")
                .addPathPatterns("/users/*") // 인셉 전부 등록, users 경로로 요청되는것 전부
                .excludePathPatterns("/users/login", "/users/loginForm", "/users/logout") //제외할 경로 적기
                ;

        //종류별로 다양한 인터셉터를 추가
        //registry.addInterceptor()

    }

    //키값 넣기
    @Value("${server.port}")// application.server 포트 값
    String port;

    @Value("${hello}")
    String hello;

//    //키 넣어서
//    @Value("${bye}")
//    String bye; //저장하고 쓰기 << 중요함

    @Autowired
    ApplicationContext applicationContext;
    
    //자바코드로 빈 생성하기 = testVO를 빈으로 등록한다
    @Bean
    public TestVO testVO(){
        return new TestVO(); //bean으로 관리, applicationcontext에서 관리된다
    }
    
    //빈을 관리하는 객체
    @Bean //스프링이 이 코드를 실행시켜서, 리턴에 담기는 값을 bean으로 등록
    public void test() {

        System.out.println("스프링 설정파일 실행됨");

        int result = applicationContext.getBeanDefinitionCount();
        System.out.println("context안에 빈의 개수:  " + result);


        HomeController home = applicationContext.getBean(HomeController.class);
        System.out.println("context안의 home 컨트롤러: " + home);

        System.out.println("properties server : " + port);
        System.out.println("properties hello 값 : " + hello);
        //System.out.println("        " + bye);


        TestVO vo = applicationContext.getBean(TestVO.class);
        System.out.println("TestVO의 값들  " + vo);



    }


}
