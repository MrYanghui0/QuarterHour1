package com.example.dell.quarterhour.persenter;


import com.example.dell.quarterhour.view.BaseIView;

/**
 * Created by nyj on 2018/5/26.
 */

public class BasePresenter<V extends BaseIView> {


    private V iBaseView;
    //
    public void attachView(V iBaseView) {
        this.iBaseView = iBaseView;
    }

    public V getView() {

        return iBaseView;
    }

    public void dechView() {
        iBaseView = null;
    }

}
