package com.administrator.financesystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class E5_Borrow extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e5_borrow);

        findViewById(R.id.e5_backarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(E5_Borrow.this, E1_WealthIndex.class));
            }
        });
    }

    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);
        setContentView(R.layout.e5_borrow);

        findViewById(R.id.e5_backarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(E5_Borrow.this, E1_WealthIndex.class));
            }
        });
    }
}
