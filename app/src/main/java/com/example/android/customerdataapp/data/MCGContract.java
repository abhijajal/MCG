package com.example.android.customerdataapp.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by abhij on 05/09/2017.
 */

public final class MCGContract {
    private MCGContract()
    {}
    public static final class CustomerEntry implements BaseColumns {

        public final static String TABLE_NAME = "Customer";
        public final static String _ID =BaseColumns._ID;
        public final static String COLUMN_CUSTOMER_NAME = "Name";
        public final static String COLUMN_CUSTOMER_AGE = "Age";
        public final static String COLUMN_CUSTOMER_PHONE_NO = "PhoneNo";
        public final static String COLUMN_CUSTOMER_DATE = "Date";
        public final static String COLUMN_CUSTOMER_DV_L_SPH = "DV_L_SPH";
        public final static String COLUMN_CUSTOMER_DV_L_CYL = "DV_L_CYL";
        public final static String COLUMN_CUSTOMER_DV_L_AXIS = "DV_L_AXIS";
        public final static String COLUMN_CUSTOMER_DV_R_SPH = "DV_R_SPH";
        public final static String COLUMN_CUSTOMER_DV_R_CYL = "DV_R_CYL";
        public final static String COLUMN_CUSTOMER_DV_R_AXIS = "DV_R_AXIS";
        public final static String COLUMN_CUSTOMER_NV_L_SPH = "NV_L_SPH";
        public final static String COLUMN_CUSTOMER_NV_L_CYL = "NV_L_CYL";
        public final static String COLUMN_CUSTOMER_NV_L_AXIS = "NV_L_AXIS";
        public final static String COLUMN_CUSTOMER_NV_R_SPH = "NV_R_SPH";
        public final static String COLUMN_CUSTOMER_NV_R_CYL = "NV_R_CYL";
        public final static String COLUMN_CUSTOMER_NV_R_AXIS = "NV_R_AXIS";
        public final static String COLUMN_CUSTOMER_COMMENTS = "Comments";
        public final static String CONTENT_AUTHORITY = "Comments";
        public final static String PATH_CUSTOMER = "Comments";


    }

}
