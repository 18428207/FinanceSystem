package com.administrator.financesystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class B2_TotalAssets extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b2_totalassets);

        final String getbacknumber = (String) getIntent().getExtras().get("hintNumber");
        Log.v("test","get hintNumber is :"+getbacknumber);

        findViewById(R.id.b2_backarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getbacknumber=="b1"){
                    startActivity(new Intent(B2_TotalAssets.this, B1_MyIndex.class));
                }
                else if(getbacknumber=="e1"){
                    startActivity(new Intent(B2_TotalAssets.this, E1_WealthIndex.class));
                }
            }
        });

    }
}
