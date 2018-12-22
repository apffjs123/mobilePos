package com.cookandroid.se_02_mobilepos_ver2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MenuEdit extends MainActivity {
    Button editChick, editPizza, editSide;
    Button goMain, goBack;
    View menuChick, menuPizza, menuSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_edit);

        final Button btnChick = (Button)findViewById(R.id.btnChick);
        final Button btnPizza = (Button)findViewById(R.id.btnPizza);
        final Button btnSide = (Button)findViewById(R.id.btnSide);

        editChick = (Button) findViewById(R.id.editChick);
        editPizza = (Button) findViewById(R.id.editPizza);
        editSide = (Button) findViewById(R.id.editSide);

        goMain = (Button) findViewById(R.id.goMain);
        goBack = (Button) findViewById(R.id.goBack);

        menuChick = findViewById(R.id.menuChick);
        menuPizza = findViewById(R.id.menuPizza);
        menuSide = findViewById(R.id.menuSide);

        //치킨 카테고리 버튼
        btnChick.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){//클릭시 색이 바뀜
                        btnChick.setBackgroundColor(Color.rgb(131, 241, 216));
                        btnPizza.setBackgroundColor(Color.rgb(59, 227, 189));
                        btnSide.setBackgroundColor(Color.rgb(59, 227, 189));
                        menuChick.setVisibility(View.VISIBLE);
                        menuPizza.setVisibility(View.INVISIBLE);
                        menuSide.setVisibility(View.INVISIBLE);
                    }
                }
        );

        // 피자 카테고리 버튼
        btnPizza.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        btnPizza.setBackgroundColor(Color.rgb(131, 241, 216));
                        btnChick.setBackgroundColor(Color.rgb(59, 227, 189));
                        btnSide.setBackgroundColor(Color.rgb(59, 227, 189));
                        menuChick.setVisibility(View.INVISIBLE);
                        menuPizza.setVisibility(View.VISIBLE);
                        menuSide.setVisibility(View.INVISIBLE);
                    }
                }
        );

        //음료 카테고리 버튼
        btnSide.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        btnSide.setBackgroundColor(Color.rgb(131, 241, 216));
                        btnChick.setBackgroundColor(Color.rgb(59, 227, 189));
                        btnPizza.setBackgroundColor(Color.rgb(59, 227, 189));
                        menuChick.setVisibility(View.INVISIBLE);
                        menuPizza.setVisibility(View.INVISIBLE);
                        menuSide.setVisibility(View.VISIBLE);
                    }
                }
        );

        editChick.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //메뉴에 버튼 추가(db)
                    }
                }
        );
        editPizza.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //메뉴에 버튼 수정(db)
                    }
                }
        );
        editSide.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //메뉴에 버튼 수정(db)
                    }
                }
        );

        //뒤로 가기 버튼, 메뉴관리 페이지로 이동
        goBack.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), MenuManage.class);
                        startActivity(intent);
                    }
                }
        );

        //메인화면으로 이동하기
        goMain.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
}
