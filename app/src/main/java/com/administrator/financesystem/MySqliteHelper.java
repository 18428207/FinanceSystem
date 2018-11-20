package com.administrator.financesystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.view.View;

public class MySqliteHelper extends SQLiteOpenHelper {

    private final int BUFFER_SIZE = 400000;
    public static final String DB_NAME = "fs.db"; //保存的数据库文件名
    public static final String PACKAGE_NAME = "com.administrator.financesystem";
    public static final String DB_PATH = "/data"
            + Environment.getDataDirectory().getAbsolutePath() + "/"
            + PACKAGE_NAME;  //在手机里存放数据库的位置
    private static Integer Version = 1;
    private static  MySqliteHelper dbHelper;

    private static final int DATABASE_VERSION = 1;
    // Database name
    private static final String DATABASE_NAME = "fs.db";


    public MySqliteHelper(Context context) {
        super(context, "fs.db", null, 1);
        // TODO Auto-generated constructor stub

    }


    public MySqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        //必须通过super调用父类当中的构造函数
        super(context, name, factory, version);
    }
    //参数说明
    //context:上下文对象
    //name:数据库名称
    //param:factory
    //version:当前数据库的版本，值必须是整数并且是递增的状态

    public MySqliteHelper(Context context, String name, int version) {
        this(context, name, null, version);
    }


    public MySqliteHelper(View.OnClickListener context, String name) {
        this((Context) context, name, Version);
    }

    //当数据库创建的时候被调用
    @Override
    public void onCreate(SQLiteDatabase db) {

        System.out.println("创建数据库和表");
        //创建了数据库并创建一个叫records的表
        //SQLite数据创建支持的数据类型： 整型数据，字符串类型，日期类型，二进制的数据类型
        String sql = "create table user(id int primary key,name varchar(200))";
        //execSQL用于执行SQL语句
        //完成数据库的创建
        db.execSQL(sql);
        //数据库实际上是没有被创建或者打开的，直到getWritableDatabase() 或者 getReadableDatabase() 方法中的一个被调用时才会进行创建或者打开


    }

    //数据库升级时调用
    //如果DATABASE_VERSION值被改为2,系统发现现有数据库版本不同,即会调用onUpgrade（）方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("更新数据库版本为:" + newVersion);
    }


    public static MySqliteHelper getInstance(Context context) {

        if (dbHelper == null) { //单例模式
            dbHelper = new MySqliteHelper(context);
        }
        return dbHelper;
    }

}