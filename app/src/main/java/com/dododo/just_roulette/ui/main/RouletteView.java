package com.dododo.just_roulette.ui.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.core.content.ContextCompat;

public class RouletteView extends View {
    Paint paint = new Paint();
    int color;
    public RouletteView(Context context){
        super(context);
        color = ContextCompat.getColor(context, com.google.android.material.R.color.design_default_color_primary);
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        paint.setColor(color);
        canvas.drawCircle(100,200,60,paint);
    }
}
