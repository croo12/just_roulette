package com.dododo.just_roulette.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {

    public int mCount;

    public MyAdapter(FragmentActivity fa, int count){
        super(fa);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        switch (index) {
            case 0:
                return new Fragment_main1();
            case 1:
                return new Fragment_main2();
            case 2:
                return new Fragment_main3();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public int getRealPosition(int position){
        return position % mCount;
    }
}
