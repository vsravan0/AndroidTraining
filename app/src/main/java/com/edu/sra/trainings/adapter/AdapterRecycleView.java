package com.edu.sra.trainings.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edu.sra.trainings.R;
import com.edu.sra.trainings.listeners.RecycleViewItemListener;
import com.edu.sra.trainings.utils.EntitiyMovie;

import java.util.ArrayList;

/**
 * Created by sravan on 27/07/17.
 */

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.Holder> {

    private ArrayList<EntitiyMovie> mList;
    private LayoutInflater mInflater;
    private RecycleViewItemListener mRvListener;

    public AdapterRecycleView(ArrayList<EntitiyMovie> list, LayoutInflater inflater,
                              RecycleViewItemListener listener) {
        mList = list;
        mInflater = inflater;
        mRvListener = listener;


    }

    // // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(Holder holder, final int position) {

        EntitiyMovie entity = mList.get(position);

        holder.tvPosterpath.setText(" Poster path :" + entity.getPoster_path());
        holder.tvTitle.setText(" Title :" + entity.getTitle());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRvListener.onItemClick(position);
            }
        });

    }

    // Create the View
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = mInflater.inflate(R.layout.layout_item_cardview, parent, false);

        return new Holder(v);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvPosterpath;
        CardView mCardView;

        public Holder(View v) {
            super(v);
            mCardView = (CardView) v.findViewById(R.id.id_cardview);
            tvTitle = (TextView) v.findViewById(R.id.id_tv_title);
            tvPosterpath = (TextView) v.findViewById(R.id.id_tv_poster_path);

        }


    }
}
