package com.example.user.tabslocis.UserFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.support.annotation.RequiresApi;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.tabslocis.Adapters.RoomsAdapter;
import com.example.user.tabslocis.Api.RoomsViewTask;
import com.example.user.tabslocis.CreateRoom;
import com.example.user.tabslocis.Items.ItemRoom;
import com.example.user.tabslocis.R;
import com.example.user.tabslocis.RoomActivity;
import com.example.user.tabslocis.UserActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.04.2017.
 */

public class RoomsFragment extends Fragment {
    String token;
    Button createRoomButton;
    Button invitesButton;
    ArrayList<ItemRoom> roomsList;
    ArrayAdapter adapter;
    ListView listView;
    EditText createRoomET;
    public String response;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        token = getArguments().getString("token");
       final RoomsViewTask api = new RoomsViewTask(token);
        api.execute(this);
      // new RoomsViewTask(token).execute();

        View rootView = inflater.inflate(R.layout.rooms_tab, container, false);
        listView = (ListView) rootView.findViewById(R.id.lv_rooms);
//        initListView(roomsList);


        return rootView;
    }

    private void initListView(final List<ItemRoom> rooms) {
        roomsList = new ArrayList<>();
        roomsList.addAll(rooms);
        roomsList.add(new ItemRoom("Room huy"));
        roomsList.add(new ItemRoom("Room xyu"));
        roomsList.add(new ItemRoom("Room hui"));
        roomsList.add(new ItemRoom("Room хуй"));
        roomsList.add(new ItemRoom("Room huй"));


        RoomsAdapter roomsAdapter = new RoomsAdapter(getActivity(), 0, roomsList, token);
        listView.setAdapter(roomsAdapter);
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

                Intent createRoomIntent = new Intent(getActivity(),RoomActivity.class);
                String roomName = roomsList.get(position).name.toString();
                createRoomIntent.putExtra("RoomName",roomName);
                startActivity(createRoomIntent);
            }
        });

    }

    public void onJSONParsed(List<ItemRoom> rooms) {
        initListView(rooms);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_mi:
                // Not implemented here
                return true;

            default:
                break;
        }
        return false;
    }


}
