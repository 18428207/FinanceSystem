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
import android.widget.TextView;
import android.widget.Toast;

public class A2_Login extends AppCompatActivity {
    private MySqliteHelper dbHelper;
    private EditText userid;
    private EditText userpassword;
    private int loginflag;


    protected void onCreate(Bundle savedInstanceState) {
        //验证
        //验证
        dbHelper = new MySqliteHelper(this, "fs.db", null, 1);
        //  Log.v("test","oncreat database open");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2_login);
        // showSoftInputFromWindow(this,mAdminIDView);
        

        Button btnLogin = (Button) findViewById(R.id.a2_btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userid = findViewById(R.id.a2_id);
                userpassword = findViewById(R.id.a2_pwd);
                String userID = userid.getText().toString();
                String passWord = userpassword.getText().toString();
                if (login(userID, passWord)) {

                    loginflag = 1;
                    Log.v("test", "loginclicked success");
                    Bundle bundle = new Bundle();
                    bundle.putString("LoginuserID", userID);
                    Intent intent = new Intent(A2_Login.this, B1_PersonalInfo.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    Log.v("test", "传输成功的userID是："+userID);
                    Toast.makeText(A2_Login.this, "登陆成功", Toast.LENGTH_SHORT).show();
                } else if ((userid.getText().toString().isEmpty()) || (userpassword.getText().toString().isEmpty())) {
                    Toast.makeText(A2_Login.this, "账户和密码不能为空，请重新输入", Toast.LENGTH_SHORT).show();
                } else if (loginflag != 1) {
                    Toast.makeText(A2_Login.this, "账号或者密码错误,请重新输入", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    //验证登录
    public boolean login(String userID, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select * from UserInfo where UserID=? and UserPwd=?";
        Cursor cursor = db.rawQuery(sql, new String[]{userID, password});
        if (cursor.moveToFirst()) {
            cursor.close();
            Log.v("test", "cursor success");
            return true;
        }
        return false;
    }

}
