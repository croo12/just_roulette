package com.dododo.just_roulette.ui.main;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.dododo.just_roulette.R;
import com.dododo.just_roulette.sub_event.Dice_action;

public class Fragment_main3 extends Fragment
        implements View.OnClickListener {

    TextView dice_number;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_main3, container, false
        );
        Log.e(this.getClass().getName(),"여까지 잘됨");
        Button button = (Button) rootView.findViewById(R.id.dice_button);
        Button button1 = (Button) rootView.findViewById(R.id.fragment3_plus_button);
        Button button2 = (Button) rootView.findViewById(R.id.fragment3_minus_button);
        dice_number = rootView.findViewById(R.id.dice_number_view);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        button.setText("굴리기");

        ImageView imageView = rootView.findViewById(R.id.roll_dice_image);
        Glide.with(this).load(R.drawable.roll_dice).into(imageView);
        imageView.setVisibility(View.GONE);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        int now = Integer.parseInt(
                dice_number.getText().toString());
        TextView dice_image = getView().findViewById(R.id.dice_image_text_view);
        switch(view.getId()){
            case R.id.dice_button: // 굴리기 버튼 누름
                Dice_action dice = new Dice_action();
                TextView diceText = getView().findViewById(R.id.dice_image_text_view);

                //다이스 굴러가는 이미지가 나오는 부분
                ImageView imageView = getView().findViewById(R.id.roll_dice_image);
                imageView.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setVisibility(View.GONE);

                    }
                },1000); // 딜레이 1초
                diceText.setText(""+dice.roll_dice(now));
                diceText.setTextSize(40);
                break;
            case R.id.fragment3_plus_button: //plus 버튼 누름
                now += 1;
                if(now>=10) {
                    //알림 넣기
                    System.out.println("이 이상으로 하기 불가능");
                }else{
                    dice_number.setText("" + now);
                    String a = "";
                    for(int i=0; i<now; i++) {
                        a += "🎲";
                    }
                    dice_image.setText(a);
                }
                break;
            case R.id.fragment3_minus_button: // 마이너스 버튼 누름
                now -= 1;
                if(now <= 0) {
                    //알림 넣기
                    System.out.println("이 이하로 하기 불가능");
                }else {
                    dice_number.setText("" + now);
                    String a = "";
                    for(int i=0; i<now; i++) {
                        a += "🎲";
                    }
                    dice_image.setText(a);
                }
                break;
        }
    }
}
