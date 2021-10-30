package com.example.chchch;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ChatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //Bottom Navigation intent
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavView);
        //set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.menuChat);
        //Perform ItemSelectedListner
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                    switch (item.getItemId()){
                        case R.id.menuChat:

                            startActivity(new Intent(getApplicationContext(),ChatActivity.class));
                            overridePendingTransition(0,0);
                            return true;
                        case R.id.home:

                            return  true;
                    }
                    return false;
                }
            };
}
