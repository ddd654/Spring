package com.example.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class JpaController {
//
//    @GetMapping("/main")
//    public String main(){
//        return "apple123";
//    }
//
//}
@Controller
public class JpaController {

    @GetMapping("/memoList")
    public String main(){
        return "memoList";
    }

}
