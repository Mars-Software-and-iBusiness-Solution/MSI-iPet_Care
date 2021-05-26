package com.mars.itech.msi_ipetcare.Home_Directory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.mars.itech.msi_ipetcare.MainActivity;
import com.mars.itech.msi_ipetcare.R;
import com.mars.itech.msi_ipetcare.home_fragment.Pet_Diet_Plan;
import com.mars.itech.msi_ipetcare.home_fragment.Track_My_Pet;
import com.mars.itech.msi_ipetcare.home_fragment.Edit_Owner_Details;
import com.mars.itech.msi_ipetcare.home_fragment.Edit_Pet_Details;
import com.mars.itech.msi_ipetcare.home_fragment.Settings;
import com.mars.itech.msi_ipetcare.home_fragment.Share_Experience;
import com.mars.itech.msi_ipetcare.home_fragment.My_Pet_Doc;

public class Home_iFit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_i_pet);



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        NavigationView navigationView = findViewById(R.id.sidenavigation);

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
                        startActivity(new Intent(getApplicationContext(),Favorite_iFit.class));
                        finish();

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_shops:
                        startActivity(new Intent(getApplicationContext(),Shops_iFit.class));
                        finish();

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_home:


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
                Intent editpro = new Intent(Home_iFit.this, Edit_Owner_Details.class);
                startActivity(editpro);
                finish();
            }
            else if(id == R.id.trackmyprogress)
            {

                Intent trackpro = new Intent(Home_iFit.this, My_Pet_Doc.class );
                startActivity(trackpro);
                finish();
            }
            else if(id == R.id.basic_workouts)
            {

                Intent basicwork = new Intent(Home_iFit.this, Track_My_Pet.class);
                startActivity(basicwork);
                finish();
            }
            else if(id == R.id.findmeaworkout)
            {

                Intent findtrain = new Intent(Home_iFit.this, Pet_Diet_Plan.class);
                startActivity(findtrain);
                finish();
            }
            else if(id == R.id.consultacoach)
            {

                Intent mytrain = new Intent(Home_iFit.this, Edit_Pet_Details.class);
                startActivity(mytrain);
                finish();
            }else if(id == R.id.search_user)
            {

                Intent shareex = new Intent(Home_iFit.this, Share_Experience.class);
                startActivity(shareex);
                finish();
            }
            else if(id == R.id.settings)
            {

                Intent settings = new Intent(Home_iFit.this, Settings.class);
                startActivity(settings);
                finish();
            }
            else if(id == R.id.logout)
            {

                Toast.makeText(Home_iFit.this, "You Have been Sign-out successfully!", Toast.LENGTH_SHORT).show();
                finish();
                FirebaseAuth.getInstance().signOut();
                Intent loginIntent = new Intent(Home_iFit.this, MainActivity.class );
                startActivity(loginIntent);


            }


            return true;

        }
        });

    }


    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Toast.makeText(Home_iFit.this,"There is no Back Action , Please LogOut",Toast.LENGTH_SHORT).show();
        return;
    }



}