package com.edu.sra.trainings;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.edu.sra.trainings.utils.Constants;
import com.edu.sra.trainings.utils.MyUtils;

/**
 * Created by sravan on 20/07/17.
 */

public class ActivityMovies extends AppCompatActivity {

    private ProgressBar mPbar;
    private TextView mTvResponse;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_movies);
        mPbar = (ProgressBar) findViewById(R.id.id_progress);
        mTvResponse = (TextView) findViewById(R.id.id_tv_response);
        mPbar.setVisibility(ProgressBar.GONE);
    }

    public void loadData(View v) {

        MyAsyncTask task = new MyAsyncTask();
        task.execute(new String[]{Constants.SERVICE_URL});// the calls async task
    }


    class MyAsyncTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            mPbar.setVisibility(ProgressBar.VISIBLE);
            mTvResponse.setText("Loading Data...");

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            // Will run in Back ground thread
            String response = MyUtils.loadData(params[0]);
            return response;
        }

        @Override
        protected void onPostExecute(String s) {

            mPbar.setVisibility(ProgressBar.GONE);
            mTvResponse.setText("Data Loaded " + s);
            super.onPostExecute(s);
        }
    }

    /*
    In Android need run Network operation on back ground thread



     */


    /*
    Call Web service :

    Want to communitae with server

     */
}
