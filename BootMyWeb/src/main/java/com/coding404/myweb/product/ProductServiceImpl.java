package com.coding404.myweb.product;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("productService") //이름
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int productInsert(ProductVO vo) {
        return productMapper.productInsert(vo);
    }

    @Override
    public ArrayList<ProductVO> getList(String userId, Criteria cri) {
        return productMapper.getList(userId, cri);
    }

    @Override
    public int getTotal(String userId, Criteria cri) {
        return productMapper.getTotal(userId, cri);
    }

    @Override
    public ProductVO getDetail(int prodId) {
        return productMapper.getDetail(prodId);
    }

    @Override
    public int productUpdate(ProductVO vo) {
        return productMapper.productUpdate(vo);
    }

    @Override
    public void productDelete(int prodId) {
        productMapper.productDelete(prodId);
    }

    @Override
    public ArrayList<CategoryVO> getCate() {
        return productMapper.getCate();
    }

    @Override
    public ArrayList<CategoryVO> getCatechild(CategoryVO vo) {
        return null;
    }
}
//이부분에서 해보기
//카테고리  키값은 그룹번호 + 카테고리 ID 로 만들어 진다
//prodCategory에 밸류값 세팅해서 화면띄우기
//클릭한 대상의 이 값을, 인풋태그[name=prodCategory] 에 value에 값을 지정
