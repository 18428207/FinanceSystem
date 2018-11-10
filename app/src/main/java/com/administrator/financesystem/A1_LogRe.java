package com.administrator.financesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class A1_LogRe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1_logre);

        findViewById(R.id.a1_btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(A1_LogRe.this,A2_Login.class));
            }
        });

        findViewById(R.id.a1_btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(A1_LogRe.this,A3_Register.class));
            }
        });
    }
}
//格式化代码 ctrl+alt+L  替换ctrl+R 查找 ctrl+F  定位到资源ctrl+B 代码块生成ctrl+J