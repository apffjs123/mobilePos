package com.cookandroid.se_02_mobilepos_ver2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by LG on 2018-12-18.
 */

//menuDB Firebase에 메뉴 삽입
public class InsertMenu
{
    public InsertMenu(){
        // Write a message to the database

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("menu");
        //12가지 메뉴
        Menu[] menus = new Menu[50];

        menus[0] = new Menu("후라이드치킨",16000,1);
        menus[1] = new Menu("양념치킨",17000,1);
        menus[2] = new Menu("간장 치킨",17000,1);
        menus[3] = new Menu("반반 치킨",17000,1);
        menus[4] = new Menu("치즈피자",20000,1);
        menus[5] = new Menu("페퍼로니",20000,1);
        menus[6] = new Menu("포테이토",20000,1);
        menus[7] = new Menu("콤비네이션",22000,1);
        menus[8] = new Menu("코카콜라",2000,1);
        menus[9] = new Menu("스프라이트",2000,1);
        menus[10] = new Menu("맥주1700cc",10000,1);
        menus[11] = new Menu("소주",3000,1);

        //반복을 통해 메뉴를 넣음
        for(int i =0; i<12; i++) {
            myRef.child(menus[i].getMenuName()).setValue(menus[i]);
        }

    }
}