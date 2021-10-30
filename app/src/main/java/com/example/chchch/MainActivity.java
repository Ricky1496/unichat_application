package com.example.chchch;




import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bottom Navigation intent
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavView);
        //set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.home);
        //Perform ItemSelectedListner





        MaterialToolbar toolbar=findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout =findViewById(R.id.drawer_Layout);
        NavigationView navigationView=findViewById(R.id.navigation_View);
        navigationView.setItemIconTintList(null);

        bottomNavigationView.setOnItemSelectedListener(navListener);





        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer((GravityCompat.START));

                switch (id) {

                    case R.id.menuProfile:
                        replaceFragment(new ProfileFragment());
                        break;

                    case R.id.menuCollection:
                        replaceFragment(new CollectFragment());
                        break;

                    case R.id.menuNotifications:
                        replaceFragment(new NotificationFragment());
                        break;

                    case R.id.menuSettings:
                        replaceFragment(new SettingsFragment());
                        break;

                    case R.id.menuAboutUS:
                        Toast.makeText(MainActivity.this, "About US", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.menuSupport:
                        Toast.makeText(MainActivity.this, "Support", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        return true;
                }

                return true;
            }
        });




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

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();


    }

}




