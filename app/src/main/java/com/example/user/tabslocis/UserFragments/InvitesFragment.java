package com.example.user.tabslocis.UserFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.user.tabslocis.Adapters.InvitesAdapter;
import com.example.user.tabslocis.Items.ItemInvite;
import com.example.user.tabslocis.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 18.04.2017.
 */

public class InvitesFragment extends Fragment {
    ListView listView;
    ArrayList<ItemInvite> invitesList;
    String token;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.invites_tab, container, false);
        listView = (ListView) rootView.findViewById(R.id.lv_invites);
        initListView(invitesList);
        return rootView;
    }
    private void initListView(List<ItemInvite> invites){


        invitesList = new ArrayList<>();
        //invitesList.addAll(invites);
        invitesList.add(new ItemInvite("Dima","Party",12));
        invitesList.add(new ItemInvite("Dima","Party",12));
        invitesList.add(new ItemInvite("Dima","Party",12));
        invitesList.add(new ItemInvite("Dima","Party",12));
        invitesList.add(new ItemInvite("Dima","Party",12));
        invitesList.add(new ItemInvite("Dima","Party",12));
        invitesList.add(new ItemInvite("Dima","Party",12));

        InvitesAdapter invitesAdapter = new InvitesAdapter(getActivity(),0,invitesList,token);
        listView.setAdapter(invitesAdapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }

    public void onJSONParsed(List<ItemInvite> invites) {

    }
}
