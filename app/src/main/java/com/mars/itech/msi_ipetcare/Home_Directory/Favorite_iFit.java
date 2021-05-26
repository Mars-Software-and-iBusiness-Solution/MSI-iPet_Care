package com.mars.itech.msi_ipetcare.Home_Directory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mars.itech.msi_ipetcare.R;

public class Favorite_iFit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_i_pet);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_favorites);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(),Map_iFit.class));
                        finish();

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_news:
                        startActivity(new Intent(getApplicationContext(),Feed_iFit.class));
                        finish();

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_favorites:


                        return true;

                    case R.id.nav_shops:
                        startActivity(new Intent(getApplicationContext(),Shops_iFit.class));
                        finish();

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),Home_iFit.class));
                        finish();

                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Toast.makeText(Favorite_iFit.this,"There is no Back Action , Please LogOut",Toast.LENGTH_SHORT).show();
        return;
    }
}