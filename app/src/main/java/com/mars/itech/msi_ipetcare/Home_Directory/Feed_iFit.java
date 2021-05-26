package com.mars.itech.msi_ipetcare.Home_Directory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mars.itech.msi_ipetcare.Adapter_Class.Tab_Adapter_ViewPager2;
import com.mars.itech.msi_ipetcare.R;


public class Feed_iFit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_i_pet);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_news);

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
                        startActivity(new Intent(getApplicationContext(),Home_iFit.class));
                        finish();

                        overridePendingTransition(0,0);

                        return true;
                }
                return false;
            }
        });


        ViewPager2 viewPager2 = findViewById(R.id.viewpager);
        viewPager2.setAdapter(new Tab_Adapter_ViewPager2(this));

        TabLayout tabLayout = findViewById(R.id.tablayout);
        TabLayoutMediator tabLayoutMediator = new
                TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position)
            {
                switch (position) {
                    case 0:
                        {
                        tab.setText("Train Plan");
                        tab.setIcon(R.drawable.camera_icon);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(
                                getApplicationContext(),R.color.colorAccent));
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(100);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;

                    }
                    case 1:
                        {
                        tab.setText("Meal Plan");
                        tab.setIcon(R.drawable.supplement);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(
                                getApplicationContext(),R.color.colorAccent));
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    }
                    case 2:
                        {
                        tab.setText("Pet Health");
                        tab.setIcon(R.drawable.equipment);
                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(
                                getApplicationContext(),R.color.colorAccent));
                        badgeDrawable.setVisible(true);
                        badgeDrawable.setNumber(100);
                        badgeDrawable.setMaxCharacterCount(3);
                        break;
                    }
                }
            }
        }
        );
        tabLayoutMediator.attach();
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Toast.makeText(Feed_iFit.this,"There is no Back Action , Please LogOut",Toast.LENGTH_SHORT).show();
        return;
    }
}