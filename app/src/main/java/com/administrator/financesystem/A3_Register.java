package com.administrator.financesystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class A3_Register extends AppCompatActivity {

    private MySqliteHelper helper;
    private EditText userid;
    private EditText userpwd;
    private EditText userpwdagain;
    private Button btnsbm;

    int userflag;
    private EditText useremail;
    String sid;
    String spwd;
    String spwd2;
    String semail;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.a3_register);
        helper = new MySqliteHelper(this, "fs.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        userid = findViewById(R.id.a3_id);
        userpwd = findViewById(R.id.a3_pwd);
        userpwdagain = findViewById(R.id.a3_pwd2);
        useremail = findViewById(R.id.a3_email);
        btnsbm = findViewById(R.id.a3_btn_submit);


        btnsbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sid = userid.getText().toString();
                spwd = userpwd.getText().toString();
                spwd2 = userpwdagain.getText().toString();
                semail = useremail.getText().toString();

                Log.v("test", "  uid  is" + sid + "!");
                adduser();
            }
        });


    }

    public void adduser() {
        helper = new MySqliteHelper(A3_Register.this, "fs.db", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Log.v("test", "addan 1");

        //查询一下，是否用户名重复
        if ((userid.getText().toString().isEmpty())) {

            Toast.makeText(this, "ID不能为空，请重新输入", Toast.LENGTH_SHORT).show();
            Log.v("test", "addid 4");

        } else if (sameid(sid)) {
            Toast.makeText(this, "已存在此ID，请重新输入", Toast.LENGTH_SHORT).show();

            Log.v("test", "addid 5");

        } else if (spwd.equals(spwd2)) {

            String sql2 = "insert into UserInfo(userid,userpwd,useremail) values " +
                    "('" + userid.getText().toString() + "','" + userpwd.getText().toString() + "','" + useremail.getText().toString() + "')";
            db.execSQL(sql2);
            Log.v("test", "addid 6");
            Toast.makeText(this, "添加成功！", Toast.LENGTH_SHORT).show();
            db.close();
        } else {
            Toast.makeText(this, "两次密码不一致，请重新输入！", Toast.LENGTH_SHORT).show();


        }
//cd /data/data/com.example.ljk.login/databases
    }


    public boolean sameid(String id) {
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "select * from UserInfo where UserID=?";
        Cursor cursor = db.rawQuery(sql, new String[]{id});
        if (cursor.moveToFirst()) {

            Log.v("test", "cursor success");
            return true;
        }

        return false;

    }
}



