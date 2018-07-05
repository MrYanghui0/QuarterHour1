package com.example.dell.quarterhour.view.custom;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2017/10/11 0011.
 */

public class MyApp extends Application {

    private static MyApp mInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        Fresco.initialize(this);

        ImageLoaderConfiguration build = new ImageLoaderConfiguration
                .Builder(getApplicationContext()).build();

        ImageLoader instance = ImageLoader.getInstance();
        instance.init(build);




    }
    public static MyApp getInstance(){
        return mInstance;
    };

}
