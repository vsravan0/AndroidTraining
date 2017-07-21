package com.edu.sra.trainings.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sravan on 21/07/17.
 */

public class Parser {

    public static final String TAG = "Parser";

    // Parse String to Json Object -> EntityMovie

    public ArrayList<EntitiyMovie> pasreData(String result) {
        ArrayList<EntitiyMovie> list = new ArrayList<EntitiyMovie>();
        try {
            JSONObject object = new JSONObject(result);
            int page = object.getInt("page");
            int tolaResults = object.getInt("total_results");
            int totalPages = object.getInt("total_pages");
            JSONArray array = object.getJSONArray("results");

            for (int i = 0; i < array.length(); i++) {

                JSONObject obj = array.getJSONObject(i);
                int vote_count = obj.getInt("vote_count");
                int id = obj.getInt("id");
                boolean video = obj.getBoolean("video");
                double vote_average = obj.getDouble("vote_average");
                String title = obj.getString("title");
                String poster_path = obj.getString("poster_path");
                EntitiyMovie entity = new EntitiyMovie();
                entity.setId(id);
                entity.setPoster_path(poster_path);
                entity.setTitle(title);
                entity.setVideo(video);
                entity.setVote_average(vote_average);
                entity.setVote_count(vote_count);
                list.add(entity);

            }

        } catch (JSONException e) {
            Log.e(TAG, " pasreData :" + e);
        }
        Log.v(TAG, " Parsed Data Length is :" + list.size());

        return list;
    }
}
