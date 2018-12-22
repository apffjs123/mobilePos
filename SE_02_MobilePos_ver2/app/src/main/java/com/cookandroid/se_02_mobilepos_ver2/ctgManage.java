package com.cookandroid.se_02_mobilepos_ver2;

/**
 * Created by LG on 2018-12-20.
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ctgManage extends MainActivity {
    Button addCtg, editCtg, delCtg;
    Button goMain;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ctg_manage);

        addCtg = (Button) findViewById(R.id.addCtg);
        editCtg = (Button)findViewById(R.id.editCtg);
        delCtg = (Button)findViewById(R.id.delCtg);

        goMain = (Button)findViewById(R.id.goMain);

        addCtg.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        //카테고리 추가되는거 디비랑 연동
                    }
                }
        );
        editCtg.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        //카테고리 수정되는거 디비랑 연동
                        //기존메뉴 입력하는 editText 있음
                    }
                }
        );
        delCtg.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        //카테고리 삭제되는거 디비랑 연동
                    }
                }
        );
        goMain.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}
