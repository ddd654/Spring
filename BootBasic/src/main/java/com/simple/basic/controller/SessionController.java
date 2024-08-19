package com.simple.basic.controller;

import com.simple.basic.command.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class SessionController {

    @GetMapping("/login")
    public String login() {
        return "users/login";

    }

    @GetMapping("/mypage")
    public String mypage() {
        return "users/mypage";

    }

    @GetMapping("/success")
    public String success( HttpSession session) {

//        //mypage, success 는 세션이 없으면 접근 막기
//        UserVO vo= (UserVO)session.getAttribute("userVO");
//        if (vo == null) {
//            return "redirect:/users/success";
//        }




        return "users/success";
    }

    //-----------
    //로그인 요청
    @PostMapping("/loginForm")
    public String loginForm(UserVO vo, HttpSession session
    ) {

        //로그인 시도
        //SELECT * FROM 테이블명 WHERE ID = ? AND PW = PW
        UserVO result = vo;// 로그인이 성공인 가정 > vo 정보 저장
        if (result == null) {
            //로그인 실패
            return "redirect:/users/login";
        } else {
            //로그인 성공 > 세션에 회원정보 저장
            session.setAttribute("userVO", result);
            return "redirect:/users/success";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session
    ) {
        
        session.invalidate(); //세션 없애기, 무효화

        return "redirect:/users/login";
    }


}
