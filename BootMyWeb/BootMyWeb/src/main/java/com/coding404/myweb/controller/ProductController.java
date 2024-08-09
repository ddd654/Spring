package com.coding404.myweb.controller;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.product.ProductService;
import com.coding404.myweb.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
@RequestMapping("/product")
public class ProductController {

    //5. 어떤 서비스 연결 > 등록부터 해보자 > baselayout aside 경로
    // baseLayout에서 > productReg 에서 prod_enddate 에 required, pattern
    // > 등록자 ID , 목록이동 등 추가
    @Autowired
    @Qualifier("productService") // 이 서비스를 이름으로 연결
    private ProductService productService;

    //1) 페이지 클래스 만들고 > Criteria cry로 했음
    //목록
    @GetMapping("/productList")
    public String productList(Model model, Criteria cry){ //15. 모델에 담기

        //2) cry > service에 넘기고 ... >
        // 3)서비스 인터 > 4)impl > 5)mapper << 여기서 매개변수 2개
        // > 6)mapper(여기에 LIMIT, cry 달기)  > 7)컨와서 cry 추가
        System.out.println(cry.toString());
        //하면 일단 10개 나옴

        //10. 로그인한사람이 admin이라 가정 > 서비스
        String userId = "admin";
        //14. list 출력하기 > Model > 화면으로 가서 값 적기 ${}
        ArrayList<ProductVO> list = productService.getList(userId, cry);

        model.addAttribute("list", list);
        System.out.println(list.toString());
        
        return "product/productList";
    }

    //등록
    @GetMapping("/productReg")
    public String productReg(){
        return "product/productReg";
    }

    //상세
    // 16. productList에서 상세보기 주소 수정 > 값 박기
    @GetMapping("/productDetail")
    public String productDetail( @RequestParam("prodId") int prodId, // 17. 값을 가져오기 > 서비스
                                 Model model ){ //22. Model

        //21. 호출
        ProductVO vo = productService.getDetail(prodId);
        // 22. Model 추가 후 추가 > detail html 에서 수정
        model.addAttribute("vo", vo);
        
        return "product/productDetail";
    }

    //6. action으로 요청 하니 > 경로 추가
    //등록요청 > 서비스
    @PostMapping("/productForm")
    public String productForm(ProductVO vo,
                              RedirectAttributes ra){

        //8. 서버측에서 유효성 검사 부분

        //9. 1 = 성공 > List.html 에 js 메시지 추가하기 > 조회 만들기 > 목록 부분으로
        int result = productService.productInsert(vo);
        if (result ==1){
            System.out.println("요청하는지 보기 ~~ "+ result + " ~~ " + vo.toString());
            ra.addFlashAttribute("msg", "good");
        } else{
            ra.addFlashAttribute("msg", "등록에 실패하였습니다");
            
        }


        return "redirect:/product/productList";
    }

    //23. update > service
    // 상품 수정, PK
    @PostMapping("/productUpdate")
    public String productUpdate(ProductVO vo,
                                RedirectAttributes ra){

        //26. 선택
        int result = productService.productUpdate(vo);
        if(result == 1) {
            ra.addFlashAttribute("msg", "수정 되었습니다");
        } else {
            ra.addFlashAttribute("msg", "수정에 실패했습니다");
        }

        return "redirect:/product/productDetail?prodId=" + vo.getProdId(); //상세화면은 id값을 필요로 함
        //상세화면은 id 값이 필요하다
    }

    //productDelete
    @PostMapping("/productDelete")
    public String productDelete(@RequestParam("prodId") int prodId) { //가져올 값이 하나여서 para


        System.out.println("DELETE prodId: " + prodId);


        //이테일 html에서 자바스크립트로 확인창
        productService.productDelete(prodId);

        return "redirect:/product/productList";
    }


}
