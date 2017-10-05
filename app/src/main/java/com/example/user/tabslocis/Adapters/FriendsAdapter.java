package com.example.user.tabslocis.Adapters;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.tabslocis.Api.SendInvitationTask;
import com.example.user.tabslocis.Items.ItemFriend;
import com.example.user.tabslocis.R;
import com.example.user.tabslocis.UserFragments.FriendsFragment;

import java.util.List;

/**
 * Created by ewigkeit on 05.10.2017.
 */

public class FriendsAdapter extends ArrayAdapter {
    FragmentActivity friendsFragment;
    int resource;
    List<ItemFriend> itemFriend;
    String token;
    Context context;
    int roomId;

    public FriendsAdapter(Context context, int resource, List<ItemFriend> objects,String token,int roomId){
        super(context, resource, objects);
        this.friendsFragment = (FragmentActivity) context;
        this.resource = resource;
        itemFriend= objects;
        this.token=token;
        this.roomId=roomId;
    }

    public View getView(final int position, View convertView, final ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater inflater = friendsFragment.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_friend, null);
            viewHolder = new ViewHolder();

            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.tv_friend_name);
            ItemFriend selectedFriend = itemFriend.get(position);
            viewHolder.nameTextView.setText(selectedFriend.name);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Button addToRomButton = (Button)  convertView  .findViewById(R.id.button_add_to_room);

        addToRomButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ItemFriend selectedFriend = itemFriend.get(position);
                int userId = selectedFriend.userId;
                final SendInvitationTask api = new SendInvitationTask(userId,roomId,token);
                api.execute(context);
                addToRomButton.setText("Добавлен");
                addToRomButton.setBackgroundColor(0);
                addToRomButton.setClickable(false);

            }

        });

        return convertView;

    }
    class ViewHolder{
        TextView nameTextView;


    }

}
