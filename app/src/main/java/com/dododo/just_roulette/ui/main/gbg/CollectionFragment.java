package com.dododo.just_roulette.ui.main.gbg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.dododo.just_roulette.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CollectionFragment extends Fragment {
    CollectionAdapter collectionAdapter;
    ViewPager2 viewPager;

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TabLayout tabLayout = view.findViewById(R.id.view_pager);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("OBJECT" + (position + 1))
        ).attach();
    }
        /*collectionAdapter = new CollectionAdapter(this);
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(collectionAdapter);*/
}
