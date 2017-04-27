package com.example.xieshengqi.activitys;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xieshengqi.myapplication.R;
import com.example.xieshengqi.views.FlowLayout;

/**
 * 流式布局
 * Created by xieshengqi on 15/10/26.
 */
public class FlowLayoutActivity extends AppCompatActivity {


    private FlowLayout flowLayout;
    private String mNames[] = {
            "welcome", "android", "TextView",
            "apple", "jamy", "kobe bryant",
            "jordan", "layout", "viewgroup",
            "margin", "padding", "text",
            "name", "type", "search", "logcat"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flowlayout_activity);
        initChildViews();
    }


    private void initChildViews() {

        flowLayout = (FlowLayout) findViewById(R.id.flowlayout);
        ViewGroup.MarginLayoutParams p = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
        p.leftMargin = 5;
        p.rightMargin = 5;
        p.topMargin = 5;
        p.bottomMargin = 5;
        for (int i = 0; i < mNames.length; i++) {
            TextView textView = new TextView(this);
            textView.setText(mNames[i]);
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
            flowLayout.addView(textView, p);

        }

    }
}

