package com.administrator.financesystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class E6_Loan extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e6_loan);

        findViewById(R.id.e6_backarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(E6_Loan.this, E1_WealthIndex.class));
            }
        });
    }

    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);
        setContentView(R.layout.e6_loan);

        findViewById(R.id.e6_backarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(E6_Loan.this, E1_WealthIndex.class));
            }
        });
    }
}
