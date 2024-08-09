package com.coding404.myweb.util;

import lombok.Data;

@Data //getter
public class Criteria {

    //화면에 전달할 값들을 갖고 다니는 클래스

    private int page;
    private int amount;

    //기본생성자로
    public Criteria(){
//        this.page = 1;
//        this.amount=10;

        this(1, 10);
    }

    public Criteria (int page, int amount){
        this.page = page;
        this.amount = amount;
    }

    //offset
    public int getPageStart(){

        return (page - 1) * amount;
    }
    
    //이거 싹 만들면 > 컨으로

}
