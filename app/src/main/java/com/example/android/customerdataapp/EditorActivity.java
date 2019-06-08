package com.example.android.customerdataapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.customerdataapp.data.MCGContract;
import com.example.android.customerdataapp.data.MCGDbHelper;

public class EditorActivity extends AppCompatActivity {
    MCGDbHelper mcgDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        setTitle("Insert");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId())
        {
            case R.id.save:
                insertData();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    public void insertData()
    {
        //Initialization ---
        EditText CName=(EditText)findViewById(R.id.CName);
        EditText CAge=(EditText)findViewById(R.id.CAge);
        EditText CPhone=(EditText) findViewById(R.id.CPhone);
        EditText CDate=(EditText)findViewById(R.id.CDate);
        EditText CComments=(EditText)findViewById(R.id.CComments);


        EditText DV_L_SPH=(EditText)findViewById(R.id.DV_L_SPH);
        EditText DV_L_CYL=(EditText)findViewById(R.id.DV_L_CYL);
        EditText DV_L_AXIS=(EditText)findViewById(R.id.DV_L_AXIS);

        EditText DV_R_SPH=(EditText)findViewById(R.id.DV_R_SPH);
        EditText DV_R_CYL=(EditText)findViewById(R.id.DV_R_CYl);
        EditText DV_R_AXIS=(EditText)findViewById(R.id.DV_R_AXIS);

        EditText NV_L_SPH=(EditText)findViewById(R.id.NV_L_SPH);
        EditText NV_L_CYL=(EditText)findViewById(R.id.NV_L_CYL);
        EditText NV_L_AXIS=(EditText)findViewById(R.id.NV_L_AXIS);

        EditText NV_R_SPH=(EditText)findViewById(R.id.NV_L_SPH);
        EditText NV_R_CYL=(EditText)findViewById(R.id.NV_L_CYL);
        EditText NV_R_AXIS=(EditText)findViewById(R.id.NV_L_AXIS);

        //String Init ---

        String Cname=CName.getText().toString();
        String Cage=CAge.getText().toString();
        String Cphone=CPhone.getText().toString();
        String Cdate=CDate.getText().toString();
        String Ccomments=CComments.getText().toString();
        if(TextUtils.isEmpty(Cname.trim())) {
            CName.setError("Please Enter Name !");
            return;
        }

        try{ int age=Integer.parseInt(Cage);
            }
        catch (Exception e)
        {
            CAge.setError("Please Enter Age !");
            return;
        }
        try {
            float FDV_L_SPH = Float.parseFloat(DV_L_SPH.getText().toString());
            float FDV_L_CYL = Float.parseFloat(DV_L_CYL.getText().toString());
            float FDV_L_AXIS = Float.parseFloat(DV_L_AXIS.getText().toString());
            float FDV_R_SPH = Float.parseFloat(DV_R_SPH.getText().toString());
            float FDV_R_CYL = Float.parseFloat(DV_R_CYL.getText().toString());
            float FDV_R_AXIS = Float.parseFloat(DV_R_AXIS.getText().toString());
            float FNV_L_SPH = Float.parseFloat(NV_L_SPH.getText().toString());
            float FNV_L_CYL = Float.parseFloat(NV_L_CYL.getText().toString());
            float FNV_L_AXIS = Float.parseFloat(NV_L_AXIS.getText().toString());
            float FNV_R_SPH = Float.parseFloat(NV_R_SPH.getText().toString());
            float FNV_R_CYL = Float.parseFloat(NV_R_CYL.getText().toString());
            float FNV_R_AXIS = Float.parseFloat(NV_R_AXIS.getText().toString());

        mcgDbHelper=new MCGDbHelper(this);
        SQLiteDatabase db=mcgDbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NAME,Cname);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_AGE,Integer.parseInt(Cage));
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_PHONE_NO,Cphone);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DATE,Cdate);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_COMMENTS,Ccomments);

        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_L_SPH,FDV_L_SPH);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_L_CYL,FDV_L_CYL);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_L_AXIS,FDV_L_AXIS);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_R_SPH,FDV_R_SPH);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_R_CYL,FDV_R_CYL);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_R_AXIS,FDV_R_AXIS);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_L_SPH,FNV_L_SPH);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_L_CYL,FNV_L_CYL);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_L_AXIS,FNV_L_AXIS);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_R_SPH,FNV_R_SPH);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_R_CYL,FNV_R_CYL);
        values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_R_AXIS,FNV_R_AXIS);


        long newRowId=db.insert(MCGContract.CustomerEntry.TABLE_NAME,null,values);


        if(newRowId!=-1)
        {
            Toast.makeText(getBaseContext(),"Inserted !",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(EditorActivity.this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Not Inserted !",Toast.LENGTH_SHORT).show();
        }


        }
        catch (Exception e) {
            Toast.makeText(getBaseContext(), "Fill In the Missing Values !", Toast.LENGTH_SHORT).show();
            return;
        }

    }







}


