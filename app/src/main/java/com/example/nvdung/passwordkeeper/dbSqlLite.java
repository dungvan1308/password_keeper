package com.example.nvdung.passwordkeeper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by nvdung on 08/04/2016.
 * Process save data to database
 *
 */


public class dbSqlLite extends SQLiteOpenHelper {



    //Khai bao bien
    private  static  final  int database_version =1;
    private static final String database_name = "db_PasswordKeeper";
    private static final  String table_name ="PasswordKeeper";

    //Colum name
    private static final String ID = "ID";
    private static final String db_Link="Link";
    private static final String db_User = "User";
    private static final String db_UserName ="UserName";

    public dbSqlLite(Context context) {
        super(context, database_name, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
            Dungnv  : 08/04/2016
            Purpose : Khoi tao database
        */
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + table_name + "("
                + ID + " INTEGER PRIMARY KEY," + db_Link + " TEXT,"
                + db_User + " TEXT," + ""
                + db_UserName + " TEXT" +
                ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + table_name);

        // Create tables again
        onCreate(db);
    }

    public void save(String strLink,String strUser,String strUserName)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(db_Link,strLink);
        values.put(db_User,strUser);
        values.put(db_UserName,strUserName);

        // Inserting Row
        db.insert(table_name, null, values);
        Log.i(table_name,"User : " + strUser + "UserName : " + strUserName );


    }

    public double getCoutRow ()
    {
        String strSql = "select * from " + table_name ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(strSql, null);

        // return count
        return cursor.getCount();

    }

}
