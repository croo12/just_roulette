package com.dododo.just_roulette.sub_event;

import androidx.annotation.Nullable;

import java.util.Random;

public class Dice_action {

    public Dice_action(){}

    public int roll_dice(int dice_number){
        Random random = new Random();
        int result = 0;
        for(int i=0; i<dice_number; i++){
            result += random.nextInt(6)+1;
        }
        return result;
    }
}
