package com.example.xieshengqi.activitys;

import android.app.Activity;
import android.content.Context;
import android.media.MediaCodecList;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xieshengqi.myapplication.R;
import com.example.xieshengqi.utils.OptionUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.PauseOnScrollListener;

/**
 * Created by xieshengqi on 15/10/21.
 */
public class ListViewActivity extends ActionBarActivity {
    ListView mlistView;
    Context context;
    ImageLoader imageLoader;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.listview_activity);
        mlistView = (ListView) findViewById(R.id.listview);
        imageLoader = ImageLoader.getInstance();
        MyAdapter adapter = new MyAdapter();
        mlistView.setAdapter(adapter);
        //这个方法监听滑动,是否在滑动中停止加载图片
        mlistView.setOnScrollListener(new PauseOnScrollListener(imageLoader, true, false));
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.adapter_itemlayout, null);
                viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) convertView.findViewById(R.id.textView2);
                viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView2);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.imageView.setImageResource(R.mipmap.ic_launcher);
            String str = "http://a3.qpic.cn/psb?/V14OaNCr3Gl6oy/iPBzyqfZX22o8*0LAVQTIzgm.1dWR1OVRWqbmDVXxQA!/b/dHYBAAAAAAAA&ek=1&kp=1&pt=0&bo=gAJxBAAAAAAFANQ!&sce=50-1-1&rf=4-0";
            imageLoader.displayImage(str, viewHolder.imageView, OptionUtils.getOption());
            return convertView;
        }
        class ViewHolder {
            TextView textView;
            ImageView imageView;
        }
    }


}
