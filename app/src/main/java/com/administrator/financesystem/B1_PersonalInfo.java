//package com.administrator.financesystem;
//
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class B1_PersonalInfo extends AppCompatActivity {
//    private MySqliteHelper helper;
//    TextView debt;
//    TextView balance;
//    TextView userid;
//    TextView username;
//ListView recordlist;
//SimpleAdapter adapter;
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.b1_aboutme);
//        helper = new MySqliteHelper(this, "fs.db", null, 1);
//        SQLiteDatabase db = helper.getReadableDatabase();
//
//        String getuserid = (String) getIntent().getExtras().get("LoginuserID");
//        Log.v("test", "接收成功的userid是："+getuserid);
//
//        debt = findViewById(R.id.b1_debt);
//        balance = findViewById(R.id.b1_balance);
//        userid = findViewById(R.id.b1_userid);
//        username = findViewById(R.id.b1_name);
//        recordlist = findViewById(R.id.b1_recordlistview);
//
//        userid.setText(getuserid);
//        String searchsqlname = "select UserName from UserInfo where UserID='" + getuserid + "'";
//        Log.v("test", getuserid);
//        Cursor c1 = db.rawQuery(searchsqlname, null);
//        if (c1.moveToNext()) {
//            String getname = c1.getString(0).toString();
//            Log.v("test", getname);
//            username.setText(getname);
//        }
//        String searchsqldebt = "select UserDebt from UserInfo where UserID='" + getuserid + "'";
//        Log.v("test", getuserid);
//        Cursor c2 = db.rawQuery(searchsqldebt, null);
//        if (c2.moveToNext()) {
//            String getdebt = c2.getString(0).toString();
//            Log.v("test", getdebt);
//            debt.setText(getdebt);
//        }
//        String searchsqlbal = "select UserBalance from UserInfo where UserID='" + getuserid + "'";
//        Log.v("test", getuserid);
//        Cursor c3 = db.rawQuery(searchsqlbal, null);
//        if (c3.moveToNext()) {
//            String getbal = c3.getString(0).toString();
//            Log.v("test", getbal);
//            balance.setText(getbal);
//        }
//
//        adapter = new SimpleAdapter(B1_PersonalInfo.this, getDbData(), R.layout.b1_recorditem,
//                new String[]{"BorrowID", "Money", "BorrowDate", "RepayDate"},
//                new int[]{R.id.b2_borrowid, R.id.b2_money, R.id.b2_borrowdate, R.id.b2_repaydate});
////        cvlistView.setAdapter(adapter);
//        recordlist.setAdapter(adapter);
//        recordlist.setSelection(ListView.FOCUS_DOWN);
//
//    }
//
//    public List<Map<String, Object>> getDbData () {
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
//
//
//
//}
//
