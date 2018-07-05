package com.example.dell.quarterhour.persenter;

import android.util.Log;

import com.example.dell.quarterhour.bean.Hot1Bean;
import com.example.dell.quarterhour.model.https.RetrofitUntils;
import com.example.dell.quarterhour.view.IView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DELL on 2018/6/15.
 */

public class HotPersenter extends BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;
    public HotPersenter(){
        //拿到单例
        retrofitUntils=RetrofitUntils.getInsatnce();
    }
    public void loadHot(String token,String source,String appVersion,int page){
        Observable<Hot1Bean> hot1BeanObservable = retrofitUntils.getApi().gethot1(token, source, appVersion, page);
        hot1BeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Hot1Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Hot1Bean hot1Bean) {
                        getView().chenggonghot(hot1Bean);
                        Log.e("onNextHot",hot1Bean.getData()+"");
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().shibaihot(e.getMessage());
                        Log.e("onErrorHot","失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
