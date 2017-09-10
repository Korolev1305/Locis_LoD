package com.example.user.tabslocis;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.tabslocis.Adapters.SongsAdapter;
import com.example.user.tabslocis.Adapters.SongsAdapterForActivity;
import com.example.user.tabslocis.Items.ItemSong;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    ListView listView;
    ArrayList<ItemSong> songsList;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        mViewPager = (ViewPager) findViewById(R.id.container);
        Intent intent = getIntent();
        String roomName = intent.getStringExtra("RoomName");
    setTitle(roomName);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        initListView(songsList);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.add_mi:
                Toast.makeText(RoomActivity.this, "Add Track", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initListView(List<ItemSong> songs) {
        songsList = new ArrayList<>();
        // roomsList.addAll(rooms);
        songsList.add(new ItemSong("Egor Kreed","Ya reper","3:18"));
        songsList.add(new ItemSong("Egor Kreed","Ya reper","3:18"));
        songsList.add(new ItemSong("Egor Kreed","Ya reper","3:18"));
        songsList.add(new ItemSong("Egor Kreed","Ya reper","3:18"));
        songsList.add(new ItemSong("Egor Kreed","Ya reper","3:18"));



        SongsAdapterForActivity songsAdapter = new SongsAdapterForActivity(this, 0, songsList, token);
        listView = (ListView) findViewById(R.id.lv_music_in_room);
        listView.setAdapter(songsAdapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });



    }
}
