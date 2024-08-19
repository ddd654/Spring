package com.coding404.myweb.controller;

import com.coding404.myweb.command.CategoryVO;
import com.coding404.myweb.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    //6- upload
    @Value(("${project.upload.path}"))
    String uploadPath; // 파일 업로드 패스

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    //1단 카테고리
    @GetMapping("/getCategory")
    public ResponseEntity<List<CategoryVO>> getCategory() {
        ArrayList<CategoryVO> list = productService.getCategory();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //2단, 3단 카테고리
    @GetMapping("/getCategoryChild/{groupId}/{categoryLv}/{categoryDetailLv}")
    public ResponseEntity<List<CategoryVO>> getCategoryChild(@PathVariable("groupId") String groupId,
                                                             @PathVariable("categoryLv") int categoryLv,
                                                             @PathVariable("categoryDetailLv") int categoryDetailLv) {
        CategoryVO vo = CategoryVO.builder()
                .groupId(groupId)
                .categoryLv(categoryLv)
                .categoryDetailLv(categoryDetailLv)
                .build();
        ArrayList<CategoryVO> list = productService.getCategoryChild(vo);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    //3- 이미지 응답에 대해 데이터 요청
//    @GetMapping("/display/{filepath}/{uuid}/{filename}")
//    public byte[] display(@PathVariable("filepath") String filepath,
//                          @PathVariable("uuid") String uuid,
//                          @PathVariable("filename") String filename) {
//
//        //4- 확인
//        System.out.println(filepath);
//        System.out.println(uuid);
//        System.out.println(filename);
//
//        //5- 하드디스크 오컬에 있는 파일의 경로를 알 수 있다
//        //6- 위에 upploadPath 추가
//        //7- 경로
//        byte[] result = null;
//        String path = uploadPath + "/" + filename + "/" + uuid + "_" + filename; // 파일의 실제 경로
//        File file = new File(path);
//
//        try {
//            result = FileCopyUtils.copyToByteArray(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return null; //요철이 들어온 곳으로 간다
//        //파일 경로 - properties에 있던거
//        //project.upload.path=C:/Users/user/Desktop/course/spring/Spring/intelij/upload
//    }     //

    
    
    /*
    //뭔가 틀려서 복사
    //이미지 데이터 응답에 대한 요청
    @GetMapping("/display/{filepath}/{uuid}/{filename}")
    public byte[] display(@PathVariable("filepath") String filepath,
                          @PathVariable("uuid") String uuid,
                          @PathVariable("filename") String filename) {

        System.out.println(filepath);
        System.out.println(uuid);
        System.out.println(filename);
        // ex >> display/202408/a2087f9c-9953-40b3-bdf7-d5f9b3d27387/스크린샷%202024-06-04%20111723.png

        //하드디스크에 있는 파일 경로
        byte[] result = null;
        String path = uploadPath + "/" + filepath + "/" + uuid + "_" + filename; //파일의 실제 경로
        File file = new File(path);

        try {
            result = FileCopyUtils.copyToByteArray(file); //파일데이터의 byte배열값을 구해서 반환

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result; //요청이 들어온 곳으로 응답.
    }
    */


    // ResponseEntity로 명확하게 표현하기
    //이미지 데이터 응답에 대한 요청
    @GetMapping("/display/{filepath}/{uuid}/{filename}")
    public ResponseEntity<byte[]> display(@PathVariable("filepath") String filepath,
                          @PathVariable("uuid") String uuid,
                          @PathVariable("filename") String filename) {

        System.out.println(filepath);
        System.out.println(uuid);
        System.out.println(filename);

        //하드디스크에 있는 파일 경로
        ResponseEntity<byte[]> result = null;
        String path = uploadPath + "/" + filepath + "/" + uuid + "_" + filename; //파일의 실제 경로
        File file = new File(uploadPath); //업로드 경로

        try {
            byte[] arr = FileCopyUtils.copyToByteArray(file); //파일데이터의 byte배열값을 구해서 반환
            HttpHeaders header = new HttpHeaders();
            header.add("Content-Disposition", "attachment; filename=" + filename);// 해당 경로 파일의 mime을 구한다

            result = new ResponseEntity<>(arr, header, HttpStatus.OK);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return result; //요청이 들어온 곳으로 응답.
    }




}
