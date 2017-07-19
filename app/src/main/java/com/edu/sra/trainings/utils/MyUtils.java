package com.edu.sra.trainings.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.edu.sra.trainings.database.MyDataBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sravan on 18/07/17.
 */

public class MyUtils {


    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    /* Shared prefences : We can store primitaive data ( int , flaot, char , String , boolean )
    in the form of XML based on key and values
  SharedPrefence
  Editior
  Preferencemanager


     */


    public static long saveUserDataInDb(Context ctx, EntityUser entityUser) {
        MyDataBase db = new MyDataBase(ctx);
        long rowId = db.insertData(entityUser);
        return rowId;

    }

    public static boolean checkUser(Context ctx, String userName, String password) {
        MyDataBase db = new MyDataBase(ctx);
        return db.checkUser(userName, password);


    }

    // Save data in share dpreference

    public static void saveUserDataInPreference(Context ctx, EntityUser entityUser) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor edit = pref.edit();
        edit.putBoolean("gender", entityUser.isMale());
        edit.putString("email", entityUser.getUserEmail());
        edit.putString("password", entityUser.getUserPassword());
        edit.putString("username", entityUser.getUserName());
        edit.commit(); // in APP memory in the form of XML

    }

    // Fetch Saved Data
    public static EntityUser getUserData(Context ctx) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        EntityUser entityUser = new EntityUser();
        boolean gender = pref.getBoolean("gender", false);
        entityUser.setMale(gender);
        entityUser.setUserEmail(pref.getString("email", ""));
        entityUser.setUserName(pref.getString("username", ""));
        entityUser.setUserPassword(pref.getString("password", ""));
        return entityUser;
    }


}
