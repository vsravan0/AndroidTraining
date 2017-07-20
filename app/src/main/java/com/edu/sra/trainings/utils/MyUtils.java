package com.edu.sra.trainings.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.edu.sra.trainings.database.MyDataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sravan on 18/07/17.
 */

public class MyUtils {


    // Load The data
    public static final String TAG = "MyUtils";
    /* Shared prefences : We can store primitaive data ( int , flaot, char , String , boolean )
    in the form of XML based on key and values
  SharedPrefence
  Editior
  Preferencemanager


     */

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static long saveUserDataInDb(Context ctx, EntityUser entityUser) {
        MyDataBase db = new MyDataBase(ctx);
        long rowId = db.insertData(entityUser);
        return rowId;

    }

    // Save data in share dpreference

    public static boolean checkUser(Context ctx, String userName, String password) {
        MyDataBase db = new MyDataBase(ctx);
        return db.checkUser(userName, password);


    }

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

    public static String loadData(String path) {
        String response = "";

        try {

            URL url = new URL(path); // URL object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect(); // will try to connect
            int responseCode = connection.getResponseCode(); // Get Response code
            Log.v(TAG, "loadData responseCode: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream isr = connection.getInputStream(); // Get the data as InputStream
                response = convertStreamtoString(isr);

            }

        } catch (MalformedURLException e) {
            Log.v(TAG, "loadData : " + e.toString());
        } catch (IOException e) {
            Log.v(TAG, "loadData : " + e.toString());
        }
        return response;


    }

    private static String convertStreamtoString(InputStream isr) {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(isr));
            String data = "";
            StringBuffer response = new StringBuffer();
            while ((data = buf.readLine()) != null) {
                response.append(data);
            }

            Log.v(TAG, " Response :" + response);
            return response.toString();
        } catch (IOException e) {
            Log.v(TAG, " convertStreamtoString :" + e.toString());
            return "";
        }
    }

}
