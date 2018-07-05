package com.example.dell.quarterhour.model.https;

import com.example.dell.quarterhour.model.untils.Constant;
import com.example.dell.quarterhour.model.untils.RetrofitApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nyj on 2018/5/26.
 */

public class RetrofitUntils {


    private OkHttpClient client;
    private  Retrofit retrofit;

    private RetrofitUntils() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    //单列模式
    private static RetrofitUntils INSTANCE;

    public static RetrofitUntils getInsatnce() {
        if (INSTANCE == null) {
            synchronized (RetrofitUntils.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetrofitUntils();
                }
            }
        }
        return INSTANCE;
    }


    public RetrofitApi getApi() {
        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        return retrofitApi;
    }
}
