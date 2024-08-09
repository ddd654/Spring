package com.coding404.myweb.product;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;

import java.util.ArrayList;

//1. Service, ServiceImpl, Mapper, Mapper, 만들기
public interface ProductService {

    //7. 기능 추가
    // 서비스 > 임플 > 매퍼 > 매퍼.xml 구문까지 적고 > 임플에 추가 > 컨
    public int productInsert(ProductVO vo);

    //11. 목록
    public ArrayList<ProductVO> getList(String userId, Criteria cry);
    //3) 크리 추가 > 임플 > 매퍼 >


    //18. 상세 내역 기능 > 임플 > 매퍼 > 매퍼.xml
    public ProductVO getDetail(int prodId);

    //24.
    public int productUpdate(ProductVO vo);

    public void productDelete(int prodId);


}
