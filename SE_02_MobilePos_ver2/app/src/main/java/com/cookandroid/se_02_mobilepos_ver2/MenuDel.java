package com.cookandroid.se_02_mobilepos_ver2;

/**
 * Created by LG on 2018-12-20.
 */
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuDel extends MainActivity {
    Button delChick, delPizza, delSide;
    Button goMain, goBack;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_del);
        delChick = (Button) findViewById(R.id.delChick);
        delPizza = (Button) findViewById(R.id.delPizza);
        delSide = (Button) findViewById(R.id.delSide);

        goMain = (Button) findViewById(R.id.goMain);
        goBack = (Button) findViewById(R.id.goBack);

        delChick.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //메뉴에 버튼 삭제(db)
                    }
                }
        );
        delPizza.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //메뉴에 버튼 삭제(db)
                    }
                }
        );
        delSide.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //메뉴에 버튼 삭제(db)
                    }
                }
        );
        goBack.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), MenuManage.class);
                        startActivity(intent);
                    }
                }
        );
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
