package com.example.dell.quarterhour.persenter;

import android.util.Log;

import com.example.dell.quarterhour.bean.CollectBean;
import com.example.dell.quarterhour.model.https.RetrofitUntils;
import com.example.dell.quarterhour.view.IView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DELL on 2018/6/11.
 */

public class CollectPersenter  extends BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;
    public CollectPersenter(){
        //拿到单例
        retrofitUntils= RetrofitUntils.getInsatnce();
    }
    public void loadCollect(String uid,String token,String source,String appVersion){
        Observable<CollectBean> observable = retrofitUntils.getApi().getcollect(uid, token, source, appVersion);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CollectBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CollectBean bean) {
                        getView().chenggongcollect(bean);
                        Log.e("GZ",bean.getMsg()+"");
                        Log.e("GZ",bean.getCode()+"");

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().shibaicollect(e.getMessage());
                        Log.e("GZ","onError");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
