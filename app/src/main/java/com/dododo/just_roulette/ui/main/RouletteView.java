package com.dododo.just_roulette.ui.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.dododo.just_roulette.R;

import java.util.ArrayList;
import java.util.List;

public class RouletteView extends View {
    Paint paint = new Paint();
    int color;
    int num;
    List<String> STRINGS = new ArrayList<String>();
    int mDgree = 0;

    public RouletteView(Context context){
        super(context);
        color = ContextCompat.getColor(context, com.google.android.material.R.color.design_default_color_primary);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //임시값
        STRINGS.add("안녕1");
        STRINGS.add("안녕2");
        STRINGS.add("안녕3");
        STRINGS.add("안녕4");
        STRINGS.add("안녕5");

        num = STRINGS.size();
        //

        int width = 1400;
        int height = 1400;
        int sweepAngle = 360/num;

        RectF rectF = new RectF(180,0,width,height);
        Rect rect = new Rect(180,0,width,height);

        int centerX = (rect.left + rect.right)/2;
        int centerY = (rect.top + rect.bottom)/2;
        int radius = (rect.right - rect.left)/2;

        int temp = 0;

        int[] COLORS = {Color.YELLOW,Color.BLUE,Color.GREEN,Color.MAGENTA,Color.WHITE};

        for(int i=0; i<num; i++){
            paint.setColor(COLORS[i%5]);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawArc(rectF,temp,sweepAngle,true,paint);

            float medianAngle = (temp + (sweepAngle / 2f)) * (float) Math.PI / 180f;

            paint.setColor(Color.BLACK);
            paint.setTextSize(80);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);

            float arcCenterX = (float)(centerX + (radius * Math.cos(medianAngle)));
            float arcCenterY = (float)(centerY + (radius * Math.sin(medianAngle)));

            float textX = (centerX + arcCenterX) / 2;
            float textY = (centerY + arcCenterY) / 2;

            canvas.drawText(STRINGS.get(i),textX,textY,paint);
            temp+=sweepAngle;
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public Bitmap rotateImage(Bitmap src, float degree){
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        return Bitmap.createBitmap(src, 0,0,src.getWidth(),src.getHeight(),
                matrix,true);

    }
}
