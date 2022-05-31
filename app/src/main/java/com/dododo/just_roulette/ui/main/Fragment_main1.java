package com.dododo.just_roulette.ui.main;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dododo.just_roulette.R;

public class Fragment_main1 extends Fragment {

    RouletteView rouletteView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_main1, container, false
        );

        LinearLayout frame_layout =
                (LinearLayout) rootView.findViewById(R.id.rouletteLayout);

        rouletteView = new RouletteView(getActivity().getApplicationContext());

        frame_layout.addView(rouletteView);

        return rootView;
    }


}
