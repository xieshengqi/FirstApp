package com.example.xieshengqi.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.xieshengqi.myapplication.R;
import com.nostra13.universalimageloader.core.ImageLoader;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String str = "http://a3.qpic.cn/psb?/V14OaNCr3Gl6oy/iPBzyqfZX22o8*0LAVQTIzgm.1dWR1OVRWqbmDVXxQA!/b/dHYBAAAAAAAA&ek=1&kp=1&pt=0&bo=gAJxBAAAAAAFANQ!&sce=50-1-1&rf=4-0";
//        ImageView image = (ImageView) findViewById(R.id.imageView);
//        ImageLoader.getInstance().displayImage(str,image);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Intent intent = new Intent(MainActivity.this, DrawlayoutActivity.class);
                startActivity(intent);
                break;
        }
    }
}