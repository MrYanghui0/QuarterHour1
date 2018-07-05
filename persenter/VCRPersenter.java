package com.example.dell.quarterhour.persenter;

import com.example.dell.quarterhour.bean.VCRBean;
import com.example.dell.quarterhour.model.https.RetrofitUntils;
import com.example.dell.quarterhour.view.IView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * Created by DELL on 2018/6/21.
 */

public class VCRPersenter extends BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;
    public VCRPersenter(){
        //拿到单例
        retrofitUntils=RetrofitUntils.getInsatnce();
    }
    public void loadVCR(String uid, MultipartBody.Part videoFile,MultipartBody.Part coverFile,String token,String source,String appVersion,String latitude,String longitude){
        Observable<VCRBean> vcr = retrofitUntils.getApi().getVCR(uid, videoFile, coverFile, token, source, appVersion, latitude, longitude);
        vcr.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VCRBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VCRBean vcrBean) {
                        getView().onSuccessVCR(vcrBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onErrVCR(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
