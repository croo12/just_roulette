package com.dododo.just_roulette.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dododo.just_roulette.R;
import com.dododo.just_roulette.sub_event.Dice_action;

public class Fragment_main3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_main3, container, false
        );

        Button button = (Button) getView().findViewById(R.id.dice_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dice_action dice = new Dice_action();
                TextView diceText = (TextView) getView().findViewById(R.id.dice_number_text);
                diceText.setText(dice.roll_dice(1));
            }
        });

        return rootView;
    }
}
