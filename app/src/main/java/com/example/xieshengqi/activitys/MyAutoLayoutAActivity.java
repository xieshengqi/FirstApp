package com.example.xieshengqi.activitys;

import android.os.Bundle;

import com.zhy.autolayout.AutoLayout;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by xieshengqi on 15/11/26.
 */
public class MyAutoLayoutAActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AutoLayout.getInstance().auto(this);
    }
}
