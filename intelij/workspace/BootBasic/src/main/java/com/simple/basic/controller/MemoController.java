package com.simple.basic.controller;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/memo")
public class MemoController {
    //2. memoService 주입 > impl
    @Autowired
    //@Qualifier("memoService")
            MemoService memoService;

    @GetMapping("/memoWrite")
    public String memoWrite(Model model123) {

        //유효성 검사 마지막 단계
        model123.addAttribute("vo", new MemoVO());


        return "memo/memoWrite";
    }

    //memo 기능 검사하기
    @PostMapping("/memoForm")
    public String memoForm(@Valid @ModelAttribute("vo") MemoVO vo, BindingResult bind) {
        if (bind.hasErrors()) { //에러 있으면
            return "memo/memoWrite";
        }
//insert
        //MemoService > MemoMapper.java > MemoMapper.xml > impl > controller
        memoService.regist(vo);


        return "redirect:/memo/memoList";
    }
    //목록 List화면
    @GetMapping("/memoList")
    public String memoList(Model model){
//select
        ArrayList<MemoVO> list = memoService.getList();
        model.addAttribute("list", list);
        return "memo/memoList";
    }


}
