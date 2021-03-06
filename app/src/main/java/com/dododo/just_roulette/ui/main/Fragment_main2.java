package com.dododo.just_roulette.ui.main;


import android.os.Bundle;
import android.os.Handler;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dododo.just_roulette.R;
import com.dododo.just_roulette.sub_event.Text_out;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fragment_main2 extends Fragment
        implements View.OnClickListener{

    List<String> jebi_list = new ArrayList<String>();
    EditText proto_get;
    TextView resultView;
    boolean button_action = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_main2, container, false
        );

        this.proto_get = rootView.findViewById(R.id.proto_get);
        proto_get.bringToFront();
        Button button = rootView.findViewById(R.id.plus_button);
        Button clear_button = rootView.findViewById(R.id.clear_button);
        ImageView imageView =  rootView.findViewById(R.id.jebi_view);

        button.setOnClickListener(this);
        clear_button.setOnClickListener(this);
        imageView.setOnClickListener(this);

        this.resultView = rootView.findViewById(R.id.result_view);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.plus_button:
                if(button_action) {
                    button_action = false;
                    String letter = "";
                    try {
                        String new_jebi = proto_get.getText().toString();
                        jebi_list.add(new_jebi);
                        proto_get.setText("");
                        letter = "" + jebi_list.size() + "?????? ?????? : " + new_jebi;
                        Text_out text_out = new Text_out();
                        text_out.outByOneLetter(letter, resultView);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        System.out.println("????????? ??????");
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            button_action = true;
                        }
                    },100*letter.length());
                }
                break;
            case R.id.jebi_view:
                Random random = new Random();
                if(button_action) {
                    button_action = false;
                    String letter = "";
                    if (jebi_list.size() == 0) {
                        resultView.setText("????????? ????????????");
                    } else {
                        int x = random.nextInt(jebi_list.size());
                        Text_out text_out = new Text_out();

                        letter = "?????? : " + jebi_list.get(x);
                        text_out.outByOneLetter(letter, resultView);
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            button_action = true;
                        }
                    },100*letter.length());

                }
                break;
            case R.id.clear_button:
                this.jebi_list = new ArrayList<String>();
                resultView.setText("????????? ??????");
                break;
        }
    }
}
