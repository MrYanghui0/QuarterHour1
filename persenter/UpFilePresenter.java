package com.example.dell.quarterhour.persenter;


import android.util.Log;

import com.example.dell.quarterhour.bean.GrBean;
import com.example.dell.quarterhour.bean.TextBean;
import com.example.dell.quarterhour.model.https.RetrofitUntils;
import com.example.dell.quarterhour.view.IView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * Created by DELL on 2018/5/28.
 */

public class UpFilePresenter extends BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;
    public UpFilePresenter(){
        //拿到单例
        retrofitUntils=RetrofitUntils.getInsatnce();
    }
        public void loadDataServer(String uid, MultipartBody.Part file, String token){
        Observable<TextBean> textBeanObservable = retrofitUntils.getApi().uploadFile(uid, file, token);

        textBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TextBean textBean) {
                        getView().onSuccess(textBean);
                        Log.e("TX","onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onErr(e.getMessage());
                        Log.e("TX","onError");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void loadDataServerGr(String uid){
        Observable<GrBean> observable = retrofitUntils.getApi().getBean(uid);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GrBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GrBean grBean) {
                        getView().chenggongfile(grBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().shibaifile(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
