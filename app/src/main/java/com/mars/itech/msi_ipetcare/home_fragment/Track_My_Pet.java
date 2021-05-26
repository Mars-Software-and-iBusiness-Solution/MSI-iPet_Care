package com.mars.itech.msi_ipetcare.home_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.mars.itech.msi_ipetcare.Home_Directory.Favorite_iFit;
import com.mars.itech.msi_ipetcare.Home_Directory.Feed_iFit;
import com.mars.itech.msi_ipetcare.Home_Directory.Home_iFit;
import com.mars.itech.msi_ipetcare.Home_Directory.Map_iFit;
import com.mars.itech.msi_ipetcare.Home_Directory.Shops_iFit;
import com.mars.itech.msi_ipetcare.MainActivity;
import com.mars.itech.msi_ipetcare.R;


public class Track_My_Pet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_my_pet);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        NavigationView navigationView = findViewById(R.id.sidenavigation);

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



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {

                int id = item.getItemId();

                if (id == R.id.editprofile)
                {
                    Intent editpro = new Intent(Track_My_Pet.this, Edit_Owner_Details.class);
                    startActivity(editpro);
                    finish();
                }
                else if(id == R.id.trackmyprogress)
                {

                    Intent trackpro = new Intent(Track_My_Pet.this, My_Pet_Doc.class );
                    startActivity(trackpro);
                    finish();
                }
                else if(id == R.id.basic_workouts)
                {

                    Intent basicwork = new Intent(Track_My_Pet.this, Track_My_Pet.class);
                    startActivity(basicwork);
                    finish();
                }
                else if(id == R.id.findmeaworkout)
                {

                    Intent findtrain = new Intent(Track_My_Pet.this, Pet_Diet_Plan.class);
                    startActivity(findtrain);
                    finish();
                }
                else if(id == R.id.consultacoach)
                {

                    Intent mytrain = new Intent(Track_My_Pet.this, Edit_Pet_Details.class);
                    startActivity(mytrain);
                    finish();
                }else if(id == R.id.search_user)
                {

                    Intent shareex = new Intent(Track_My_Pet.this, com.mars.itech.msi_ipetcare.home_fragment.Share_Experience.class);
                    startActivity(shareex);
                    finish();
                }
                else if(id == R.id.settings)
                {

                    Intent settings = new Intent(Track_My_Pet.this, com.mars.itech.msi_ipetcare.home_fragment.Settings.class);
                    startActivity(settings);
                    finish();
                }
                else if(id == R.id.logout)
                {

                    Toast.makeText(Track_My_Pet.this, "You Have been Sign-out successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                    FirebaseAuth.getInstance().signOut();
                    Intent loginIntent = new Intent(Track_My_Pet.this, MainActivity.class );
                    startActivity(loginIntent);


                }


                return true;

            }
        });

    }

    @Override
    public void onBackPressed() {
        // do your back button logic here
        // you can have conditions or whatever you want to do.
        // change to different fragment, go to different activity, etc.

        Intent registerIntent = new Intent(Track_My_Pet.this, Home_iFit.class);
        startActivity(registerIntent);
        finish();

    }
}