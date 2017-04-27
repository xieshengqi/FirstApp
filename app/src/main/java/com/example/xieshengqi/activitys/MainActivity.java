package com.example.xieshengqi.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.xieshengqi.json.BaseJsonData;
import com.example.xieshengqi.json.User;
import com.example.xieshengqi.myapplication.R;
import com.example.xieshengqi.myokhttp.MyResultCallback;
import com.example.xieshengqi.myokhttp.OKHttpUtils;
import com.squareup.okhttp.Request;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.flowlayout_btn).setOnClickListener(this);
        findViewById(R.id.cehuan_btn).setOnClickListener(this);
        findViewById(R.id.swipe_btn).setOnClickListener(this);
        findViewById(R.id.pullrefreshView_btn).setOnClickListener(this);
        findViewById(R.id.percentframelayout_btn).setOnClickListener(this);
        findViewById(R.id.tablayout_btn).setOnClickListener(this);
        findViewById(R.id.post_btn).setOnClickListener(this);
        findViewById(R.id.imagecheck_btn).setOnClickListener(this);
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
        switch (v.getId()) {
            case R.id.button:
                //滚动不加载的listView
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.cehuan_btn:
                //仿qq侧滑
                Intent intent1 = new Intent(MainActivity.this, DrawlayoutActivity.class);
                startActivity(intent1);
                break;
            case R.id.flowlayout_btn:
                //流式布局
                Intent intent2 = new Intent(MainActivity.this, FlowLayoutActivity.class);
                startActivity(intent2);
                break;
            case R.id.swipe_btn:
                //android自带下拉控件
                Intent intent3 = new Intent(MainActivity.this, SwipeRefreshActivity.class);
                startActivity(intent3);
                break;
            case R.id.pullrefreshView_btn:
                //第三方下拉刷新
                Intent intent4 = new Intent(MainActivity.this, PullRefreshActivity.class);
                startActivity(intent4);
                break;
            case R.id.percentframelayout_btn:
                //百分比布局
                Intent intent5 = new Intent(MainActivity.this, MyPercentFrameLayoutActivity.class);
                startActivity(intent5);
                break;
            case R.id.tablayout_btn:
                //Tablayout
                Intent intent6 = new Intent(MainActivity.this, TabViewpagerActivity.class);
                startActivity(intent6);
                break;
            case R.id.post_btn:
                getUser();
                break;
            case R.id.imagecheck_btn:

                break;
        }
    }


    private void getUser() {
        OKHttpUtils.getUser("495386399@qq.com", "123456", new MyResultCallback<BaseJsonData<User>>(MainActivity.this,true) {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(BaseJsonData<User> response) {
                Toast.makeText(MainActivity.this,response.getData().toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

}
