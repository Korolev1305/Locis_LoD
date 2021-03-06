package com.example.user.tabslocis.Api;

import android.os.AsyncTask;
import android.support.test.espresso.core.deps.guava.io.CharStreams;
import android.util.Log;

import com.example.user.tabslocis.Items.ItemInvite;
import com.example.user.tabslocis.UserFragments.InvitesFragment;

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

public class InvitationViewTask extends AsyncTask {
    InvitesFragment fragment;
    String token;
    List<ItemInvite> invites;
    public InvitationViewTask(String token){
        this.token = token;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        fragment = (InvitesFragment) params[0];
        try {

            URL url = new URL("http://locis.lod-misis.ru/user/invitations/unchecked");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestProperty("Authorization","Basic "+ token);
            connection.connect();
            String response = CharStreams.toString(new InputStreamReader(connection.getInputStream()));
            connection.disconnect();
            invites = new ArrayList<>();
            JSONArray jArray = new JSONArray(response);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject object = jArray.getJSONObject(i);
                String roomName = object.getString("RoomName");
                Log.d("Kek",roomName);
                String senderId = object.getString("TargetId");
                int invitationId = object.getInt("InvitationId");
                invites.add(new ItemInvite(senderId, roomName, invitationId));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if (invites!=null)
            fragment.onJSONParsed(invites);
        else fragment.onJSONParsed(invites=new ArrayList<ItemInvite>());
    }
}
