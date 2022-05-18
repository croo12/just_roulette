package com.dododo.just_roulette.sub_event;

import android.os.Handler;
import android.widget.TextView;

public class Text_out {

    Handler handler = new Handler();
    int a = 0;
    String total_text  = "";

    // letter를 한글자씩 쪼개서 textView에 set해줌. 
    // 두두두두 나옴
    public void outByOneLetter(String letter, TextView view){

            String[] letter_arr = letter.split("");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (a < letter_arr.length) {
                        total_text += letter_arr[a];
                        view.setText(total_text);
                        a++;
                        handler.postDelayed(this, 100);
                    }
                }
            }, 10);

    }
}
