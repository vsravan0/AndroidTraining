package com.edu.sra.trainings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.edu.sra.trainings.utils.Constants;
import com.edu.sra.trainings.utils.EntitiyMovie;

public class MovieInfoActivity extends AppCompatActivity {
    TextView mTvId, mTvTitle, mTvVote, mTvPosterPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);
        mTvId = (TextView) findViewById(R.id.id_tv_id);
        mTvTitle = (TextView) findViewById(R.id.id_tv_title);
        mTvVote = (TextView) findViewById(R.id.id_tv_vote_average);
        mTvPosterPath = (TextView) findViewById(R.id.id_tv_posterpath);


        Intent intent = getIntent();
        EntitiyMovie movie = (EntitiyMovie) intent.getSerializableExtra(Constants.KEY_MOVIE);

        mTvId.setText(" ID :" + movie.getId());
        mTvTitle.setText(" Title  :" + movie.getTitle());
        mTvVote.setText(" Vote Average :" + movie.getVote_average());
        mTvPosterPath.setText(" Poster path :" + movie.getPoster_path());


    }

}
