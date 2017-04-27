package com.example.xieshengqi.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xieshengqi on 15/10/26.
 */
public class FlowLayout extends ViewGroup {


    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

//记录每一行的宽度和高度
        int lineWidth = 0;
        int lineHeight = 0;

        //wrap_content
        int width = 0;
        int height = 0;


        int cCount = getChildCount();

        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            //测量子View的宽和高
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            //得到layoutparams
            MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
            //子View占据的宽度和高度
            int childWidth = child.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int childHeight = child.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;

            if (lineWidth + childWidth > modeWidth) {
                //换行,对比得到最大的宽度换行
                width = Math.max(lineWidth, width);
                lineWidth = childWidth;
//叠加行高
                height += lineHeight;
                lineHeight = childHeight;
            } else {
                //未还行,叠加行宽,得到当前最大高度
                lineWidth += childWidth;
                height = Math.max(lineHeight, childHeight);
            }
            //最后一个控件
            if (i == cCount-1) {

                width = Math.max(lineWidth, width);
                height += lineHeight;

            }

        }
        setMeasuredDimension(
                modeWidth == MeasureSpec.EXACTLY ? sizeWidth : width,
                modeHeight == MeasureSpec.EXACTLY ? sizeHeight : height
        );
//        if (modeWidth == MeasureSpec.AT_MOST) {
//            setMeasuredDimension(width,height);
//
//        }else{
//            setMeasuredDimension(sizeWidth,sizeHeight);
//        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    private List<List<View>> mAllLists = new ArrayList<List<View>>();
    private List<Integer> mLineHeight = new ArrayList<Integer>();

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        mAllLists.clear();
        mLineHeight.clear();
        //当前Viewgroup的宽度
        int width = getWidth();

        int lineWidth = 0;
        int lineHeight = 0;
        List<View> lineViews = new ArrayList<View>();
        int cCount = getChildCount();


        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            MarginLayoutParams p = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            if (childWidth + lineWidth + p.leftMargin + p.rightMargin > width) {
                //记录LineHeight
                mLineHeight.add(lineHeight);
//记录当前行所有View
                mAllLists.add(lineViews);
                //重置行宽和行高
                lineHeight = childHeight + p.topMargin + p.bottomMargin;
                lineWidth = 0;
                //重置V
                lineViews = new ArrayList<View>();


            }
            lineWidth += childWidth + p.leftMargin + p.rightMargin;
            lineHeight = Math.max(lineHeight, childHeight + p.topMargin + p.bottomMargin);
            lineViews.add(child);

        }

        //最后一行
        mLineHeight.add(lineHeight);
        mAllLists.add(lineViews);
//设置子View问题;

        int left = 0;
        int top = 0;
        int lineNUm = mAllLists.size();
        for (int i = 0; i < lineNUm; i++) {
            lineViews = mAllLists.get(i);
            lineHeight = mLineHeight.get(i);
            for (int j = 0; j < lineViews.size(); j++) {
                View view = lineViews.get(j);
                if (view.getVisibility() == View.GONE) {
                    continue;
                }
                MarginLayoutParams p = (MarginLayoutParams) view.getLayoutParams();
                int lc = left + p.leftMargin;
                int tc = top + p.topMargin;
                int lr = lc + view.getMeasuredWidth();
                int tb = tc + view.getMeasuredHeight();
//为子View进行布局
                view.layout(lc, tc, lr, tb);
                left += view.getMeasuredWidth() + p.leftMargin + p.rightMargin;
            }
            left = 0;
            top += lineHeight;
        }

    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
