package com.example.dell.quarterhour.persenter;

import android.util.Log;

import com.example.dell.quarterhour.bean.LoginBean;
import com.example.dell.quarterhour.model.https.RetrofitUntils;
import com.example.dell.quarterhour.view.IView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DELL on 2018/6/6.
 */

public class LoginPersneter extends  BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;
    public LoginPersneter(){
        //拿到单例
        retrofitUntils= RetrofitUntils.getInsatnce();
    }
    public void loadLogin(String mobile,String password){
        Observable<LoginBean> observable = retrofitUntils.getApi().getLogin(mobile, password);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        getView().chenggonglogin(loginBean);
                        Log.e("onNext","onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError====","onError");
                    }


                    @Override
                    public void onComplete() {

                    }
                });
    }
}
