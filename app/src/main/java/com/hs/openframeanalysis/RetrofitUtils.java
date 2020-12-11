package com.hs.openframeanalysis;

import com.hs.distribution.bean.UserLoginResultBean;
import com.hs.distribution.http.RequestParameter;
import com.hs.distribution.http.ServiceApi;
import com.hs.distribution.http.UrlHelper;
import com.hs.distribution.utils.AESUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (null == retrofit) {
            synchronized (RetrofitUtils.class) {

                retrofit = new Retrofit.Builder()
                        .baseUrl(UrlHelper.API_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .build();

                ServiceApi serviceApi = retrofit.create(ServiceApi.class);

                Map<String, String> map = new HashMap<>();
                try {
                    map.put("username", "18291882592");
                    map.put("password", AESUtils.encryptAES("123456"));
                    map.put("grant_type", "password");
                    map.put("scope", "server");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                serviceApi.userLogin(
                        RequestParameter.getRequestParamsToUrl(UrlHelper.API_URL + UrlHelper.LOGIN, map)
                ).enqueue(new Callback<UserLoginResultBean>() {
                    @Override
                    public void onResponse(Call<UserLoginResultBean> call, Response<UserLoginResultBean> response) {
                    }
                    @Override
                    public void onFailure(Call<UserLoginResultBean> call, Throwable t) {
                    }
                });


            }
        }
        return retrofit;
    }
}
