package com.edu.sra.trainings.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.edu.sra.trainings.R;
import com.edu.sra.trainings.utils.EntitiyMovie;

import java.util.ArrayList;

/**
 * Created by sravan on 21/07/17.
 */

public class AdapterMovies extends BaseAdapter {

    private ArrayList<EntitiyMovie> mList;
    private LayoutInflater mInflater;

    public AdapterMovies(ArrayList<EntitiyMovie> list, LayoutInflater inflater) {
        mList = list;
        mInflater = inflater;

    }

    @Override
    public EntitiyMovie getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.layout_row, null);

        TextView tvTitle = (TextView) v.findViewById(R.id.id_tv_title);
        TextView tvPosterPath = (TextView) v.findViewById(R.id.id_tv_poster_path);

        EntitiyMovie movie = getItem(position);
        tvTitle.setText("Title :" + movie.getTitle());
        tvPosterPath.setText(movie.getPoster_path());


        return v;
    }


}
