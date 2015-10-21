package com.example.xieshengqi.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xieshengqi.myapplication.R;

/**
 * Created by xieshengqi on 15/10/26.
 */
public class LeftFragment extends Fragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.leftmenu_fragment,container,false);
//        return View.inflate(this, R.layout.leftmenu_fragment,null);
//        return View.inflate(this, R.layout.leftmenu_fragment,null);
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
