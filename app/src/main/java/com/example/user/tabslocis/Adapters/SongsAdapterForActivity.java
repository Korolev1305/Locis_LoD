package com.example.user.tabslocis.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.tabslocis.Items.ItemRoom;
import com.example.user.tabslocis.Items.ItemSong;
import com.example.user.tabslocis.R;
import com.example.user.tabslocis.RoomActivity;

import java.util.List;

/**
 * Created by User on 17.05.2017.
 */

public class SongsAdapterForActivity extends ArrayAdapter {
    RoomActivity activity;
    int resource;
    List<ItemSong> songInList;
    String token;

    public SongsAdapterForActivity(Context context, int resource, List<ItemSong> objects, String token){
        super(context, resource, objects);
        this.activity = (RoomActivity) context;
        this.resource = resource;
        this.token = token;
        songInList = objects;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        SongsAdapterForActivity.ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_song, null);
            viewHolder = new ViewHolder();
            viewHolder.nameTVauthor = (TextView) convertView.findViewById(R.id.author_name_tv);
            viewHolder.nameTVsong = (TextView) convertView.findViewById(R.id.song_name_tv);
            viewHolder.durationTV = (TextView) convertView.findViewById(R.id.durability_tv);


            ItemSong selectedItem = songInList.get(position);
            viewHolder.nameTVauthor.setText(selectedItem.authorName);
            viewHolder.nameTVsong.setText(selectedItem.songName);
            viewHolder.durationTV.setText(selectedItem.durability);

        }
        return convertView;

    }
    class ViewHolder{
        TextView nameTVsong;
        TextView nameTVauthor;
        TextView durationTV;



    }

}
