package com.example.xieshengqi.myokhttp;

import android.content.Context;

import com.example.xieshengqi.myapplication.R;
import com.example.xieshengqi.weight.LoadingDialog;
import com.squareup.okhttp.Request;

/**
 * Created by xieshengqi on 15/11/12.
 */
public   class MyResultCallback<T> extends OkHttpClientManager.ResultCallback<T>
{

    private boolean isShowDialog;
private Context context;
private LoadingDialog dialog;
    public  MyResultCallback(Context context,boolean isShowDialog){
        this.isShowDialog = isShowDialog;
        this.context = context;
        initDialog(context);
    }

    @Override
    public void onBefore(Request request)
    {
        super.onBefore(request);
        if(isShowDialog){
            dialog.show();
        }
    }

    @Override
    public void onAfter()
    {
        super.onAfter();
        if(dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public void onError(Request request, Exception e) {

    }

    @Override
    public void onResponse(T response) {

    }

    private void initDialog(Context contxt){
dialog = new LoadingDialog(context, R.style.loadingDialog);
    }
}
