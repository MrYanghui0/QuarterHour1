package com.example.dell.quarterhour.persenter;

import com.example.dell.quarterhour.bean.AdvertisingBean;
import com.example.dell.quarterhour.bean.FavoriteBean;
import com.example.dell.quarterhour.bean.RecommendBean;
import com.example.dell.quarterhour.model.https.RetrofitUntils;
import com.example.dell.quarterhour.view.IView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DELL on 2018/5/28.
 */

public class MyPresenter extends BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;
    public MyPresenter(){
        //拿到单例
        retrofitUntils= RetrofitUntils.getInsatnce();
    }
    public void loadDataServer(){
        Observable<AdvertisingBean> observable = retrofitUntils.getApi().getAdvertising();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AdvertisingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdvertisingBean advertisingBean) {
                        getView().chenggong(advertisingBean);
                        //Log.e("onNext","onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().shibai(e.getMessage());
                        //Log.e("onError","onError");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void loadRecommend(int page,String source,String appVersion,String token){
        Observable<RecommendBean> observable = retrofitUntils.getApi().getRecommendBean(page, source, appVersion,token);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecommendBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecommendBean recommendBean) {
                        getView().chengong1(recommendBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().shibai1(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void loadFavorite(String uid ,String wid,String token,String source,String appVersion){
        Observable<FavoriteBean> observable = retrofitUntils.getApi().getfavorite(uid, wid, token, source, appVersion);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FavoriteBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FavoriteBean favoriteBean) {
                        getView().chenggongfavorite(favoriteBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().shibaifavorite(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
