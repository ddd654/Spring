package com.coding404.myweb.product;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// 3. Service 이름
@Service("productService")
public class ProductServiceImpl implements ProductService {

    //4.mapper 넣기, 이걸 쓰겠다 > 컨
    @Autowired
    private ProductMapper productMapper;

    @Override
    public int productInsert(ProductVO vo) {
        return productMapper.productInsert(vo);
    }

    //13. 호출 > 컨
    @Override
    public ArrayList<ProductVO> getList(String userId, Criteria cry) {
        return productMapper.getList(userId, cry);
    }

    //20. 호출 > 컨 상세
    @Override
    public ProductVO getDetail(int prodId) {
        return productMapper.getDetail(prodId);
    }

    //25. 같은 방식으로 컨으로
    @Override
    public int productUpdate(ProductVO vo) {
        return productMapper.productUpdate(vo);
    }

    @Override 
    public void productDelete(int prodId) { //void 형은 호출만 하고 끝
        productMapper.productDelete(prodId);

    }

}
