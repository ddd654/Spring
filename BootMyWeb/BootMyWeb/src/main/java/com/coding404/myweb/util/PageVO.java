package com.coding404.myweb.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data // getter, setter
public class PageVO {
    //화면에 그려질 pageNation

    private int start;
    private int end;
    private boolean prev;
    private boolean next;

    private int page; // citeria 한테 있음, 현재 페이지 번호
    private int amount; // 한 페이지에서 게시글 수량

    private int total; //총 게시글 수
    private int realEnd; // 맨 마지막 페이지

    private Criteria cry;

    private List<Integer> pageList; //page 네이션 번호를 리스트로 저장, 생성

    //생성자
    public PageVO(Criteria cry, int total) {//Criteria 객체, total 받기

        this.page = cry.getPage();
        this.amount = cry.getAmount();
        this.total = total;
        this.cry = cry;
        //위 4개 초기화 됨 > 이제 값구하기

        //페이지 계산하기(멤버변수)

        //끝페이지 =올림(현재 조회할, 표시할 페이지 / 페이지개수) *10
        this.end = (int) Math.ceil(this.page / 10.0) * 10;
        this.start = end - 10 + 1;
        //시작페이지 = 끝번호 - 페이지개수 +1

        //실제 끝번호 재계산, 끝페이지 갔을때 이상해진다고 한다
        //끝 번호 = 올림(총 게시글 수 / 조회할 데이터 개수)
        this.realEnd = (int) Math.ceil( this.total / (double)this.amount);

        //end
        //112개 게시물 >  1~10 페이지, end-10, realEnd=12
        //            > 11~20 페이지, end=20, realEnd=12

        //this.end = end > realEnd ? realEnd : end;
        //ex) 총게시글에따라 페이지 칸을 보여준다
        if (end > realEnd){
            this.end = this.realEnd;
        }

        //이전버튼
        //strat 값의 증가는 1, 11, 21, 31
        this.prev = this.start > 1;

        //다음버튼 활성화 여부
        this.next = this.realEnd > this.end;

        this.pageList = IntStream.rangeClosed(this.start, this.end).boxed().collect(Collectors.toList());



    }


}
