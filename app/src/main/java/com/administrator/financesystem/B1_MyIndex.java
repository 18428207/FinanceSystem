package com.administrator.financesystem;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class B1_MyIndex extends AppCompatActivity {
    private MySqliteHelper helper;
    TextView debt;
    TextView balance;
    TextView userid;
    TextView username;
    ListView recordlist;
    SimpleAdapter adapter;

    CardView jumpperson;
    CardView jumpbill;
    CardView jumpasset;
    CardView jumpbalance;
    CardView jumpbankcard;
    CardView jumpsetting;

    ImageView jumpwealth;
    ImageView jumpfriends;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b1_aboutme);
        helper = new MySqliteHelper(this, "fs.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        final String getuserid = (String) getIntent().getExtras().get("NowUserID");
        Log.v("test", "接收成功的userid是：" + getuserid);

        findViewById(R.id.b1_backarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this, A2_Login.class));
            }
        });

        findViewById(R.id.b1_jumpToWealth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("NowUserID", getuserid);
                Intent intent = new Intent(B1_MyIndex.this, E1_WealthIndex.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        findViewById(R.id.b1_jumpToFriend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("NowUserID", getuserid);
                Intent intent = new Intent(B1_MyIndex.this, C1_FriendsIndex.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        jumpbill = findViewById(R.id.b1_jumpToBill);
        jumpbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this, B4_Bill.class));
            }
        });

        jumpasset = findViewById(R.id.b1_jumpToTotal);
        jumpasset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "b1";
                Bundle bundle = new Bundle();
                bundle.putString("hintNumber", number);
                Intent intent1 = new Intent(B1_MyIndex.this, B2_TotalAssets.class);
                intent1.putExtras(bundle);

            }
        });

        jumpbalance = findViewById(R.id.b1_jumpToBalance);
        jumpbalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this, B5_Balance.class));
            }
        });

        jumpbankcard = findViewById(R.id.b1_jumpBank);
        jumpbankcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this, B6_BankCard.class));
            }
        });

        jumpsetting = findViewById(R.id.b1_jumpSetting);
//        jumpsetting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(B1_MyIndex.this, StudentDrawer.class));
//            }
//        });

        jumpfriends = findViewById(R.id.b1_jumpToFriend);
        jumpfriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this, C1_FriendsIndex.class));
            }
        });

        jumpwealth = findViewById(R.id.b1_jumpToWealth);
        jumpwealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this,E1_WealthIndex.class));
            }
        });
//        userid.setText(getuserid);
//        String searchsqlname = "select UserName from UserInfo where UserID='" + getuserid + "'";
//        Log.v("test", getuserid);
//        Cursor c1 = db.rawQuery(searchsqlname, null);
//        if (c1.moveToNext()) {
//            String getname = c1.getString(0).toString();
//            Log.v("test", getname);
//            username.setText(getname);
//        }


    }

    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);
        setContentView(R.layout.b1_aboutme);
        helper = new MySqliteHelper(this, "fs.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        final String getuserid = (String) getIntent().getExtras().get("NowUserID");
        Log.v("test", "接收成功的userid是：" + getuserid);

        findViewById(R.id.b1_backarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this, A2_Login.class));
            }
        });

        findViewById(R.id.b1_jumpToWealth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("NowUserID", getuserid);
                Intent intent = new Intent(B1_MyIndex.this, E1_WealthIndex.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        findViewById(R.id.b1_jumpToFriend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("NowUserID", getuserid);
                Intent intent = new Intent(B1_MyIndex.this, C1_FriendsIndex.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        jumpbill = findViewById(R.id.b1_jumpToBill);
        jumpbill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this, B4_Bill.class));
            }
        });

        jumpasset = findViewById(R.id.b1_jumpToTotal);
        jumpasset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "b1";
                Bundle bundle = new Bundle();
                bundle.putString("hintNumber", number);
                Intent intent1 = new Intent(B1_MyIndex.this, B2_TotalAssets.class);
                intent1.putExtras(bundle);
                startActivity(intent1);

            }
        });

        jumpbalance = findViewById(R.id.b1_jumpToBalance);
        jumpbalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this, B5_Balance.class));
            }
        });

        jumpbankcard = findViewById(R.id.b1_jumpBank);
        jumpbankcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this, B6_BankCard.class));
            }
        });

        jumpsetting = findViewById(R.id.b1_jumpSetting);
        jumpsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(B1_MyIndex.this, StudentDrawer.class));
            }
        });

        jumpfriends = findViewById(R.id.b1_jumpToFriend);
        jumpfriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this, C1_FriendsIndex.class));
            }
        });

        jumpwealth = findViewById(R.id.b1_jumpToWealth);
        jumpwealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(B1_MyIndex.this,E1_WealthIndex.class));
            }
        });
    }

//    public List<Map<String, Object>> getDbData() {
//
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        SQLiteDatabase db = helper.getReadableDatabase();
//        String getuserid = (String) getIntent().getExtras().get("LoginuserID");
//        Cursor cursor = db.rawQuery("select BorrowID,Money,BorrowDate,RepayDate from BorrowRecord where HostID='" + getuserid + "'"
//                , null);
//        while (cursor.moveToNext()) {
//
//            Map<String, Object> map = new HashMap<String, Object>();
//            String id = cursor.getString(cursor.getColumnIndex("BorrowID"));
//            String money = cursor.getString(cursor.getColumnIndex("Money"));
//            String bdate = cursor.getString(cursor.getColumnIndex("BorrowDate"));
//            String rdate = cursor.getString(cursor.getColumnIndex("RepayDate"));
//
//            map.put("BorrowID", id);
//            map.put("Money", money);
//            map.put("BorrowDate", bdate);
//            map.put("RepayDate", rdate);
//
//            list.add(map);
//
//        }
//        return list;
//    }


}

