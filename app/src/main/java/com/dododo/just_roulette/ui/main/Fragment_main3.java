package com.dododo.just_roulette.ui.main;

import android.os.Bundle;
import android.util.Log;
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

public class Fragment_main3 extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_main3, container, false
        );
        Log.e(this.getClass().getName(),"여까지 잘됨");
        Button button = (Button) rootView.findViewById(R.id.dice_button);
        button.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.dice_button:
                Dice_action dice = new Dice_action();
                TextView diceText = getView().findViewById(R.id.dice_number_text);
                diceText.setText(""+dice.roll_dice(1));
                break;
        }
    }
}
