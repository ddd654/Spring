package com.coding404.myweb.config;

import com.coding404.myweb.interceptor.MenuHandler;
import com.coding404.myweb.interceptor.UserInter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 설정 파일
public class WebConfig implements WebMvcConfigurer {

    //인셉 빈등록
    @Bean
    public UserInter userInter(){
        return new UserInter();
    }
    //메뉴처리 인터셉터123
    @Bean
    public MenuHandler menuHandler(){
        return new MenuHandler();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(userInter())
                .addPathPatterns("/product/*") //상품관련 내역에 모두 추가
                .addPathPatterns("/")// 메인페이지
        ;

        registry.addInterceptor(menuHandler())
                .addPathPatterns("/product/*") // 메뉴 Post 핸들러가 동작할 곳
                ;
    }





}
