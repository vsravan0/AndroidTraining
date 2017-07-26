package com.edu.sra.trainings;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.sra.trainings.adapter.AdapterMovies;
import com.edu.sra.trainings.utils.Constants;
import com.edu.sra.trainings.utils.EntitiyMovie;
import com.edu.sra.trainings.utils.MyUtils;
import com.edu.sra.trainings.utils.Parser;

import java.util.ArrayList;

/**
 * Created by sravan on 20/07/17.
 */

public class ActivityMovies extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<EntitiyMovie> list = new ArrayList<>();
    private ProgressBar mPbar;
    private TextView mTvResponse;
    private ListView mLvMovies;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_movies);
        mPbar = (ProgressBar) findViewById(R.id.id_progress);
        mTvResponse = (TextView) findViewById(R.id.id_tv_response);
        mPbar.setVisibility(ProgressBar.GONE);
        mLvMovies = (ListView) findViewById(R.id.id_lv_videos);
        mLvMovies.setOnItemClickListener(this);
    }

    public void loadData(View v) {
        MyAsyncTask task = new MyAsyncTask();
        task.execute(new String[]{Constants.SERVICE_URL});// the calls async task
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        EntitiyMovie movie = list.get(position);

        Intent intent = new Intent(this, MovieInfoActivity.class);
        intent.putExtra(Constants.KEY_MOVIE, movie);

        startActivity(intent);





        Toast.makeText(getApplicationContext(), " Cliked Item :" + position, Toast.LENGTH_LONG).show();


    }

    private void loadAdapterData() {
        AdapterMovies adapterMovies = new AdapterMovies(list, getLayoutInflater());
        mLvMovies.setAdapter(adapterMovies);


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
        protected void onPostExecute(String result) {

            mPbar.setVisibility(ProgressBar.GONE);
            mTvResponse.setText("Data Loaded ");
            super.onPostExecute(result);
            Parser parser = new Parser();
            list = parser.pasreData(result);
            loadAdapterData();


        }
    }

}
