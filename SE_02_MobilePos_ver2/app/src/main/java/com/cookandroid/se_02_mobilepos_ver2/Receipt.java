package com.cookandroid.se_02_mobilepos_ver2;

import android.content.Intent;
import android.os.Bundle;
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
 * Created by LG on 2018-12-22.
 */

public class Receipt extends MainActivity{

    EditText edtReceipt, totalPrice;
    Button goMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt);

        //위젯 할당
        edtReceipt = (EditText) findViewById(R.id.edtreciept);
        totalPrice = (EditText) findViewById(R.id.totalPrice);

        goMain = (Button) findViewById(R.id.goMain);

        Toast.makeText(getApplicationContext(),"결제가 완료됬습니다",Toast.LENGTH_SHORT).show();
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
                // 주문메뉴 명, 주문가격, 수량을 출력함
                if(edtReceipt.getText().toString() !="")
                {
                    edtReceipt.setText(edtReceipt.getText().toString() + "\n"+os.getOrdMenuName()+"\t"+os.getOrdprice()+"원"+"\t\t"+os.getOrdEa());
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

        //메인으로 이동하기 버튼
        goMain.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
