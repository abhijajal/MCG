package com.example.android.customerdataapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.customerdataapp.data.MCGContract.CustomerEntry;


import com.example.android.customerdataapp.data.MCGContract;
import com.example.android.customerdataapp.data.MCGDbHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class MainActivity extends AppCompatActivity {
    MCGDbHelper mcgDbHelper;
    private static final String DATABASE_NAME = "customer.db";
    private static final String PACKAGE_NAME = "com.example.android.customerdataapp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
        setTitle("List");
        displayDatabaseInfo();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.search:
                Intent intent = new Intent(getBaseContext(), SearchActivity.class);
                startActivity(intent);
                return true;
            case R.id.backup:
                backup();
                return true;
            case R.id.restore:
                restore();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayDatabaseInfo() {

        mcgDbHelper = new MCGDbHelper(this);

        SQLiteDatabase db = mcgDbHelper.getReadableDatabase();
        Cursor selectAll = db.query(CustomerEntry.TABLE_NAME, null, null, null, null, null, CustomerEntry.COLUMN_CUSTOMER_NAME + " COLLATE NOCASE");

        while (selectAll.moveToNext()) {

            for (int i = 0; i < selectAll.getColumnCount(); i++) {
                String value = selectAll.getString(i);
            }
        }


        ListView customerListView = (ListView) findViewById(R.id.list);
        CustomerCursorAdapter adapter = new CustomerCursorAdapter(this, selectAll);
        customerListView.setAdapter(adapter);
        customerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getBaseContext(), Update_DeleteActivity.class);
                intent.putExtra("C_ID", id);
                startActivity(intent);
            }
        });
//        selectAll.close();


    }

    /*
      public void insertFakeData()

      {
          mcgDbHelper=new MCGDbHelper(this);

          SQLiteDatabase db=mcgDbHelper.getWritableDatabase();
          ContentValues values=new ContentValues();
          values.put(CustomerEntry.COLUMN_CUSTOMER_NAME,"Abhi");
          values.put(CustomerEntry.COLUMN_CUSTOMER_AGE,20);
          values.put(CustomerEntry.COLUMN_CUSTOMER_PHONE_NO,"7383511790");
          values.put(CustomerEntry.COLUMN_CUSTOMER_DATE,"02-09-1996");
          values.put(CustomerEntry.COLUMN_CUSTOMER_DV_L_SPH,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_DV_L_CYL,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_DV_L_AXIS,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_DV_R_SPH,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_DV_R_CYL,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_DV_R_AXIS,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_NV_L_SPH,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_NV_L_CYL,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_NV_L_AXIS,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_NV_R_SPH,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_NV_R_CYL,0.00);
          values.put(CustomerEntry.COLUMN_CUSTOMER_NV_R_AXIS,0.00);

          long newRowId=db.insert(CustomerEntry.TABLE_NAME,null,values);
          if(newRowId!=-1)
          {
              Toast.makeText(this,"Inserted !",Toast.LENGTH_SHORT).show();
          }
          else
          {
              Toast.makeText(this,"Not Inserted !",Toast.LENGTH_SHORT).show();
          }
        
      }
      */
    public void backup() {

        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();
            String path = "/MCG_Backup/" + DATABASE_NAME;
            if (sd.canWrite()) {
                String currentDBPath = "//data//" + PACKAGE_NAME
                        + "//databases//" + DATABASE_NAME;
                String backupDBPath = path;
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(getBaseContext(), "Backup Successful!",
                        Toast.LENGTH_SHORT).show();

            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Backup Failed!", Toast.LENGTH_SHORT)
                    .show();

        }
    }

    public void restore() {

        try{
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String restroredDBPath = "//data//"+PACKAGE_NAME+"//databases//"+DATABASE_NAME;
                String backupDBPath = "/MCG_Backup/"+DATABASE_NAME;
                File restoredDB = new File(data, restroredDBPath);
                File backupedDB = new File(sd, backupDBPath);
                FileChannel src = new FileInputStream(backupedDB).getChannel();
                FileChannel dst = new FileOutputStream(restoredDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                Toast.makeText(getBaseContext(), "Restore Successfull ! Please Open the App Again !", Toast.LENGTH_LONG).show();

            }
        } catch (Exception e) {

            Toast.makeText(getBaseContext(), e.toString(), Toast.LENGTH_LONG).show();
        }


/*
        String path="/MCG_Backup/"+DATABASE_NAME;
            try {
                File sd = Environment.getExternalStorageDirectory();
                File data = Environment.getDataDirectory();
                if (sd.canWrite()) {
                    String currentDBPath = "//data//" + PACKAGE_NAME
                            + "//databases//" + DATABASE_NAME;
                    String backupDBPath =path; // From SD directory.
                    File backupDB = new File(data, currentDBPath);
                    File currentDB = new File(sd, backupDBPath);

                    FileChannel src = new FileInputStream(backupDB).getChannel();
                    FileChannel dst = new FileOutputStream(currentDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                    Toast.makeText(getBaseContext(), "Import Successful!",
                            Toast.LENGTH_SHORT).show();

                }
            } catch (Exception e) {

                Toast.makeText(getBaseContext(), "Import Failed!", Toast.LENGTH_SHORT)
                        .show();

            }
        }*/


    }
}

