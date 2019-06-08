package com.example.android.customerdataapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.customerdataapp.data.MCGContract;
import com.example.android.customerdataapp.data.MCGContract.CustomerEntry;
import com.example.android.customerdataapp.data.MCGDbHelper;

public class Update_DeleteActivity extends AppCompatActivity {
    MCGDbHelper mcgDbHelper;
    long ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__delete);

        setTitle("Update");
        ID= getIntent().getLongExtra("C_ID",-1);
        if(ID==-1)
        {
            finish();
        }

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

        EditText NV_R_SPH=(EditText)findViewById(R.id.NV_R_SPH);
        EditText NV_R_CYL=(EditText)findViewById(R.id.NV_R_CYL);
        EditText NV_R_AXIS=(EditText)findViewById(R.id.NV_R_AXIS);
        mcgDbHelper=new MCGDbHelper(this);
        SQLiteDatabase db=mcgDbHelper.getReadableDatabase();
        Cursor selectAll=db.query(CustomerEntry.TABLE_NAME,null, CustomerEntry._ID+" = "+ (int)ID,null,null,null,null);
        String Cname;
        int Cage;
        String Cphone;
        String Cdate;
        String Ccomments;

        String SDV_L_SPH;
        String SDV_L_CYL;
        String SDV_L_AXIS;
        String SDV_R_SPH;
        String SDV_R_CYL;
        String SDV_R_AXIS;
        String SNV_L_SPH;
        String SNV_L_CYL;
        String SNV_L_AXIS;
        String SNV_R_SPH;
        String SNV_R_CYL;
        String SNV_R_AXIS;


        // if (selectAll.moveToNext()) {
        selectAll.moveToNext();
        Cname=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_NAME));
        Cage=selectAll.getInt(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_AGE));
        Cphone=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_PHONE_NO));
        Cdate=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_DATE));
        Ccomments=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_COMMENTS));
        SDV_L_SPH=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_DV_L_SPH));
        SDV_L_CYL=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_DV_L_CYL));
        SDV_L_AXIS=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_DV_L_AXIS));
        SDV_R_SPH=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_DV_R_SPH));
        SDV_R_CYL=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_DV_R_CYL));
        SDV_R_AXIS=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_DV_R_AXIS));
        SNV_L_SPH=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_NV_L_SPH));
        SNV_L_CYL=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_NV_L_CYL));
        SNV_L_AXIS=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_NV_L_AXIS));
        SNV_R_SPH=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_NV_R_SPH));
        SNV_R_CYL=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_NV_R_CYL));
        SNV_R_AXIS=selectAll.getString(selectAll.getColumnIndex(CustomerEntry.COLUMN_CUSTOMER_NV_R_AXIS));


        selectAll.close();
        CName.setText(Cname);
        CAge.setText(""+Cage);
        CPhone.setText(Cphone);
        CDate.setText(Cdate);
        CComments.setText(Ccomments);
        DV_L_SPH.setText(SDV_L_SPH);
        DV_L_CYL.setText(SDV_L_CYL);
        DV_L_AXIS.setText(SDV_L_AXIS);
        DV_R_SPH.setText(SDV_R_SPH);
        DV_R_CYL.setText(SDV_R_CYL);
        DV_R_AXIS.setText(SDV_R_AXIS);
        NV_L_SPH.setText(SNV_L_SPH);
        NV_L_CYL.setText(SNV_L_CYL);
        NV_L_AXIS.setText(SNV_L_AXIS);
        NV_R_SPH.setText(SNV_R_SPH);
        NV_R_CYL.setText(SNV_R_CYL);
        NV_R_AXIS.setText(SNV_R_AXIS);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_delete, menu);
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
                update();
                return true;
            case R.id.delete:
                delete();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void update() {
        EditText CName = (EditText) findViewById(R.id.CName);
        EditText CAge = (EditText) findViewById(R.id.CAge);
        EditText CPhone = (EditText) findViewById(R.id.CPhone);
        EditText CDate = (EditText) findViewById(R.id.CDate);
        EditText CComments = (EditText) findViewById(R.id.CComments);


        EditText DV_L_SPH = (EditText) findViewById(R.id.DV_L_SPH);
        EditText DV_L_CYL = (EditText) findViewById(R.id.DV_L_CYL);
        EditText DV_L_AXIS = (EditText) findViewById(R.id.DV_L_AXIS);

        EditText DV_R_SPH = (EditText) findViewById(R.id.DV_R_SPH);
        EditText DV_R_CYL = (EditText) findViewById(R.id.DV_R_CYl);
        EditText DV_R_AXIS = (EditText) findViewById(R.id.DV_R_AXIS);

        EditText NV_L_SPH = (EditText) findViewById(R.id.NV_L_SPH);
        EditText NV_L_CYL = (EditText) findViewById(R.id.NV_L_CYL);
        EditText NV_L_AXIS = (EditText) findViewById(R.id.NV_L_AXIS);

        EditText NV_R_SPH = (EditText) findViewById(R.id.NV_L_SPH);
        EditText NV_R_CYL = (EditText) findViewById(R.id.NV_L_CYL);
        EditText NV_R_AXIS = (EditText) findViewById(R.id.NV_L_AXIS);

        //String Init ---

        String Cname = CName.getText().toString();
        String Cage = CAge.getText().toString();
        String Cphone = CPhone.getText().toString();
        String Cdate = CDate.getText().toString();
        String Ccomments = CComments.getText().toString();


        if (TextUtils.isEmpty(Cname.trim())) {
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

            mcgDbHelper = new MCGDbHelper(this);
            SQLiteDatabase db = mcgDbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NAME, Cname);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_AGE, Integer.parseInt(Cage));
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_PHONE_NO, Cphone);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DATE, Cdate);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_COMMENTS, Ccomments);

            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_L_SPH, FDV_L_SPH);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_L_CYL, FDV_L_CYL);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_L_AXIS, FDV_L_AXIS);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_R_SPH, FDV_R_SPH);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_R_CYL, FDV_R_CYL);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DV_R_AXIS, FDV_R_AXIS);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_L_SPH, FNV_L_SPH);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_L_CYL, FNV_L_CYL);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_L_AXIS, FNV_L_AXIS);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_R_SPH, FNV_R_SPH);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_R_CYL, FNV_R_CYL);
            values.put(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NV_R_AXIS, FNV_R_AXIS);

            int isUpdated = db.update(CustomerEntry.TABLE_NAME, values, CustomerEntry._ID + " = " + (int) ID, null);
            if (isUpdated == 1) {
                Toast.makeText(getBaseContext(), "Info Updated !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(getBaseContext(), "Update Unsuccessful !", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        catch (Exception e) {
        Toast.makeText(getBaseContext(), "Fill In the Missing Values !", Toast.LENGTH_SHORT).show();
        return;
    }
    }

    public void delete()
    {
        mcgDbHelper = new MCGDbHelper(this);
        SQLiteDatabase db = mcgDbHelper.getWritableDatabase();
        int isDeleted=db.delete(CustomerEntry.TABLE_NAME,CustomerEntry._ID + " = " + (int) ID,null);
        if(isDeleted==1) {
            Toast.makeText(getBaseContext(), "Customer Deleted !", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(getBaseContext(), "Delete Unsuccessful !", Toast.LENGTH_SHORT).show();
            finish();
        }


    }

}

