package com.example.xieshengqi.myokhttp;

import com.squareup.okhttp.Response;

/**
 * Created by xieshengqi on 15/11/5.
 */
public interface Parser<T> {

    T parse(Response response);
}
