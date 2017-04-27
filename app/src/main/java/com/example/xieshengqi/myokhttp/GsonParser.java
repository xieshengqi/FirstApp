package com.example.xieshengqi.myokhttp;

import com.google.gson.Gson;
import com.squareup.okhttp.Response;

/**
 * Created by xieshengqi on 15/11/5.
 */
public class GsonParser<T> implements  Parser<T> {
    private  Class<T> mClass = null;

    private GsonParser(Class<T> cls){
        if(cls ==null){
            throw new IllegalArgumentException("Class can't be null");
        }
        this.mClass = cls;
    }

    @Override
    public T parse(Response response) {
        try {
            Gson gson = new Gson();

        }catch (Exception e){
            e.printStackTrace();
        }



        return null;
    }
}
