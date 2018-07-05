package com.example.dell.quarterhour.persenter;

import android.util.Log;

import com.example.dell.quarterhour.bean.ChangeBean;
import com.example.dell.quarterhour.model.https.RetrofitUntils;
import com.example.dell.quarterhour.view.IView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DELL on 2018/6/8.
 */

public class ChangePersneter extends BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;
    public ChangePersneter(){
        //拿到单例
        retrofitUntils= RetrofitUntils.getInsatnce();
    }
    public void loadChange(String uid,String oldPassword,String newPassword){
        Observable<ChangeBean> observable = retrofitUntils.getApi().getchange(uid, oldPassword, newPassword);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChangeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ChangeBean changeBean) {
                        getView().chenggongchange(changeBean);
                        Log.e("onNext","onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().shibaichange(e.getMessage());
                        Log.e("onError","onError");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
