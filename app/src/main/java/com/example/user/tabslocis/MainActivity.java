package com.example.user.tabslocis;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button loginButton;
    Button registrationButton;
    MenuItem addMenuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onResume() {
        super.onResume();
        bindViews();
    }

    private void bindViews(){
        loginButton = (Button) findViewById(R.id.login_button_ma);



        registrationButton = (Button) findViewById(R.id.registration_button_ma);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getWindow().getContext(),LoginActivity.class);
                startActivity(loginIntent);
            }
        });
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrationIntent = new Intent(getWindow().getContext(),RegistrationActivity.class);
                startActivity(registrationIntent);
            }
        });
    }

}
