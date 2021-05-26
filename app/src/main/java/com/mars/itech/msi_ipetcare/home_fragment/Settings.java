package com.mars.itech.msi_ipetcare.home_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.mars.itech.msi_ipetcare.Home_Directory.Home_iFit;
import com.mars.itech.msi_ipetcare.MainActivity;
import com.mars.itech.msi_ipetcare.R;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        NavigationView navigationView = findViewById(R.id.sidenavigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {

                int id = item.getItemId();

                if (id == R.id.editprofile)
                {
                    Intent editpro = new Intent(Settings.this, Edit_Owner_Details.class);
                    startActivity(editpro);
                    finish();
                }
                else if(id == R.id.trackmyprogress)
                {

                    Intent trackpro = new Intent(Settings.this, My_Pet_Doc.class );
                    startActivity(trackpro);
                    finish();
                }
                else if(id == R.id.basic_workouts)
                {

                    Intent basicwork = new Intent(Settings.this, Track_My_Pet.class);
                    startActivity(basicwork);
                    finish();
                }
                else if(id == R.id.findmeaworkout)
                {

                    Intent findtrain = new Intent(Settings.this, Pet_Diet_Plan.class);
                    startActivity(findtrain);
                    finish();
                }
                else if(id == R.id.consultacoach)
                {

                    Intent mytrain = new Intent(Settings.this, Edit_Pet_Details.class);
                    startActivity(mytrain);
                    finish();
                }else if(id == R.id.search_user)
                {

                    Intent shareex = new Intent(Settings.this, com.mars.itech.msi_ipetcare.home_fragment.Share_Experience.class);
                    startActivity(shareex);
                    finish();
                }
                else if(id == R.id.settings)
                {

                    Intent settings = new Intent(Settings.this, Settings.class);
                    startActivity(settings);
                    finish();
                }
                else if(id == R.id.logout)
                {

                    Toast.makeText(Settings.this, "You Have been Sign-out successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                    FirebaseAuth.getInstance().signOut();
                    Intent loginIntent = new Intent(Settings.this, MainActivity.class );
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

        Intent registerIntent = new Intent(Settings.this, Home_iFit.class);
        startActivity(registerIntent);
        finish();

    }
}