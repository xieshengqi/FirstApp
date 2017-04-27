package com.example.xieshengqi.myokhttp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xieshengqi on 15/11/12.
 */
public class OKHttpUtils {
    private static String NV_BASE_URL_TEST = "http://test.ixueike.com/api";

    public static void getUser(String name, String password, MyResultCallback callback) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("username",name);
        params.put("password", password);
        OkHttpClientManager.postAsyn(NV_BASE_URL_TEST + "/userapi/login", params, callback);

    }

}
