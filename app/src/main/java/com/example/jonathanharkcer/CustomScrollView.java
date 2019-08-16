package com.example.jonathanharkcer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class CustomScrollView extends ScrollView {

    public CustomScrollView(Context context){
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev){
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev){
        super.onTouchEvent(ev);
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                return true;
            case MotionEvent.ACTION_UP:
                performClick();
                return true;
        }
        return false;
    }

    @Override
    public  boolean performClick(){
        super.performClick();
        return true;
    }

}
