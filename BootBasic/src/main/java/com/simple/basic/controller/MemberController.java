package com.simple.basic.controller;

import com.simple.basic.command.MemberVO;
import com.simple.basic.command.ValidVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/valid")
public class MemberController {

    @GetMapping("/quiz001")
    public String quiz001(Model model333) {


        model333.addAttribute("vo", new MemberVO());
        return "valid/quiz001";
    }

    @PostMapping("/quizForm")
    //유효성 검사가 @Valid
    //원래값 유지는 @ModelAttribute vo 값 전달
    public String form(@Valid @ModelAttribute("vo") MemberVO vo, BindingResult bindingResult) {

        //에러가 있으면
        if (bindingResult.hasErrors()) {
            //원래화면으로
            return "valid/quiz001";
        }

        //아니면 통과화면
        return "valid/view_result";
    }
}
