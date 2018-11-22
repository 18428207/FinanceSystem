package com.administrator.financesystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C1_FriendsIndex extends AppCompatActivity {

    private MySqliteHelper helper;
    EditText searchtext;
   Button submit;
    ListView friendslist;
    SimpleAdapter adapter1;
CardView search;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c1_friendindex);
        helper = new MySqliteHelper(this, "fs.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        findViewById(R.id.c1_backarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(C1_FriendsIndex.this, A2_Login.class));
            }
        });


        searchtext = findViewById(R.id.c1_searchtext);
         String stext = searchtext.getText().toString();

        submit=findViewById(R.id.c1_searchsubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stext = searchtext.getText().toString();
                AlertDialog.Builder builder2 = new AlertDialog.Builder(C1_FriendsIndex.this);
                builder2.setTitle("Please confirm your searching content");
                builder2.setMessage("You are searching: "+stext);
                builder2.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(C1_FriendsIndex.this, C1_FriendsIndex.class));
                    }
                }).show();

            }
        });

        findViewById(R.id.c1_jumpToWealth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String getuserid = (String) getIntent().getExtras().get("NowUserID");
                Bundle bundle = new Bundle();
//                bundle.putString("NowUserID", getuserid);
                Intent intent = new Intent(C1_FriendsIndex.this, E1_WealthIndex.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        findViewById(R.id.c1_jumpToMy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
//                String getuserid = (String) getIntent().getExtras().get("NowUserID");
//                bundle.putString("NowUserID", getuserid);
                Intent intent = new Intent(C1_FriendsIndex.this, B1_MyIndex.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


//        friendslist = findViewById(R.id.c1_friend);
//        adapter1 = new SimpleAdapter(C1_FriendsIndex.this, getDbData1(), R.layout.c1_friendsitem,
//                new String[]{"FriendID"},
//                new int[]{R.id.c1_friendname});
//        friendslist.setAdapter(adapter1);
//        friendslist.setSelection(ListView.FOCUS_DOWN);



    }

    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);
        setContentView(R.layout.c1_friendindex);
        helper = new MySqliteHelper(this, "fs.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        findViewById(R.id.c1_backarrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(C1_FriendsIndex.this, A2_Login.class));
            }
        });

//        final String getuserid = (String) getIntent().getExtras().get("NowUserID");

        searchtext = findViewById(R.id.c1_searchtext);

        submit.findViewById(R.id.c1_searchsubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stext = searchtext.getText().toString();
                AlertDialog.Builder builder2 = new AlertDialog.Builder(C1_FriendsIndex.this);
                builder2.setTitle("Please confirm your searching content");
                builder2.setMessage("You are searching: "+stext);
                builder2.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(C1_FriendsIndex.this, C1_FriendsIndex.class));
                    }
                }).show();

            }
        });

        findViewById(R.id.c1_jumpToWealth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getuserid = (String) getIntent().getExtras().get("NowUserID");
                Bundle bundle = new Bundle();
                bundle.putString("NowUserID", getuserid);
                Intent intent = new Intent(C1_FriendsIndex.this, E1_WealthIndex.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        findViewById(R.id.c1_jumpToMy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String getuserid = (String) getIntent().getExtras().get("NowUserID");
                bundle.putString("NowUserID", getuserid);
                Intent intent = new Intent(C1_FriendsIndex.this, B1_MyIndex.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public List<Map<String, Object>> getDbData1() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String getuserid = (String) getIntent().getExtras().get("NowUserID");

        Cursor cursor = db.rawQuery("select FriendID from ContactInfo where UserID='" + getuserid + "'"
                , null);
        while (cursor.moveToNext()) {

            Map<String, Object> map = new HashMap<String, Object>();
            String id = cursor.getString(cursor.getColumnIndex("FriendID"));
            Log.v("test","friendslist id"+id);
            map.put("FriendID", id);
            Cursor cursor1 = db.rawQuery("select UserImg from UserInfo where UserID='" + id + "'"
                    , null);
            while (cursor1.moveToNext()) {

                byte[] bytes = cursor1.getBlob(cursor1.getColumnIndex("UserImg"));
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, null);
                map.put("UserImg", bitmap);
            }
                list.add(map);

        }
        return list;
    }



}
