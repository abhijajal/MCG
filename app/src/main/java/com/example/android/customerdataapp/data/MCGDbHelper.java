package com.example.android.customerdataapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.example.android.customerdataapp.MainActivity;
import com.example.android.customerdataapp.data.MCGContract.CustomerEntry;
/**
 * Created by abhij on 05/09/2017.
 */

public class MCGDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="customer.db";
    private static final int DATABASE_VERSION=1;

    public MCGDbHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


       String SQl_CREATE_CUSTOMER_TABLE=
               "CREATE TABLE "+CustomerEntry.TABLE_NAME+"("
               + CustomerEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
               + CustomerEntry.COLUMN_CUSTOMER_NAME+" TEXT NOT NULL, "
               + CustomerEntry.COLUMN_CUSTOMER_AGE+" INTEGER, "
               + CustomerEntry.COLUMN_CUSTOMER_PHONE_NO+" TEXT, "
               + CustomerEntry.COLUMN_CUSTOMER_DATE+" TEXT, "
               + CustomerEntry.COLUMN_CUSTOMER_DV_L_SPH+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_DV_L_CYL+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_DV_L_AXIS+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_DV_R_SPH+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_DV_R_CYL+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_DV_R_AXIS+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_NV_L_SPH+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_NV_L_CYL+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_NV_L_AXIS+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_NV_R_SPH+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_NV_R_CYL+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_NV_R_AXIS+" REAL, "
               + CustomerEntry.COLUMN_CUSTOMER_COMMENTS+" TEXT );";

        db.execSQL(SQl_CREATE_CUSTOMER_TABLE);
//        db.execSQL("INSERT into "+CustomerEntry.TABLE_NAME+" VALUES ");






    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
