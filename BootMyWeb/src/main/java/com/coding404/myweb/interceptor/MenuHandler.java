package com.coding404.myweb.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuHandler implements HandlerInterceptor {

    //post 치고 엔타
    //사용자가 클릭한 메뉴의 URI 주소를 기록해서, 클라이언트에 보낸다
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        String uri = request.getRequestURI();

        System.out.println("선택된 menu: " + uri);
        request.setAttribute("menu", uri);

    }









}
