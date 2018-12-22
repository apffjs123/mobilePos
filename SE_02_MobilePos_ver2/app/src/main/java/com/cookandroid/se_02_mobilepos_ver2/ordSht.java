package com.cookandroid.se_02_mobilepos_ver2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Comment;

/**
 * Created by LG on 2018-12-20.
 */

public class ordSht extends AppCompatActivity {
    //주문서 출력 창
    EditText edtOdSt;
    // Back 버튼, 현금 버튼, 카드 버튼
    Button goMain, btnPay, btnCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 주문관리 페이지(XML)로 연동
        setContentView(R.layout.ordsht);

        //위젯을 할당하기
        edtOdSt = (EditText) findViewById(R.id.edtOdSt);

        btnPay = (Button) findViewById(R.id.btnPay) ;
        btnCard = (Button) findViewById(R.id.btnCard) ;
        goMain = (Button)findViewById(R.id.goMain);

        //목록 읽어오기기/ 주문서 가져오기
        DatabaseReference mDatabase;
        //파이어베이스에서 주문서 목록에 들어가서 읽어옴
        mDatabase = FirebaseDatabase.getInstance().getReference("orderSheet");

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
//                Log.d(TAG, "onChildAdded:" + dataSnapshot.getKey());

                // A new comment has been added, add it to the displayed list
                orderSheet os = dataSnapshot.getValue(orderSheet.class);
                if(edtOdSt.getText().toString() !="")
                {
                    edtOdSt.setText(edtOdSt.getText().toString() + "\n"+os.getOrdMenuName()+"\t"+os.getOrdprice()+"원"+"\t\t"+os.getOrdEa());
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.
                Comment newComment = dataSnapshot.getValue(Comment.class);
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.
                Comment movedComment = dataSnapshot.getValue(Comment.class);
                String commentKey = dataSnapshot.getKey();

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                Log.w(TAG, "postComments:onCancelled", databaseError.toException());
//                Toast.makeText(mContext, "Failed to load comments.",
//                        Toast.LENGTH_SHORT).show();
            }
        };
        mDatabase.addChildEventListener(childEventListener);

        //현금 버튼 동작
        btnPay.setOnClickListener(new Button.OnClickListener() {
            //TODO 대화상자
            @Override
            public void onClick(View view) {
                final String[] versionArray = new String[] { "주류있음"};
                final boolean[] checkArray = new boolean[] {false};
                AlertDialog.Builder dlg = new AlertDialog.Builder(ordSht.this);
                dlg.setTitle("현금결제");
                //TODO 주류있음-> 선택시 카메라로 이동
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    // 체크 시 되는 상황
                    //카메라로 이동
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean ischecked) {

                    }
                });

                //결제 눌렀을 시 영수증으로 이동
                dlg.setPositiveButton("결제",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(), Receipt.class);
                                startActivity(intent);
                            }
                        });
                //취소 눌렀을시 취소했다는 메세지 띄움
                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"결제가 취소됬습니다",Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();
            }
        });

        btnCard.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] versionArray = new String[] { "주류있음"};
                final boolean[] checkArray = new boolean[] {false};
                AlertDialog.Builder dlg = new AlertDialog.Builder(ordSht.this);
                dlg.setTitle("카드결제");
                //TODO 주류있음-> 선택시 카메라로 이동
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    // 체크 시 되는 상황
                    //카메라로 이동
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean ischecked) {

                    }
                });

                //결제 눌렀을 시 영수증으로 이동
                dlg.setPositiveButton("결제",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(getApplicationContext(), Receipt.class);
                                startActivity(intent);
                            }
                        });
                //취소 눌렀을시 취소했다는 메세지 띄움
                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"결제가 취소됬습니다",Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();
            }
        });


        //TODO 결제

        //메인으로 돌아가기
        goMain.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });


    }
}
