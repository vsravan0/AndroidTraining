package com.edu.sra.trainings.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.edu.sra.trainings.R;
import com.edu.sra.trainings.adapter.AdapterRecycleView;
import com.edu.sra.trainings.listeners.RecycleViewItemListener;
import com.edu.sra.trainings.utils.Constants;
import com.edu.sra.trainings.utils.EntitiyMovie;
import com.edu.sra.trainings.utils.MyUtils;
import com.edu.sra.trainings.utils.Parser;

import java.util.ArrayList;

/**
 * Created by sravan on 27/07/17.
 */

public class ActivityRecycleView extends Activity
        implements RecycleViewItemListener {

    /*

    RecycleView and CradView


    RecycleView : -> ListView -> Data set




     */
    ArrayList<EntitiyMovie> list = new ArrayList<>();

    private RecyclerView mRecycleView;
    private ProgressBar mPbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycleview);
        mRecycleView = (RecyclerView) findViewById(R.id.id_rv_movies);
        mPbar = (ProgressBar) findViewById(R.id.id_pbar);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(lm);

        // GridLayoutManager gm = new GridLayoutManager(this,2);
        //mRecycleView.setLayoutManager(gm);

        loadData();

    }


    public void loadData() {
        MyAsyncTask task = new MyAsyncTask();
        task.execute(new String[]{Constants.SERVICE_URL});// the calls async task
    }


    private void loadAdapterData() {
        AdapterRecycleView adapterMovies = new AdapterRecycleView
                (list, getLayoutInflater(), this);


        mRecycleView.setAdapter(adapterMovies);


    }

    @Override
    public void onItemClick(int pos) {

        Toast.makeText(getApplicationContext(), " Clicked pos " + pos, Toast.LENGTH_SHORT).show();

    }

    class MyAsyncTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            mPbar.setVisibility(ProgressBar.VISIBLE);

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            // Will run in Back ground thread
            String response = MyUtils.loadData(params[0]);
            return response;
        }

        @Override
        protected void onPostExecute(String result) {

            mPbar.setVisibility(ProgressBar.GONE);
            super.onPostExecute(result);
            Parser parser = new Parser();
            list = parser.pasreData(result);
            loadAdapterData();


        }
    }
}
