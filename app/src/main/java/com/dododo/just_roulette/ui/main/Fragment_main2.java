package com.dododo.just_roulette.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dododo.just_roulette.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fragment_main2 extends Fragment
        implements View.OnClickListener{

    List<String> jebi_list = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_main2, container, false
        );

        EditText editText = rootView.findViewById(R.id.proto_get);
        editText.bringToFront();
        Button button = rootView.findViewById(R.id.plus_button);
        button.setOnClickListener(this);
        ImageView imageView =  rootView.findViewById(R.id.jebi_view);
        imageView.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.plus_button:
                EditText proto_get = view.findViewById(R.id.proto_get);
                jebi_list.add(proto_get.getText().toString());
                System.out.println("추가 완료");
                break;
            case R.id.jebi_view:
                Random random = new Random();
                int x = random.nextInt(jebi_list.size())-1;
                TextView resultView = view.findViewById(R.id.jebi_view);
                resultView.setText(jebi_list.get(x));
                System.out.println("출력 완료");
        }
    }
}
