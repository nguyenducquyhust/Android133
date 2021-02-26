package com.lab.kiotmpecbk.api.hanghoa;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lab.kiotmpecbk.api.login.LoginApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface HanghoaService {

    Gson gson= new GsonBuilder()
            .setDateFormat("yyyy-MM-đ HH:mm:ss")
            .create();

    LoginApiService apiService = new Retrofit.Builder()
            .baseUrl("http://lab.kiotmpecbk.cloud:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoginApiService.class);

}
