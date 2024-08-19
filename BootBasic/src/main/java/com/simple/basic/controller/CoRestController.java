package com.simple.basic.controller;

import com.simple.basic.command.MemoVO;
import com.simple.basic.command.TestVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CoRestController {

     /*
    요청주소 : /api/v1/getData
    method : get
    요청 parameter : sno(숫자), name(문자)
    응답 parameter : MemoVO
    header 내용 : HttpStatus.OK
    */

    /*
    요청주소 : /api/v1/getInfo
    메서드 : post
    요청 파라미터 : MemoVO타입
    응답 파라미터 : List<MemoVO>타입
    헤더에 담을 내용 HttpStatus.OK, 컨텐츠타입

    fetch API 사용해서 클라이언트에 요청 응답
    */
                ///api/v1/getData/{}/{} 패스베리어블 방식

    @GetMapping("/api/v1/getData")
    public ResponseEntity<MemoVO> hello_ex(@RequestParam("name1") int name1,
                                           @RequestParam("name2") String name2  ){

        System.out.println(name1 +"~~"+ name2);
        return new ResponseEntity<MemoVO>(
                new MemoVO( 1L, "사과", "33", "44","55")
                ,HttpStatus.OK
        );
    }

    @PostMapping("/api/v1/getInfo")
    public ResponseEntity<List<MemoVO>> getInfo(@RequestBody @Valid MemoVO vo,
                                                BindingResult result
                                            ){
        if (result.hasErrors()){
            System.out.println("유효성 실패");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        List<MemoVO> list = new ArrayList<>();
        list.add(vo);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }




















}
