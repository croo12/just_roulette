package com.dododo.just_roulette;

import android.os.Bundle;

import com.dododo.just_roulette.ui.main.CollectionAdapter;
import com.dododo.just_roulette.ui.main.MyAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dododo.just_roulette.ui.main.SectionsPagerAdapter;
import com.dododo.just_roulette.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private FragmentStateAdapter pagerAdapter;
    private int page_number = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //슬라이드뷰

        viewPager2 = findViewById(R.id.view_pager);

        pagerAdapter = new MyAdapter(this,page_number);
        viewPager2.setAdapter(pagerAdapter);

        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewPager2.setCurrentItem(1000);
        viewPager2.setOffscreenPageLimit(3);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if(positionOffsetPixels == 0 ){
                    viewPager2.setCurrentItem(position);
                }
            }
        });
    }
}