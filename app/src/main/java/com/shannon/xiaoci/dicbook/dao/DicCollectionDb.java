package com.shannon.xiaoci.dicbook.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shannon on 2016/4/12.
 */
public class DicCollectionDb extends SQLiteOpenHelper{

    public static final String DIC_COLLECTION_DB_NAME = "dic_collection_db";
    public static final String DIC_COLLECTION_TABLE_NAME = "dic_collection";
    public static final int DIC_COLLECTION_VERSION = 1;



    public DicCollectionDb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //创建数据库
        String createSql = "create table " + DIC_COLLECTION_TABLE_NAME +"(" +
                "word varchar primary key";
        db.execSQL(createSql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
