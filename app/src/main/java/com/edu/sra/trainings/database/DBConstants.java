package com.edu.sra.trainings.database;

/**
 * Created by sravan on 19/07/17.
 */

public class DBConstants {

    static final String DB_NAME = "androidtraining";
    static final String TAB_NAME = "user";
    static final int DB_VERSION = 1001;


    static final String COL_NAME = "name";
    static final String COL_MAIL = "mail";
    static final String COL_PASSWORD = "password";
    static final String COL_GENDER = "gender";

    static final String CREATE_TABLE = "create table if not exists " + TAB_NAME
            + "(" + COL_NAME + " text , " + COL_MAIL + " text , " + COL_PASSWORD + " text,"
            + COL_GENDER + " integer)";


}
