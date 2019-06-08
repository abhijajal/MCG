package com.example.android.customerdataapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.android.customerdataapp.data.MCGContract;

/**
 * Created by abhij on 05/10/2017.
 */

public class CustomerCursorAdapter extends CursorAdapter{

    public CustomerCursorAdapter(Context context, Cursor c)
    {
        super(context,c,0);
    }
    public View newView(Context context, Cursor c, ViewGroup parent)
    {
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }
    public void bindView(View view, Context context, Cursor cursor)
    {
        TextView nameTextView =(TextView) view.findViewById(R.id.name);
        TextView summaryTextView =(TextView) view.findViewById(R.id.summary);

        int nameColumnIndex=cursor.getColumnIndex(MCGContract.CustomerEntry.COLUMN_CUSTOMER_NAME);
        int summaryColumnIndex=cursor.getColumnIndex(MCGContract.CustomerEntry.COLUMN_CUSTOMER_DATE);
        int phoneColumnIndex=cursor.getColumnIndex(MCGContract.CustomerEntry.COLUMN_CUSTOMER_PHONE_NO);

        String customerName=cursor.getString(nameColumnIndex);
        String customerDate=cursor.getString(summaryColumnIndex);
        String customerPhone=cursor.getString(phoneColumnIndex);

        nameTextView.setText(customerName);
        summaryTextView.setText(customerDate);
        summaryTextView.append("\n"+customerPhone);

    }


}