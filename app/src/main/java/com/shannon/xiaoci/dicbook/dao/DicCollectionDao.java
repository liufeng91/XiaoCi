package com.shannon.xiaoci.dicbook.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.shannon.xiaoci.dicbook.bean.DicCollection;

import org.w3c.dom.Text;

/**
 * Created by Shannon on 2016/4/12.
 */
public class DicCollectionDao {


    //添加单词到单词本

    public void addWord(Context context , String word){


        if(!TextUtils.isEmpty(word)){


            DicCollectionDb dcd = new DicCollectionDb(context,DicCollectionDb.DIC_COLLECTION_DB_NAME,null,DicCollectionDb.DIC_COLLECTION_VERSION);
            SQLiteDatabase sd = dcd.getWritableDatabase();
            String insertSql = "insert into " + DicCollectionDb.DIC_COLLECTION_TABLE_NAME
                    +"(word) values (?)";

            sd.execSQL(insertSql , new String[]{insertSql});


        }


    }


    //查询
    public String selectWord(Context context,String word){

        if(TextUtils.isEmpty(word)){


            DicCollectionDb dcd = new DicCollectionDb(context,DicCollectionDb.DIC_COLLECTION_DB_NAME,null,DicCollectionDb.DIC_COLLECTION_VERSION);
            SQLiteDatabase sd = dcd.getReadableDatabase();
            String selectSql = "select word from "+ DicCollectionDb.DIC_COLLECTION_TABLE_NAME + " where word = ?";
            Cursor cursor = sd.rawQuery(selectSql , new String[]{selectSql});
            if(cursor!=null){

                if(cursor.moveToFirst()){

                    return cursor.getString(cursor.getColumnIndex("word"));

                }

            }


        }

        return null;



    }


    //删除
    public void delete(Context context , String word){


        if(!TextUtils.isEmpty(word)){


            DicCollectionDb dcd = new DicCollectionDb(context,DicCollectionDb.DIC_COLLECTION_DB_NAME,null,DicCollectionDb.DIC_COLLECTION_VERSION);
            SQLiteDatabase sd = dcd.getWritableDatabase();
            String deleteSql = "delete * from "+ DicCollectionDb.DIC_COLLECTION_TABLE_NAME + " where word = ?";
            sd.execSQL(deleteSql , new String[]{word});




        }


    }




}
