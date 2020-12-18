package com.hs.openframeanalysis;

import android.content.Intent;

import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;

public class OkHttpUtils {
    public static final int TIME_OUT = 30;

    private static OkHttpClient okHttpClient;


    private static OkHttpClient getOkHttpClient() {
        if (null == okHttpClient) {
            synchronized (OkHttpUtils.class) {
                okHttpClient = new OkHttpClient.Builder()
                        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                        .callTimeout(TIME_OUT, TimeUnit.SECONDS)
                        .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                        .build();
            }
        }
        return okHttpClient;
    }

    /**
     * 同步请求方式
     */
    public static void synchronization() {
        try {
            okHttpClient = getOkHttpClient();
            Request request = new Request.Builder().build();
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步请求方式
     */
    public static void asynchronous() {
        okHttpClient = getOkHttpClient();
        Request request = new Request.Builder().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    /**
     * okhttp线程池创建逻辑
     */
    public static void ExecutorTest() {
        Executor executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),
                Util.threadFactory("okhttp dispatcher", false)
        );
    }
}
