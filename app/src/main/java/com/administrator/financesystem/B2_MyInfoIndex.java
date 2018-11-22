//package com.administrator.financesystem;
//
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class B2_MyInfoIndex extends AppCompatActivity {
//    ImageView jump1;
//    ImageView jump2;
//    ImageView jump3;
//    TextView cardnumber;
//    MySqliteHelper helper;
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.c1_friends);
//        helper = new MySqliteHelper(this, "fs.db", null, 1);
//        SQLiteDatabase db = helper.getReadableDatabase();
//
//        jump1 = findViewById(R.id.b2_jumpToPersonIndex);
//        jump1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        jump2 = findViewById(R.id.b2_jumpToIdentify);
//        jump2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        jump3 = findViewById(R.id.b2_jumpToQRCode);
//        jump3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
//
//}
