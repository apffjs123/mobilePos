package com.cookandroid.se_02_mobilepos_ver2;

/**
 * Created by LG on 2018-12-18.
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CategoryAct extends MainActivity {
    //    메뉴 버튼
    Button btnFried, btnSpicy, btnSoy, btnHalf;
    Button btnChz, btnPep, btnPot, btnComb;
    Button btnCoke, btnCider, btnBeer, btnSoju;

    //   카테고리 버튼
    Button btnChick, btnPizza, btnSide;

    //    돌아가기 버튼
    Button goMain;


    //카테고리 레이아웃
    View ctgChick, ctgPizza, ctgSide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);


        Intent intent = getIntent();
        // 뒤로가기 버튼
        goMain = (Button) findViewById(R.id.goMain);
        //카테고리 버튼
        btnChick = (Button) findViewById(R.id.btnChick);
        btnPizza = (Button) findViewById(R.id.btnPizza);
        btnSide = (Button) findViewById(R.id.btnSide);

        //치킨
        btnFried = (Button) findViewById(R.id.btnFried);
        btnSpicy = (Button) findViewById(R.id.btnSpicy);
        btnSoy = (Button)  findViewById(R.id.btnSoy);
        btnHalf = (Button) findViewById(R.id.btnHalf);

        //피자
        btnChz = (Button) findViewById(R.id.btnChz);
        btnPep = (Button) findViewById(R.id.btnPep);
        btnPot = (Button) findViewById(R.id.btnPot);
        btnComb = (Button) findViewById(R.id.btnComb);

        //음료
        btnCoke = (Button) findViewById(R.id.btnCoke);
        btnCider = (Button) findViewById(R.id.btnCider);
        btnBeer = (Button) findViewById(R.id.btnBeer);
        btnSoju = (Button) findViewById(R.id.btnSoju);

        //카테고리
        ctgChick = findViewById(R.id.ctgChick);
        ctgSide = findViewById(R.id.ctgSide);
        ctgPizza = findViewById(R.id.ctgPizza);

        // Write a message to the database

        // 데이터 베이스에 메뉴 삽입 부분, 생성자로 기존 메뉴 삽입하게 구현
//        InsertMenu i = new InsertMenu();

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

//        후라이드 치킨 버튼을 누르면 디비에 데이터 메뉴명, 가격 쓰기
        btnFried.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //치킨을 선택했다 console 창에 출력
                        System.out.println("Selected chicken");

//                        dialogView = (VIew)
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 주문서디비에 저장
                        //데이터 읽어오기
                        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "후라이드치킨");
                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);

                                //주문메뉴 객체 생성
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());

                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                //디비에 추가하는 부분
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);

                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                });

//        양념치킨 버튼 주문서에 추가
        btnSpicy.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //양념 치킨을 선택했다 console 창에 출력
                        System.out.println("Selected spicy chicken");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장
                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "양념치킨");
                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });

        //간장치킨 버튼 주문서에 추가
        btnSoy.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //간장 치킨을 선택했다 console 창에 출력
                        System.out.println("Selected soy chicken");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "간장 치킨");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });

        //반반치킨 버튼 주문서에 추가
        btnHalf.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //반반 치킨을 선택했다 console 창에 출력
                        System.out.println("Selected half chicken");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "반반 치킨");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });

        //치즈피자 버튼 주문서에 추가
        btnChz.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //치즈피자를 선택했다 console 창에 출력
                        System.out.println("Selected cheeze pizza");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "치즈피자");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });

        //페퍼로니 버튼 주문서에 추가
        btnPep.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //페퍼로니를 선택했다 console 창에 출력
                        System.out.println("Selected pepperoni pizza");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "페퍼로니");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });

        //포테이토 버튼 주문서에 추가
        btnPot.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //페퍼로니를 선택했다 console 창에 출력
                        System.out.println("Selected potato pizza");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "포테이토");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });

        //콤비네이션 버튼 주문서에 추가
        btnComb.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //페퍼로니를 선택했다 console 창에 출력
                        System.out.println("Selected Combination pizza");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "콤비네이션");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });

        //콤비네이션 버튼 주문서에 추가
        btnComb.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //페퍼로니를 선택했다 console 창에 출력
                        System.out.println("Selected Combination pizza");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "콤비네이션");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });

        //코카콜라 버튼 주문서에 추가
        btnCoke.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //사이다를 선택했다 console 창에 출력
                        System.out.println("Selected Cider");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "코카콜라");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });


        //스프라이트 버튼 주문서에 추가
        btnCider.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //사이다를 선택했다 console 창에 출력
                        System.out.println("Selected Cider");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "스프라이트");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });

        //맥주 1700CC 버튼 주문서에 추가
        btnBeer.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //맥주1700cc를 선택했다 console 창에 출력
                        System.out.println("Selected Beer");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "맥주1700cc");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });

        //소주 버튼 주문서에 추가
        btnSoju.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        //소주를 선택했다 console 창에 출력
                        System.out.println("Selected Soju");
                        //데이터를 넣으면, 해당되는 메뉴 명과 메뉴가격을 디비에 저장

                        //데이터 읽어오기
                        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("menu/" + "소주");

                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Menu m = dataSnapshot.getValue(Menu.class);
                                orderSheet o = new orderSheet(m.getMenuName(), m.getPrice(), m.getEa());
                                FirebaseDatabase.getInstance().getReference("menu/"+o.getOrdMenuName()).child("ordered").setValue(true);
                                FirebaseDatabase.getInstance().getReference("orderSheet").child(o.getOrdMenuName()).setValue(o);
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });
    }

}

