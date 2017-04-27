package com.example.xieshengqi.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.xieshengqi.myapplication.R;

/**
 * Created by xieshengqi on 15/11/2.
 */
public class MyPercentFrameLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.percentframelayout);

    }
}
