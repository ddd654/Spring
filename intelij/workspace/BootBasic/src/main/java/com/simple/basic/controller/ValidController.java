package com.simple.basic.controller;

import com.simple.basic.command.ValidVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

//컨트롤러 > html >확인 > VO
@Controller
@RequestMapping("/valid")
public class ValidController {

    @GetMapping("/view")
    public String valid(Model model12) {

        //4. 오류, 이 화면에 진입할때 vo가 없으면, 에러가 난다 > 급여 한글막기 > messages.properties
        model12.addAttribute("vo", new ValidVO());

        return "valid/view";
    }

    @PostMapping("/actionForm")
    public String action(@Valid @ModelAttribute("vo") ValidVO vo, BindingResult binding) {

        //@valid는 유효성 검사를 하겠음
        // 검사를 통과 못하면 > 에러 내역이 BindingResult에 저장된다

        if (binding.hasErrors()) { // 내역이 있으면 true, 아미녀 false
//            System.out.println("유효성 검사 실패");
//
//            List<FieldError> list= binding.getFieldErrors(); // 유효성 검사에 실패한 목록
//
//            for (FieldError err : list){
//                System.out.println(err.getField());
//                System.out.println(err.getDefaultMessage());
//
//            }

            //08-08
            //다시 원래화면으로 
            // 1. 위 괄호에 @ModelAttribute 추가해서 갖고간다 > view
            return "valid/view";
        }
        //처리코드
        System.out.println(vo.toString());


        return "valid/memo_result";
    }


//    @GetMapping("/quiz001")
//    public String quiz001(Model model333) {
//
//        model333.addAttribute("vo", new ValidVO());
//        return "valid/quiz001";
//    }
//
//    @PostMapping("/quizForm")
//    public String form(@Valid @ModelAttribute("vo") ValidVO vo, BindingResult bindingResult) {
//
//        //에러가 있으면
//        if (bindingResult.hasErrors()) {
//            //원래화면으로
//            return "valid/quiz001";
//        }
//
//        //아니면 통과화면
//        return "valid/view_result";
//    }























}

