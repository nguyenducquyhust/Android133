package com.lab.kiotmpecbk.api.login;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lab.kiotmpecbk.entities.login.UserLoginRequest;
import com.lab.kiotmpecbk.entities.login.UserLoginResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginApiService {

    Gson gson= new GsonBuilder()
            .setDateFormat("yyyy-MM-đ HH:mm:ss")
            .create();

    LoginApiService apiService = new Retrofit.Builder()
            .baseUrl("http://lab.kiotmpecbk.cloud:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoginApiService.class);

    @POST("api/v1/public/user/login")
    Call<UserLoginResponse> callLogin(@Body UserLoginRequest userLogin);

}
