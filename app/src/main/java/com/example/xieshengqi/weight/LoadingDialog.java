package com.example.xieshengqi.weight;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.xieshengqi.myapplication.R;

/**
 * Created by xieshengqi on 15/11/12.
 */
public class LoadingDialog extends Dialog {
    public LoadingDialog(Context context) {
        super(context);
        init(context);
    }

    protected LoadingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    public LoadingDialog(Context context, int theme) {
        super(context, theme);
        init(context);
    }

    private  void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_layout,null);
        setContentView(view);
    }

}
