package com.mars.itech.msi_ipetcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mars.itech.msi_ipetcare.Home_Directory.Favorite_iFit;
import com.mars.itech.msi_ipetcare.Home_Directory.Feed_iFit;
import com.mars.itech.msi_ipetcare.Home_Directory.Home_iFit;
import com.mars.itech.msi_ipetcare.Home_Directory.Map_iFit;
import com.mars.itech.msi_ipetcare.Home_Directory.Shops_iFit;

public class User_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(), Map_iFit.class));
                        finish();

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_news:
                        startActivity(new Intent(getApplicationContext(), Feed_iFit.class));
                        finish();

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_favorites:
                        startActivity(new Intent(getApplicationContext(), Favorite_iFit.class));
                        finish();

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_shops:
                        startActivity(new Intent(getApplicationContext(), Shops_iFit.class));
                        finish();

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(), Home_iFit.class));
                        finish();
                        overridePendingTransition(0,0);

                        return true;
                }

                return false;
            }
        });


    }


}