package com.administrator.financesystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C1_FriendsIndex extends AppCompatActivity {

    private MySqliteHelper helper;
    TextView searchtext;
    Button btnsubmit;
    ListView friendslist;
    SimpleAdapter adapter1;
CardView search;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c1_friends);
        helper = new MySqliteHelper(this, "fs.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

        final String getuserid = (String) getIntent().getExtras().get("NowUserID");
        Log.v("test","id in friendindex:"+getuserid);
        searchtext = findViewById(R.id.c1_searchtext);
        search = findViewById(R.id.c1_searchbox);
       search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("NowUserID", getuserid);
                Intent intent = new Intent(C1_FriendsIndex.this, C2_SearchFriend.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        friendslist = findViewById(R.id.c1_friendslist);
        adapter1 = new SimpleAdapter(C1_FriendsIndex.this, getDbData1(), R.layout.c1_friendsitem,
                new String[]{"FriendID"},
                new int[]{R.id.c1_friendname});
        friendslist.setAdapter(adapter1);
        friendslist.setSelection(ListView.FOCUS_DOWN);



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
