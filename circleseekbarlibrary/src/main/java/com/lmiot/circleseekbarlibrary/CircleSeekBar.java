package com.lmiot.circleseekbarlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建日期：2017-09-19 11:50
 * 作者:Mr Li
 * 描述:
 */
public class CircleSeekBar extends View {

    private int mRadioWith1;
    private int mRadioWith2;
    private int mPadding;
    private int mProgress;
    private int mMax;
    private int mRadioColor1;
    private int mRadioColor2;
    private Paint mPaint1;
    private Paint mPaint2;

    public void setAngle(int angle) {
        mAngle = angle;
        invalidate();
    }

    private int mAngle=90;

    public CircleSeekBar(Context context) {
        super(context);
    }

    public CircleSeekBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleSeekBar, 0, 0);
        mRadioWith1 = typedArray.getInteger(R.styleable.CircleSeekBar_radioWith1, 5);
        mRadioWith2 = typedArray.getInteger(R.styleable.CircleSeekBar_radioWith2, 20);
        mPadding = typedArray.getInteger(R.styleable.CircleSeekBar_padding, 0);
        mProgress = typedArray.getInteger(R.styleable.CircleSeekBar_progress, 0);
        mMax = typedArray.getInteger(R.styleable.CircleSeekBar_max, 100);
        mRadioColor1 = typedArray.getColor(R.styleable.CircleSeekBar_radioColor1, Color.WHITE);
        mRadioColor2 = typedArray.getColor(R.styleable.CircleSeekBar_radioColor2, Color.RED);

        mPaint1 = new Paint();
        mPaint1.setStyle(Paint.Style.STROKE);  /*画笔为线条线条*/
        mPaint1.setStrokeWidth(mRadioWith1);     /*线条的宽*/
        mPaint1.setAntiAlias(true);               /*抗锯齿*/
        mPaint1.setStrokeCap(Paint.Cap.ROUND);/*是否圆角*/
        mPaint1.setColor(mRadioColor1);


        mPaint2 = new Paint();
        mPaint2.setStyle(Paint.Style.STROKE);  /*画笔为线条线条*/
        mPaint2.setStrokeWidth(mRadioWith2);     /*线条的宽*/
        mPaint2.setAntiAlias(true);               /*抗锯齿*/
        mPaint2.setStrokeCap(Paint.Cap.ROUND);/*是否圆角*/
        mPaint2.setColor(mRadioColor2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



            /*得到view的宽高*/
        int width = getWidth();
        int height = getHeight();
        RectF rectF = null;

        if(width<=height){
            canvas.drawCircle(width/2,height/2,((width-mRadioWith2)/2)-mPadding,mPaint1);
            rectF = new RectF((mRadioWith2 / 2)+mPadding,mRadioWith2/2+(height/2)-(width/2)+mPadding,((((width-mRadioWith2)/2)-mPadding)*2)+(mRadioWith2 / 2)+mPadding,mRadioWith2/2+(height/2)-(width/2)+mPadding+((((width-mRadioWith2)/2)-mPadding)*2));

        }
        else{
            canvas.drawCircle(width/2,height/2,((height-mRadioWith2)/2)-mPadding,mPaint1);
            rectF = new RectF(mRadioWith2/2+(width/2)-(height/2)+mPadding,(mRadioWith2 / 2)+mPadding,mRadioWith2/2+(width/2)-(height/2)+mPadding+((((height-mRadioWith2)/2)-mPadding)*2),((((height-mRadioWith2)/2)-mPadding)*2)+(mRadioWith2 / 2)+mPadding);


        }




        canvas.drawArc(rectF, -90, mAngle, false, mPaint2);

    }
}
