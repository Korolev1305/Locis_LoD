package com.example.user.tabslocis;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.tabslocis.UserFragments.InvitesFragment;
import com.example.user.tabslocis.UserFragments.MusicFragment;
import com.example.user.tabslocis.UserFragments.RoomsFragment;

public class UserActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_user);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);







    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (id){
            case R.id.add_mi:

                AlertDialog.Builder builder = new AlertDialog.Builder(UserActivity.this);
                builder.setTitle("Создать комнату")
                        .setCancelable(false)
                        .setNegativeButton("Создать",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                         Intent createRoomIntent = new Intent(UserActivity.this,CreateRoom.class);
                                        startActivity(createRoomIntent);
                                        dialog.cancel();
                                    }});
                final EditText titleBox = new EditText(mViewPager.getContext());
                titleBox.setHint("Введите название");
                builder.setView(titleBox);
                AlertDialog alert = builder.create();
                alert.show();
                break;
            case R.id.profile_mi:
                Toast.makeText(UserActivity.this, "Profile", Toast.LENGTH_LONG).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    MusicFragment music_tab = new MusicFragment();
                    return music_tab;
                case 1:
                    RoomsFragment rooms_tab = new RoomsFragment();
                    rooms_tab.setArguments(getIntent().getExtras());
                    //getSupportFragmentManager().beginTransaction().add(
                    //        android.R.id.content, rooms_tab).commit();
                    return rooms_tab;
                case 2:
                    InvitesFragment invites_tab = new InvitesFragment();
                    return invites_tab;
                default:
                    return null;
            }}

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Music";

                case 1:
                    return "Rooms";
                case 2:
                    return "Invites";
                default:
                    return null;
            }
        }
    }

}
