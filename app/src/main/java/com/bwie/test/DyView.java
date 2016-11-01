package com.bwie.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lenovo-pc on 2016/11/1.
 */
public class DyView extends View{

    private int sweepAngle;
    private int startAngle;
    private String text;
    private float textSize;
    private int mCircleXY;
    private float mRadius;
    private Paint mCirclePaint;
    private RectF mRectF;
    private Paint mArcPaint;
    private Paint mTextPaint;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSth(canvas);
    }

    private void drawSth(Canvas canvas) {
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mRectF, startAngle, sweepAngle, false, mArcPaint);
        canvas.drawText("林志玲姐姐",  mCircleXY, mCircleXY + textSize
                / 4, mTextPaint);
    }

    public DyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DyView(Context context) {
        super(context);
    }

    public DyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray tt=context.obtainStyledAttributes(attrs,R.styleable.circleView);
        if(tt!=null){
            textSize = tt.getDimension(R.styleable.circleView_textSize, 50);
            text = tt.getString(R.styleable.circleView_text);
            startAngle = tt.getInt(R.styleable.circleView_startAngle, 0);
            sweepAngle = tt.getInt(R.styleable.circleView_sweepAngle, 90);
            tt.recycle();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        init(w,h);
    }

    private void init(int width, int height) {
        int length = Math.min(width, height);
        mCircleXY = length / 2;
        mRadius = length * 0.5f / 2;
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(Color.RED);
        mRectF = new RectF(length * 0.1f, length * 0.1f, length * 0.9f,
                length * 0.9f);

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setColor(Color.GREEN);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth((width * 0.1f));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }


}
