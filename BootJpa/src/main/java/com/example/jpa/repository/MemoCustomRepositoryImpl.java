package com.example.jpa.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class MemoCustomRepositoryImpl implements MemoCustomRepository {
    //MemoRepository가 MemoCustomRepository를 상속받아줍니다.

    @PersistenceContext //엔티티 매니저를 주입을 받을 때 사용하는 어노테이션
    private EntityManager entityManager;

    @Transactional
    @Override
    public int updateTest(String writer, long mno) {
        //기존에 JPQL 구문 작성 가능
        String sql = "update Memo m set m.writer = :a where m.mno = :b";
        Query query = entityManager.createQuery(sql);
        query.setParameter("a", writer);
        query.setParameter("b", mno);

        int result = query.executeUpdate(); //insert, delete, update
        return result;
    }










}
