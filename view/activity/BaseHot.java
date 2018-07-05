package com.example.dell.quarterhour.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.quarterhour.persenter.BasePresenter;
import com.example.dell.quarterhour.view.IView;


/**
 * Created by DELL on 2018/5/28.
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public abstract  class BaseHot<P extends BasePresenter> extends Fragment implements IView {
    public P BasePresenter;
    private View inflate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(bindLayout(), container, false);
        initView(inflate);
        initBaseView();
        initData();
        bindEvent();

        return inflate;
    }

    protected abstract void initView(View inflate);



    private void initBaseView() {
        BasePresenter=setPresenter();
        if(BasePresenter!=null){
            BasePresenter.attachView(this);
        }
    }

    protected abstract int bindLayout();

    protected abstract void initData();


    protected abstract void bindEvent();

    protected abstract P setPresenter();
}
