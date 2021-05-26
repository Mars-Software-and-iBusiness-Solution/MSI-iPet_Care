package com.mars.itech.msi_ipetcare.Adapter_Class;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.mars.itech.msi_ipetcare.shop_fragments.Equipment;
import com.mars.itech.msi_ipetcare.shop_fragments.Sportswear;
import com.mars.itech.msi_ipetcare.shop_fragments.Supplement;

import java.util.ArrayList;

public class Tab_Adapter extends FragmentStateAdapter {

    public Tab_Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        switch (position) {

            case 0:
                return new Supplement();
            case 1:
                return new Sportswear();
            default:
                return new Equipment();


        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
