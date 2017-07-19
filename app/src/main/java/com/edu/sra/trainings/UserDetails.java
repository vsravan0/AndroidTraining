package com.edu.sra.trainings;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class UserDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*
    Shared Preference: store data in the form of key and values
    key : String
    value : int , float , double , boolean ( primitive ) , String

    Save mutliple Student Details :

    1) Name , rno , age grade ,

    SQL Lite : light weight database


    Android DB :

    Inbulit



    SqliteOpenHelper: to create Database

    SqliteDatabase : Create some tables , perform some operations on table ( insert , delete , update )

    Cursor : get Some data from Data Base
    Contentvalues : to Store some data in specifc table

     */

}
