package com.example.user.tabslocis.Api;

import android.os.AsyncTask;
import android.support.test.espresso.core.deps.guava.io.CharStreams;

import com.example.user.tabslocis.Items.ItemSong;
import com.example.user.tabslocis.UserActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ewigkeit on 05.10.2017.
 */

public class SearchSongsTask extends AsyncTask {
    UserActivity activity;
    String token;
    String searchString;
    List<ItemSong> songs;
    String guid;

    public SearchSongsTask(String token, String searchString) {
        this.token = token;
        this.searchString = searchString;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        activity = (UserActivity) params[0];
        try {
            String connectionLink = "http://locis.lod-misis.ru/songs/"+searchString;
            URL url = new URL(connectionLink.replaceAll(" ","%20"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestProperty("Authorization","Basic "+ token);
            connection.connect();
            String response = CharStreams.toString(new InputStreamReader(connection.getInputStream()));
            connection.disconnect();
            System.out.println(response);
            songs= new ArrayList<>();
            JSONObject jsonObject = new JSONObject(response);
            guid = jsonObject.getString("Guid");
            JSONArray jArray = jsonObject.getJSONArray("Result");
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject object = jArray.getJSONObject(i);
                String title = object.getString("Title");
                String duration = object.getString("Length");
                String link = object.getString("SongUri");
                int songId = object.getInt("SongId");

                songs.add(new ItemSong(songId,link,title,duration));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        //if (songs!=null)
        //activity.onJSONParsed(songs);
        //else activity.onJSONParsed(songs=new ArrayList<SongInList>());
    }
}
