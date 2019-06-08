package com.example.android.customerdataapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.android.customerdataapp.data.MCGContract;
import com.example.android.customerdataapp.data.MCGDbHelper;

public class SearchActivity extends AppCompatActivity {

    EditText CustomerName;
    Button SearchButton;
    MCGDbHelper mcgDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        setTitle("Search");
        CustomerName=(EditText)findViewById(R.id.CustomerName);
        SearchButton=(Button)findViewById(R.id.searchBtn);
        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerName=CustomerName.getText().toString();

                if(TextUtils.isEmpty(customerName.trim())){
                    CustomerName.setError("Please Enter The Name");
                    return;
                }

                displaySearchResults(customerName);
            }
        });
    }
    public void displaySearchResults(String customerName)
    {
        mcgDbHelper=new MCGDbHelper(this);

        SQLiteDatabase db=mcgDbHelper.getReadableDatabase();

//        Cursor searchResults=db.query(MCGContract.CustomerEntry.TABLE_NAME,null,null,null,null, MCGContract.CustomerEntry.COLUMN_CUSTOMER_NAME+"="+"", MCGContract.CustomerEntry.COLUMN_CUSTOMER_NAME +" COLLATE NOCASE");
        Cursor searchResults=db.rawQuery("select * from "+ MCGContract.CustomerEntry.TABLE_NAME+" where "+ MCGContract.CustomerEntry.COLUMN_CUSTOMER_NAME+" like '%"+customerName+"%'",null);
        while (searchResults.moveToNext()) {

            for(int i=0;i<searchResults.getColumnCount();i++) {
                String value = searchResults.getString(i);
            }
        }


        ListView customerListView=(ListView) findViewById(R.id.searchList);
        CustomerCursorAdapter adapter=new CustomerCursorAdapter(this,searchResults);
        customerListView.setAdapter(adapter);
        customerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getBaseContext(),Update_DeleteActivity.class);
                intent.putExtra("C_ID", id);
                startActivity(intent);
            }
        });
    }

}
