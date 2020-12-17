package com.hs.openframeanalysis;


import androidx.collection.ArrayMap;


import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


/**
 * 请求参数工具类
 * Created by Administrator on 2017/9/12.
 */

public class RequestParameter {

    /**
     * 获取String通过Part封装后的RequestBody
     *
     * @param value
     * @return
     */
    public static RequestBody getRequestBody(String value) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), value);
    }

    /**
     * map集合参数，拼接url
     */
    public static String getRequestParamsToUrl(String urlHead, Map<String, String> map) {
        String url = urlHead + "?";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            url = url.concat(entry.getKey() + "=" + entry.getValue() + "&");
        }
        url = url.substring(0, url.length() - 1);

        return url;
    }

}
