package com.cookandroid.se_02_mobilepos_ver2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by LG on 2018-12-19.
 */

public class MenuManage extends MainActivity {
    //    메뉴 버튼
    Button btnFried, btnSpicy, btnSoy, btnHalf;
    Button btnChz, btnPep, btnPot, btnComb;
    Button btnCoke, btnCider, btnBeer, btnSoju;

    //   카테고리 버튼
    Button btnChick, btnPizza, btnSide;

    //    돌아가기 버튼
    Button menuAdd, menuEdit, menuDel, goMain;

    //카테고리 레이아웃
    View ctgChick, ctgPizza, ctgSide;

    EditText edtTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_manage);


        Intent intent = getIntent();


        btnChick = (Button) findViewById(R.id.btnChick);
        btnPizza = (Button) findViewById(R.id.btnPizza);
        btnSide = (Button) findViewById(R.id.btnSide);

        goMain = (Button) findViewById(R.id.goMain);
        menuAdd = (Button) findViewById(R.id.menuAdd);
        menuEdit = (Button)findViewById(R.id.menuEdit);
        menuDel = (Button)findViewById(R.id.menuDel);

        ctgChick = findViewById(R.id.ctgChick);
        ctgSide = findViewById(R.id.ctgSide);
        ctgPizza = findViewById(R.id.ctgPizza);

        // Write a message to the database

        // 돌아가기 버튼
        goMain.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });

        //치킨 메뉴
        btnChick.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        ctgChick.setVisibility(View.VISIBLE);
                        ctgPizza.setVisibility(View.INVISIBLE);
                        ctgSide.setVisibility(View.INVISIBLE);
                    }
                }
        );
        // 피자 메뉴
        btnPizza.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        ctgChick.setVisibility(View.INVISIBLE);
                        ctgPizza.setVisibility(View.VISIBLE);
                        ctgSide.setVisibility(View.INVISIBLE);
                    }
                }
        );
        // 사이드 메뉴
        btnSide.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        ctgChick.setVisibility(View.INVISIBLE);
                        ctgPizza.setVisibility(View.INVISIBLE);
                        ctgSide.setVisibility(View.VISIBLE);
                    }
                }
        );

        //메뉴 추가 버튼
        //메뉴 추가 페이지로 넘어감
        menuAdd.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), MenuAdd.class);
                        startActivity(intent);
                    }
                }
        );

        //메뉴 수정 부분
        menuEdit.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), MenuEdit.class);
                        startActivity(intent);
                    }
                }
        );

        //메뉴 삭제 부분
        menuDel.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), MenuDel.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
