package com.example.xieshengqi.activitys;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xieshengqi.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xieshengqi on 15/11/3.
 */
public class TabViewpagerActivity extends Activity {
    private ViewPager mPager;
    private List<View> listViews;
    private ImageView cursor;
    private TextView t1, t2, t3;
    private int offset = 0;
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabviewpager_layout);
        initImageView();
        initTextView();
        initViewPager();
    }

    private void initTextView() {
        t1 = (TextView) findViewById(R.id.tabText_one);
        t2 = (TextView) findViewById(R.id.tabText_two);
        t3 = (TextView) findViewById(R.id.tabText_three);
        t1.setOnClickListener(new MyOnClickListener(0));
        t2.setOnClickListener(new MyOnClickListener(1));
        t3.setOnClickListener(new MyOnClickListener(2));
    }

    private void initViewPager() {
        mPager = (ViewPager) findViewById(R.id.tabViewpager);
        listViews = new ArrayList<View>();
        LayoutInflater inflater = getLayoutInflater();
        listViews.add(inflater.inflate(R.layout.tabviewpager_layout1, null));
        listViews.add(inflater.inflate(R.layout.tabviewpager_layout2, null));
        listViews.add(inflater.inflate(R.layout.tabviewpager_layout3, null));
        MyPagerAdapter adapter = new MyPagerAdapter(listViews);
        mPager.setAdapter(adapter);
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());

    }

    private void initImageView() {
        cursor = (ImageView) findViewById(R.id.cursor);
        bmpW = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher).getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (screenW / 3 - bmpW) / 2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        cursor.setImageMatrix(matrix);
    }

    class MyPagerAdapter extends PagerAdapter {


        public List<View> mListViews;

        public MyPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(mListViews.get(arg1));
        }

        @Override
        public void finishUpdate(View arg0) {
        }

        @Override
        public int getCount() {
            return mListViews.size();
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(mListViews.get(arg1), 0);
            return mListViews.get(arg1);
        }


        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == (arg1);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
        }
    }

    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }


        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    }

    ;

        public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        int one = offset * 2 + bmpW;// 页卡1 -> 页卡2 偏移量
        int two = one * 2;// 页卡1 -> 页卡3 偏移量

        //        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(one, 0, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, 0, 0, 0);
                    }
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, one, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, one, 0, 0);
                    }
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, two, 0, 0);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, two, 0, 0);
                    }
                    break;
            }
            currIndex = arg0;
            animation.setFillAfter(true);// True:图片停在动画结束位置
            animation.setDuration(300);
            cursor.startAnimation(animation);
        }

        //        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        //        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }
}
