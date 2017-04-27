package com.example.xieshengqi.myokhttp;

import com.squareup.okhttp.Response;

/**
 * Created by xieshengqi on 15/11/5.
 */
public class StringParser implements Parser<String> {
    @Override
    public String parse(Response response) {
        String result = null;
        try {
            result = response.body().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
