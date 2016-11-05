package zyh.example.com.viewdraghelper;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by zyh on 10/31/16.
 */
public class VDLayout extends LinearLayout {
    private ViewDragHelper mViewDragHelper;
    public VDLayout(Context context) {
        this(context,null);
    }

    public VDLayout(Context context, AttributeSet attrs) {
      super(context, attrs);
        mViewDragHelper=ViewDragHelper.create(this,1.0f,new ViewDragHelper.Callback(){
                    @Override
                    public boolean tryCaptureView(View child, int pointerId)
                    {
                        return true;
                    }

                    public int clampViewPositionHorizontal(View  child,int left,int dx)
                    {
                        return left;
                    }
                    public  int clampViewPositionVertical(View child,int top,int dy)
                    {
                        return top;
                    }
                }



        );
    }
              public  boolean onInterceptTouchEvent(MotionEvent event)
              {
                  return  mViewDragHelper.shouldInterceptTouchEvent(event);

              }
              public  boolean onTouchEvent(MotionEvent event)
              {
                  mViewDragHelper.processTouchEvent(event);
                  return  true;
              }

}
