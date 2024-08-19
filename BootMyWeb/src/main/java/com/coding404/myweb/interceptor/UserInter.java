package com.coding404.myweb.interceptor;

import com.coding404.myweb.command.UsersVO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//인터셉터 임플
public class UserInter implements HandlerInterceptor {

    //컨 i
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        UsersVO vo = (UsersVO) session.getAttribute("userVO"); //로그인 정보

        if (vo == null) { //세션이 없으니 로그인 페이지로
            response.sendRedirect("/user/login");
            return false;
        }


        return true;
    }
}