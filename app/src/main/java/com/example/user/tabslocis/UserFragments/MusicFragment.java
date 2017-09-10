package com.example.user.tabslocis.UserFragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.tabslocis.Adapters.RoomsAdapter;
import com.example.user.tabslocis.Adapters.SongsAdapter;
import com.example.user.tabslocis.Items.ItemRoom;
import com.example.user.tabslocis.Items.ItemSong;
import com.example.user.tabslocis.R;
import com.example.user.tabslocis.RoomActivity;

import java.util.ArrayList;
import java.util.List;

public class MusicFragment extends Fragment {
    ListView listView;
    ArrayList<ItemSong> songsList;
    String token;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.music_tab, container, false);
        listView = (ListView) rootView.findViewById(R.id.lv_music);
        initListView(songsList);
        return rootView;
    }
    private void initListView(final List<ItemSong> songs) {
        songsList = new ArrayList<>();
        // roomsList.addAll(rooms);
        songsList.add(new ItemSong("Egor Kreed","Ya reper","3:18"));
        songsList.add(new ItemSong("Egor Kreed","Ya reper","3:18"));
        songsList.add(new ItemSong("Egor Kreed","Ya reper","3:18"));
        songsList.add(new ItemSong("Egor Kreed","Ya reper","3:18"));
        songsList.add(new ItemSong("Egor Kreed","Ya reper","3:18"));



        SongsAdapter songsAdapter = new SongsAdapter(getActivity(), 0, songsList, token);
        listView.setAdapter(songsAdapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


            }
        });

    }
}
