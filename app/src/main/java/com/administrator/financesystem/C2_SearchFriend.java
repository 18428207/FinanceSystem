package com.administrator.financesystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C2_SearchFriend extends AppCompatActivity {

    MySqliteHelper helper;
    Button btnsearch;
    EditText searchtext;
    private SimpleAdapter adapter1;
    ListView resultlist;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c2_searchindex);
        helper = new MySqliteHelper(this, "fs.db", null, 1);
        SQLiteDatabase db = helper.getReadableDatabase();

         String getuserid = (String) getIntent().getExtras().get("NowUserID");
        Log.v("test","userid in searchfriend"+getuserid);

        resultlist = findViewById(R.id.c2_resultlist);

        btnsearch = findViewById(R.id.c2_btnsearch);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                searchtext = findViewById(R.id.c2_searchtext);
                String getuserid = (String) getIntent().getExtras().get("NowUserID");
                String str = searchtext.getText().toString().trim();

                adapter1 = new SimpleAdapter(C2_SearchFriend.this, getDbData1(), R.layout.c2_searchitem,
                        new String[]{"FriendID"},
                        new int[]{R.id.c2_friendname});
                resultlist.setAdapter(adapter1);
                resultlist.setSelection(ListView.FOCUS_DOWN);
//                Cursor cursor = db.rawQuery("select FriendID from ContactInfo where FriendID like '%" + str + "%' and UserID='" + getuserid + "' "
//                        , null);
//                SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(C2_SearchFriend.this, R.layout.c2_searchitem, cursor,
//                        new String[]{"FriendID"},
//                        new int[]{R.id.c2_friendname}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
//                resultlist.setAdapter(cursorAdapter);
                resultlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                        Bundle bundle = new Bundle();
//                        Intent intent = new Intent(C2_SearchFriend.this, a_a_CourseInfo.class);
//
//                        String tStringcourid = ((TextView) view.findViewById(R.id.a_1i_id)).getText().toString();
//
//                        intent.putExtra("courseid1", tStringcourid);
//                        String tStringcourname = ((TextView) view.findViewById(R.id.a_1i_name)).getText().toString();
//                        intent.putExtra("coursename1", tStringcourname);
//
//                        String tStringmajname = ((TextView) view.findViewById(R.id.a_1i_majname)).getText().toString();
//                        intent.putExtra("majorname1", tStringmajname);
//                        String tStringperds = ((TextView) view.findViewById(R.id.a_1i_perds)).getText().toString();
//                        intent.putExtra("periods1", tStringperds);
//                        String tStringcrdts = ((TextView) view.findViewById(R.id.a_1i_crdts)).getText().toString();
//                        intent.putExtra("credits1", tStringcrdts);
//                        String tStringtchname = ((TextView) view.findViewById(R.id.a_1i_tchname)).getText().toString();
//                        intent.putExtra("teachername1", tStringtchname);
//                        String tStringcorequality = ((TextView) view.findViewById(R.id.a_1i_corequality)).getText().toString();
//                        intent.putExtra("coursequality1", tStringcorequality);
//                        String tStringtmode = ((TextView) view.findViewById(R.id.a_1i_tmode)).getText().toString();
//                        intent.putExtra("testmode1", tStringtmode);
//                        String tStringcorterm = ((TextView) view.findViewById(R.id.a_1i_corterm)).getText().toString();
//                        intent.putExtra("courseterm1", tStringcorterm);
//                        String tStringremark = ((TextView) view.findViewById(R.id.a_1i_remark)).getText().toString();
//                        intent.putExtra("remarks1", tStringremark);
//                        startActivity(intent);

                    }
                });
            }

    });
}

    public List<Map<String, Object>> getDbData1() {

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        SQLiteDatabase db = helper.getReadableDatabase();
        helper = new MySqliteHelper(this, "fs.db", null, 1);
        String getuserid = (String) getIntent().getExtras().get("NowUserID");
        Log.v("test","id:"+getuserid);
        String str = searchtext.getText().toString().trim();
        Cursor cursor = db.rawQuery("select FriendID from ContactInfo where FriendID like '%" + str + "%' and UserID='" + getuserid + "'", null);

        while (cursor.moveToNext()) {

            Map<String, Object> map = new HashMap<String, Object>();
            String id = cursor.getString(cursor.getColumnIndex("FriendID"));
            Log.v("test","cursor friend id"+id);
            map.put("FriendID in search", id);

            list.add(map);

        }
        return list;
    }
}

//    select FriendID from ContactInfo where FriendID like '%ch%' and UserID='bbh'