package com.simple.basic.controller;

import com.simple.basic.command.TestVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController //Controller + ResponseBody 의 합성어
public class RestBasicController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "123";
    }

    @GetMapping("/apple")
    public String[] apple() { //pretty print 데이터 쉽게 보기?
        return new String[]{"사과", "바나나"};
    }

    // >
    /////////////////
    //크롬 부메랑으로 데이터 확이하기
    //http://localhost:8181/getData?num=1&name=사과
    public String getData(TestVO vo) {

        System.out.println("전송되나 12321");

        return "getData";
    }

//    @GetMapping("/getData")
//    public String getData(@RequestParam("num") int num,
//                          @RequestParam("name") String name) {
//        System.out.println("넘어오나 확인~   " + num + "  ,  " + name);
//
//        return "getData";
//    }

    //패스베리어블 방식
    //http://localhost8181/getData2/1/홍길동
    @GetMapping("/getData2/{num}/{name}")
    public String getData2(@PathVariable("num") int num,
                           @PathVariable("name") String name) {

        System.out.println(num + "  " + name);
        return "success";
    }

    //반환을 JSON 형식으로 하려면 Map, vo를 사용한다
    //Jackson-databind 라이브러리가 필요함 -스프링부트에 기본 포함
    @GetMapping("/returnData")
    public TestVO returnData() {
        return new TestVO(1, "서버에서 반환", 20, "서울시");
    }

    //데이터 보내는 예시2
    //http://localhost:8181/returnData
    @GetMapping("/returnData2")
    public Map<String, Object> returnDate() {
        Map<String, Object> map = new HashMap<>();
        map.put("num", 1);
        map.put("name", "사과");
        map.put("arr", Arrays.asList("레몬", "키위", "수박"));

        return map;
    }

    ///////////////////////////////
    //post 방식 - 사용자와 제공자(서버), 이 둘의 데이터를 주고 받는 규약이 정확하게 이루어진다/
    //데이터를 body 에 싣고 form 형식으로 전송한다
    //http://localhost:8181/getForm
    @PostMapping("/getForm")
    public String getForm(TestVO vo) { //form 타입 받을때 매개변수
        System.out.println("~~~~~~~~~~~~~" + vo.toString());

        return "굿굿";
    }

    //JSON 방식으로 데이터 전송
    // @RequestBody 인자로 JSON 데이터를 자바 Object로 받을때 사용한다
//    @PostMapping("/getJSON")
//    public String getJSON(@RequestBody TestVO vo){ //JSON 받을때 인자 @RequestBody  필요, 매핑되서 들어옴
//        System.out.println("사과 바나나 " + vo.toString());
//        return "nice";
//    }

    //Map으로 받는 경우, 잘 안씀
    @PostMapping("/getJSON")
    public String getJSON(@RequestBody Map<String, Object> map) { //JSON 받을때 인자 @RequestBody  필요, 매핑되서 들어옴
        System.out.println("사과 바나나 " + map.toString());
        return "nice";
    }

    //수정용 @PutMapping

    ///////////////////////////////////////////

    //consumer - 반드시 특정 데이터타입으로 보내자
    //Produces - 서버에서 오는 데이터는 특정타입으로 보낸다

    //기본값 = "application/json"

    //                                   응답                     요청
    @PostMapping(value = "/getResult", produces = "text/html", consumes = "application/json") //
    public String getResult(@RequestBody TestVO vo) {

        return "<h3>문자열~~~~~~~~~~</h3>";
    }

    /////////////////////
    //응답문서 명확하게 작성하기

    //@CrossOrigin("http://127.0.0.1:5500")
    @CrossOrigin("*") //모든 서버에 대한 요청 승인
    @PostMapping("/getEntity")
    public TestVO getEn() {
        TestVO vo = new TestVO(33, "코코넛", 11, "파주");

        System.out.println("!!!!!!!!!!!!!!!!" + vo.toString());
        return vo;
    }

    @PostMapping("/getEntity2")
    public ResponseEntity<TestVO> getEntity() {
        TestVO vo = new TestVO(33, "코코넛", 11, "파주");
        ResponseEntity entity = new ResponseEntity(vo, HttpStatus.OK);

        return entity;
    }

    @PostMapping("/getEntity3")
    public ResponseEntity<TestVO> getEntity3() {
        TestVO vo = new TestVO(33, "코코넛", 11, "파주");

        HttpHeaders header = new HttpHeaders();
        header.add("authorization", "Join Web");
        header.add("Context type", "application/json");
        header.add("Access-Control-Allow-Origin", "http://example.com");
        //이 주소에 요청을 승인한다 cors 주의

        ResponseEntity entity = new ResponseEntity(vo, header, HttpStatus.OK); // 데이터, 헤더, 상태값

        return entity;
    }

///////////////////////////////////////

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


}
