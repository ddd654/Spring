package com.coding404.myweb.product;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

// 2. 어노테이션 추가
@Mapper
public interface ProductMapper {

    public int productInsert(ProductVO vo);
   // public ArrayList<ProductVO> getList(String userId,  Criteria cry);
    // 5)매개변수 2개 이상이면
    public ArrayList<ProductVO> getList(@Param("userId")String userId,  @Param("cry")Criteria cry);

    public ProductVO getDetail(int prodId);
    public int productUpdate(ProductVO vo);
    public void productDelete(int prodId);

}
