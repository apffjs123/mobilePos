package com.cookandroid.se_02_mobilepos_ver2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCtg, btnMng, btnMenu,btnOdr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCtg = (Button) findViewById(R.id.btnCtg);
        btnMng = (Button)findViewById(R.id.btnMng);
        btnMenu = (Button)findViewById(R.id.btnMenu);
        btnOdr = (Button) findViewById(R.id.btnOrder);
        btnCtg.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), CategoryAct.class);
                        startActivity(intent);
                    }
                });
        btnMng.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), ctgManage.class);
                        startActivity(intent);
                    }
                });
        btnMenu.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), MenuManage.class);
                        startActivity(intent);
                    }
                }
        );

        btnOdr.setOnClickListener(
                new Button.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), ordSht.class);
                        startActivity(intent);
                    }
                });
    }


}