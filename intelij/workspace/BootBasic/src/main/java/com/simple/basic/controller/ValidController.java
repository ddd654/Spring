package com.simple.basic.controller;

import com.simple.basic.command.ValidVO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

//컨트롤러 > html >확인 > VO
@Controller
@RequestMapping("/valid")
public class ValidController {

    @GetMapping("/view")
    public String valid(){
        return "valid/view";
    }

    @PostMapping("/actionForm")
    public String action(@Valid ValidVO vo, BindingResult binding){
        
        //@valid는 유효성 검사를 하겠음
        // 검사를 통과 못하면 > 에러 내역이 BindingResult에 저장된다
        
        if (binding.hasErrors()){ // 내역이 있으면 true, 아미녀 false
            System.out.println("유효성 검사 실패");
            
            List<FieldError> list= binding.getFieldErrors(); // 유효성 검사에 실패한 목록

            for (FieldError err : list){
                System.out.println(err.getField());
                System.out.println(err.getDefaultMessage());

            }

        }
        
        
        //처리코드
        System.out.println(vo.toString());

        return "valid/view_result";
    }

}

