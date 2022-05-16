package com.dododo.just_roulette.sub_event;

import androidx.annotation.Nullable;

import java.util.Random;

public class Dice_action {

    public Dice_action(){}

    public int roll_dice(int dice_number){
        Random random = new Random();
        return random.nextInt(6*dice_number)+1;
    }
}
