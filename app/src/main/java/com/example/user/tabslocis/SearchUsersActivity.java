package com.example.user.tabslocis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.user.tabslocis.Adapters.FriendsAdapter;
import com.example.user.tabslocis.Api.SearchUsersTask;
import com.example.user.tabslocis.Items.ItemFriend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ewigkeit on 05.10.2017.
 */
public class SearchUsersActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ArrayList<ItemFriend> friendsList;
    ListView listViewFriends;
    String token;
    Button backButton;
    SearchView searchView;
    int roomId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);
        backButton = (Button) findViewById(R.id.create_room_button);
        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        System.out.println(token);
        roomId = intent.getIntExtra("roomId",0);
        System.out.println(roomId);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void friendsListView(List<ItemFriend> friends){
        friendsList = new ArrayList<>();
        friendsList.addAll(friends);
        FriendsAdapter friendsAdapter = new FriendsAdapter(this,0,friendsList,token,roomId);
        listViewFriends = (ListView) findViewById(R.id.create_room_friends_lv);
        listViewFriends.setAdapter(friendsAdapter);
        listViewFriends.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }



    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        System.out.println(s);
        final SearchUsersTask api = new SearchUsersTask(token, s);
        api.execute(getWindow().getContext());


        return false;
    }

    public void onJSONParsed(List<ItemFriend> friends) {
        friendsListView(friends);
    }
}
