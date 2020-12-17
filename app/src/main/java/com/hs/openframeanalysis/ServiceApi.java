package com.hs.openframeanalysis;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ServiceApi {

    @Headers("Authorization:Basic YXBwOmFwcA==")
    @POST
    Call<UserLoginResultBean> userLogin(@Url String url);
}
