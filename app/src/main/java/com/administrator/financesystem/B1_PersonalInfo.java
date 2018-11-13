package com.administrator.financesystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class B1_PersonalInfo extends AppCompatActivity {
    private MySqliteHelper helper;
    TextView debt;
    TextView balance;
    TextView userid;
    TextView username;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b1_personalinfo);
        helper = new MySqliteHelper(this, "fs.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        String getuserid = (String) getIntent().getExtras().get("LoginuserID");
        Log.v("test", "接收成功的userid是："+getuserid);

        debt = findViewById(R.id.b1_debt);
        balance = findViewById(R.id.b1_balance);
        userid = findViewById(R.id.b1_userid);
        username = findViewById(R.id.b1_name);

        userid.setText(getuserid);
        String searchsqlname = "select UserName from UserInfo where UserID='" + getuserid + "'";
        Log.v("test", getuserid);
        Cursor c1 = db.rawQuery(searchsqlname, null);
        if (c1.moveToNext()) {
            String getname = c1.getString(0).toString();
            Log.v("test", getname);
            username.setText(getname);
        }
        String searchsqldebt = "select UserDebt from UserInfo where UserID='" + getuserid + "'";
        Log.v("test", getuserid);
        Cursor c2 = db.rawQuery(searchsqldebt, null);
        if (c2.moveToNext()) {
            String getdebt = c2.getString(0).toString();
            Log.v("test", getdebt);
            debt.setText(getdebt);
        }
        String searchsqlbal = "select UserBalance from UserInfo where UserID='" + getuserid + "'";
        Log.v("test", getuserid);
        Cursor c3 = db.rawQuery(searchsqlbal, null);
        if (c3.moveToNext()) {
            String getbal = c3.getString(0).toString();
            Log.v("test", getbal);
            balance.setText(getbal);
        }


    }


}

