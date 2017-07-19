package com.edu.sra.trainings.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.edu.sra.trainings.utils.EntityUser;

/**
 * Created by sravan on 19/07/17.
 */

public class MyDataBase extends SQLiteOpenHelper {

    private static final String TAG = "Training:MyDataBase";
    private Context mctx;
    private SQLiteDatabase mDatabse;

    public MyDataBase(Context context) {

        super(context, DBConstants.DB_NAME, null, DBConstants.DB_VERSION);
        mctx = context;
        mDatabse = getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DBConstants.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public long insertData(EntityUser user) {

        ContentValues cv = new ContentValues();
        cv.put(DBConstants.COL_NAME, user.getUserName());
        cv.put(DBConstants.COL_PASSWORD, user.getUserPassword());
        cv.put(DBConstants.COL_GENDER, user.isMale());
        cv.put(DBConstants.COL_MAIL, user.getUserEmail());
        long rowId = mDatabse.insert(DBConstants.TAB_NAME, DBConstants.COL_NAME, cv);
        Log.v(TAG, " insertData rowId:" + rowId);
        return rowId;
    }


    public boolean checkUser(String userName, String password) {

        Cursor cursor = mDatabse.rawQuery("select * from " + DBConstants.TAB_NAME + " where " + DBConstants.COL_NAME + "= '" + userName
                + "' and " + DBConstants.COL_PASSWORD + "='" + password + "'", null);

        if (cursor != null && cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }


}
