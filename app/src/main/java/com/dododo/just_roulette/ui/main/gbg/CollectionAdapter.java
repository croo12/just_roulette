package com.dododo.just_roulette.ui.main.gbg;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class CollectionAdapter extends FragmentStateAdapter {
    //생성자
    public CollectionAdapter(Fragment fragment){
        super(fragment);
    };

    @NonNull
    public Fragment createFragment(int position) {
        //position번째의 새 프래그먼트를 생성함
        Fragment fragment = new ObjectFragment();
        Bundle args = new Bundle();
        //우리 오브젝트 특) Integer임 ㅋㅋㅋ
        args.putInt(ObjectFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}



