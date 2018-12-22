package com.cookandroid.se_02_mobilepos_ver2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuAdd extends AppCompatActivity {
    //치킨, 피자, 음료 이름, 가격 입력란
    EditText chickName, chickPrice, pizzaName, pizzaPrice, sideName, sidePrice;

    Button addChick, addPizza, addSide;
    Button goMain, goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_add);
        //위젯 할당 EditText
        //치킨 입력란
        chickName = (EditText) findViewById(R.id.chickName);
        chickPrice = (EditText) findViewById(R.id.chickPrice);

        //피자 입력란
        pizzaName = (EditText)  findViewById(R.id.pizzaName);
        pizzaPrice = (EditText) findViewById(R.id.pizzaPrice);

        //음료 입력란
        sideName = (EditText) findViewById(R.id.sideName);
        sidePrice = (EditText) findViewById(R.id.sidePrice);


        addChick = (Button) findViewById(R.id.addChick);
        addPizza = (Button) findViewById(R.id.addPizza);
        addSide = (Button) findViewById(R.id.addSide);

        goMain = (Button) findViewById(R.id.goMain);
        goBack = (Button) findViewById(R.id.goBack);

        addChick.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //메뉴에 버튼 추가(db)
                        //TODO 입력란에서 입력문자를 String 변수 가져오기
                        // 치킨 이름
                        String aName = chickName.getText().toString();
                        // 치킨 가격
                        String aPrice = chickPrice.getText().toString();

                        //새로운 치킨 메뉴 객체 생성
                        Menu m = new Menu(aName,Integer.parseInt(aPrice),1);
                        //파이어베이스 데이터 인스턴스 생성 및 참조 위치 메뉴로 지정
                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference("menu");
                        myRef.child(aName).setValue(m);

                        //TODO 치킨카테고리에 해당 메뉴와 가격을 가진 버튼 생성
                        //TODO Toast Message 띄우기
                        Toast.makeText(getApplicationContext(),"메뉴가 추가됐습니다",Toast.LENGTH_SHORT).show();;





                    }
                }
        );
        addPizza.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //메뉴에 버튼 추가(db)
                        //TODO 입력란에서 입력문자를 String변수 가져오기

                    }
                }
        );
        addSide.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //메뉴에 버튼 추가(db)
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