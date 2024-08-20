package com.example.jpa;

import com.example.jpa.entity.Memo;
import com.example.jpa.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class JPAQueryMethodTest03 {

    //메서드 모형으로 SQL 구문 실행시키기
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html 여기꺼 보고 적음

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testCode01() {

        Memo m = memoRepository.findByWriterAndText("test123", "test33321");
        System.out.println(m);

        List<Memo> list = memoRepository.findByMnoLessThan(20L); //20보다 미만
        System.out.println(list.toString());

        //
        Memo mo = memoRepository.findByMno(11L);
        System.out.println(mo.toString());

        List<Memo> list2 = memoRepository.findByMnoBetween(10L, 20L);
        System.out.println(list2.toString());

        List<Memo> list3 = memoRepository.findByWriterLike("%" + "test123" + "%");
        System.out.println(list.toString());

        List<Memo> list4 = memoRepository.findByWriterOrderByWriterDesc("test123");
        System.out.println(list.toString());

        List<Memo> list5= memoRepository.findByMnoIn( Arrays.asList(10L,20L,30L,40L,50L) );
        System.out.println(list.toString());

    }

    @Test
    public void testCode07(){

        //쿼리 + page
        Pageable pageable =PageRequest.of(0, 10, Sort.by("mno").descending());
        List<Memo> list6 = memoRepository.findByMnoLessThanEqual(50L, pageable);

        for (Memo m : list6){
            System.out.println(m.toString());
        }
    }



}
