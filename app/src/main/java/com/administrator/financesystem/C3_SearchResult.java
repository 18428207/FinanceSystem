//package com.administrator.financesystem;
//
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class C3_SearchResult extends AppCompatActivity {
//
//    MySqliteHelper helper;
//    Button btnsearch;
//    EditText searchtext;
//    private SimpleAdapter adapter1;
//    ListView resultlist;
//
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.c1_friendindex);
//        helper = new MySqliteHelper(this, "fs.db", null, 1);
//
//        SQLiteDatabase db = helper.getReadableDatabase();
//        searchtext = findViewById(R.id.c2_searchtext);
//        String getuserid = (String) getIntent().getExtras().get("NowUserID");
//        Log.v("test","getid"+getuserid);
//        String searchcontent = (String) getIntent().getExtras().get("SearchContent");
//        Log.v("test","getcontent"+searchcontent);
//
//        searchtext.setText(searchcontent);
//        adapter1 = new SimpleAdapter(C3_SearchResult.this, getDbData1(), R.layout.c2_searchitem,
//                new String[]{"FriendID"},
//                new int[]{R.id.c2_friendname});
//        resultlist.setAdapter(adapter1);
//        resultlist.setSelection(ListView.FOCUS_DOWN);
//    }
//
//    public List<Map<String, Object>> getDbData1() {
//
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        SQLiteDatabase db = helper.getReadableDatabase();
//        helper = new MySqliteHelper(this, "fs.db", null, 1);
//        String getuserid = (String) getIntent().getExtras().get("NowUserID");
//        Log.v("test", "id:" + getuserid);
////        String str = searchtext.getText().toString().trim();
//        String searchcontent = (String) getIntent().getExtras().get("SearchContent");
//Log.v("test","searchcontent:"+searchcontent);
//        Cursor cursor = db.rawQuery("select FriendID from ContactInfo where FriendID like '%" + searchcontent + "%' and UserID='" + getuserid + "'", null);
//
//        while (cursor.moveToNext()) {
//
//            Map<String, Object> map = new HashMap<String, Object>();
//            String id = cursor.getString(cursor.getColumnIndex("FriendID"));
//            Log.v("test", "cursor friend id" + id);
//            map.put("FriendID in search", id);
//
//            list.add(map);
//
//        }
//        return list;
//    }
//
//}
