package com.administrator.financesystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E1_WealthIndex extends AppCompatActivity {
    TextView assets;
    TextView revenue;
    private MySqliteHelper helper;
    private SimpleAdapter adapter1;
    private SimpleAdapter adapter2;
    private ListView borrowlistView;
    private ListView loanlistView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e1_wealthindex);

        helper = new MySqliteHelper(this, "fs.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();
        final String getuserid = (String) getIntent().getExtras().get("LoginuserID");

        assets = findViewById(R.id.e1_totalassets);
        revenue = findViewById(R.id.e1_totalrevenue);
        borrowlistView = findViewById(R.id.e1_borrowlist);
        loanlistView = findViewById(R.id.e1_loanlist);

        findViewById(R.id.e1_jumpFriend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("NowUserID", getuserid);
                Intent intent = new Intent(E1_WealthIndex.this, C1_FriendsIndex.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        findViewById(R.id.e1_moreborrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(E1_WealthIndex.this, StudentDrawer.class));
            }
        });

        findViewById(R.id.e1_moreloan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(E1_WealthIndex.this, StudentDrawer.class));
            }
        });

        findViewById(R.id.e1_ImgHKD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(E1_WealthIndex.this, StudentDrawer.class));
            }
        });

        findViewById(R.id.e1_ImgFond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(E1_WealthIndex.this, StudentDrawer.class));
            }
        });

        findViewById(R.id.e1_ImgStock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(E1_WealthIndex.this, StudentDrawer.class));
            }
        });

        adapter1 = new SimpleAdapter(E1_WealthIndex.this, getDbData1(), R.layout.e2_wealthlistitem,
                new String[]{"BorrowID", "Money", "BorrowDate", "RepayDate"},
                new int[]{R.id.e2_creditorsid, R.id.e2_money, R.id.e2_borrowdate, R.id.e2_repaydate});
        loanlistView.setAdapter(adapter1);
        loanlistView.setSelection(ListView.FOCUS_DOWN);

        adapter2 = new SimpleAdapter(E1_WealthIndex.this, getDbData2(), R.layout.e2_wealthlistitem,
                new String[]{"BorrowID", "Money", "BorrowDate", "RepayDate"},
                new int[]{R.id.e2_creditorsid, R.id.e2_money, R.id.e2_borrowdate, R.id.e2_repaydate});
        borrowlistView.setAdapter(adapter2);
        borrowlistView.setSelection(ListView.FOCUS_DOWN);


        String searchsqlasset = "select UserBalance from UserInfo where UserID='" + getuserid + "'";
        Log.v("test", getuserid);
        Cursor c1 = db.rawQuery(searchsqlasset, null);
        while (c1.moveToNext()) {
            String get = c1.getString(0).toString();
            Log.v("test", get);
            assets.setText(get);
        }

//        String searchsqlrevenue = "select UserBalance from UserInfo where UserID='" + getuserid + "'";
//        Log.v("test", getuserid);
//        Cursor c1 = db.rawQuery(searchsqlasset, null);
//        while (c1.moveToNext()) {
//            String get = c1.getString(0).toString();
//            Log.v("test", get);
//            assets.setText(get);
//        }


    }


//    private TextView mTextMessage;
//
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
//            }
//            return false;
//        }
//    };

    public List<Map<String, Object>> getDbData1() {

            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            SQLiteDatabase db = helper.getReadableDatabase();
            String getuserid = (String) getIntent().getExtras().get("LoginuserID");
            Log.v("test","id:"+getuserid);
            Cursor cursor = db.rawQuery("select BorrowID,Money,BorrowDate,RepayDate from BorrowRecord where HostID='" + getuserid + "'"
                    , null);
            while (cursor.moveToNext()) {

                Map<String, Object> map = new HashMap<String, Object>();
                String id = cursor.getString(cursor.getColumnIndex("BorrowID"));
                String money = cursor.getString(cursor.getColumnIndex("Money"));
                String bdate = cursor.getString(cursor.getColumnIndex("BorrowDate"));
                String rdate = cursor.getString(cursor.getColumnIndex("RepayDate"));

                map.put("BorrowID", id);
                map.put("Money", money);
                map.put("BorrowDate", bdate);
                map.put("RepayDate", rdate);

                list.add(map);

            }
        return list;
    }

    public List<Map<String, Object>> getDbData2() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String getuserid = (String) getIntent().getExtras().get("LoginuserID");
        Log.v("test","id:"+getuserid);
        Cursor cursor = db.rawQuery("select HostID,Money,BorrowDate,RepayDate from BorrowRecord where BorrowID='" + getuserid + "'"
                , null);
        while (cursor.moveToNext()) {


            Map<String, Object> map = new HashMap<String, Object>();
            String id = cursor.getString(cursor.getColumnIndex("HostID"));
            String money = cursor.getString(cursor.getColumnIndex("Money"));
            String bdate = cursor.getString(cursor.getColumnIndex("BorrowDate"));
            String rdate = cursor.getString(cursor.getColumnIndex("RepayDate"));

            map.put("BorrowID", id);
            map.put("Money", money);
            map.put("BorrowDate", bdate);
            map.put("RepayDate", rdate);

            list.add(map);

        }
        return list;
    }

}





