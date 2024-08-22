package com.example.jpa;

import com.example.jpa.entity.Memo;
import com.example.jpa.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class JPABasicTest01 {

    @Autowired
    MemoRepository memoRepository; //선언

    @Test
    public void testCode01() { // 이거 실행하면 DB에 insert 된다

        for (int i = 1; i < 100; i++) {

            memoRepository.save(Memo.builder()
                    .writer("test123" + i)
                    .text("test33321" + i)
                    .build()
            );
        }
    }

    @Test
    public void testCode02(){ //select - find가 붙은 메서드를 사용
        Optional<Memo> result =memoRepository.findById(50L); //50번 확인?

        if(result.isPresent()){//값이 없으면 true
            Memo m = result.get();
            System.out.println(m.toString());
            
        } else { //값이 없을때
            System.out.println("조회할 것이 없어");
        }
    }

    @Test
    public void testCode03(){ //전체 select
        List<Memo> list=memoRepository.findAll();
        for (Memo m : list){
            System.out.println(m.toString());
        }
    }

    
    @Test
    public void testCode04() { //update해서 save 합니다

        Memo result =
        memoRepository.save(
                Memo.builder()
                        .mno(50L)
                        .writer("업데이트")
                        .text("update!")
                        .build()
        );

        System.out.println("업데이트 중...        :      " + result);
    }


    @Test
    public void testCode05() { //delete - 삭제는 delete or deleteById
        memoRepository.deleteById(50L); //50번꺼 삭제하기
    }



}
