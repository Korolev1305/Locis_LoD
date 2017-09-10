package com.example.user.tabslocis.Api;

import android.os.AsyncTask;
import android.support.test.espresso.core.deps.guava.io.CharStreams;
import android.view.View;
import android.widget.ListView;


import com.example.user.tabslocis.Items.ItemRoom;
import com.example.user.tabslocis.UserFragments.RoomsFragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 10.04.2017.
 */

public class RoomsViewTask extends AsyncTask {
    RoomsFragment fragment;
    String token;
    ListView listView;
    List<ItemRoom> rooms;

    public RoomsViewTask(String token){
        this.token = token;

    }


    protected Object doInBackground(Object[] params) {
        fragment = (RoomsFragment)params[0];
        try {
            URL url = new URL("http://locis.lod-misis.ru/user/rooms");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestProperty("Authorization","Basic "+ token);
            connection.connect();
            String response = CharStreams.toString(new InputStreamReader(connection.getInputStream()));
            connection.disconnect();
            rooms= new ArrayList<>();
            JSONArray jArray = new JSONArray(response);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject object = jArray.getJSONObject(i);
                String roomName = object.getString("RoomName");
                rooms.add(new ItemRoom(roomName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        if (rooms!=null)
            fragment.onJSONParsed(rooms);
        else fragment.onJSONParsed(rooms=new ArrayList<ItemRoom>());
    }

}
