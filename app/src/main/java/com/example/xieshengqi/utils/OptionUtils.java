package com.example.xieshengqi.utils;

import android.graphics.Bitmap;

import com.example.xieshengqi.myapplication.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;


/**
 * Created by xieshengqi on 15/10/21.
 */
public class OptionUtils {

    public static DisplayImageOptions getOption(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(false)
                .cacheOnDisc(false)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        return options;
    }
}
