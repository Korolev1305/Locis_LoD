package com.example.user.tabslocis.Adapters;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 28.03.2017.
 */

public class RoomsAdapter extends ArrayAdapter{
    FragmentActivity friendsActivity;
    int resource;
    List<ItemRoom> roomsInList;
    String token;

    public RoomsAdapter(Context context, int resource, List<ItemRoom> objects, String token){
        super(context, resource, objects);
        this.friendsActivity = (FragmentActivity) context;
        this.resource = resource;
        this.token = token;
        roomsInList = objects;
    }



    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = friendsActivity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_room, null);
            viewHolder = new ViewHolder();

            viewHolder.nameTVUserRoom = (TextView) convertView.findViewById(R.id.tv_room_name);
            ItemRoom selectedRoom = roomsInList.get(position);
            viewHolder.nameTVUserRoom.setText(selectedRoom.name);
        }
        return convertView;

    }
    class ViewHolder{
       TextView nameTVUserRoom;

    }

}
