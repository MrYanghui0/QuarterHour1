package com.example.dell.quarterhour.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.dell.quarterhour.R;
import com.example.dell.quarterhour.adater.DemoAdapter;
import com.example.dell.quarterhour.bean.AdvertisingBean;
import com.example.dell.quarterhour.bean.ChangeBean;
import com.example.dell.quarterhour.bean.CollectBean;
import com.example.dell.quarterhour.bean.FavoriteBean;
import com.example.dell.quarterhour.bean.GrBean;
import com.example.dell.quarterhour.bean.Hot1Bean;
import com.example.dell.quarterhour.bean.LoginBean;
import com.example.dell.quarterhour.bean.RecommendBean;
import com.example.dell.quarterhour.bean.TextBean;
import com.example.dell.quarterhour.bean.VCRBean;
import com.example.dell.quarterhour.persenter.HotPersenter;
import com.example.dell.quarterhour.view.IView;
import com.example.dell.quarterhour.view.activity.BaseHot;

import java.util.List;

/**
 * Created by DELL on 2018/6/5.
 */

public class Hot1 extends BaseHot<HotPersenter> implements IView{

    private RecyclerView recylerview;
    private DemoAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void chenggong(AdvertisingBean bean) {

    }

    @Override
    public void shibai(String msg) {

    }

    @Override
    public void chengong1(RecommendBean bean) {

    }

    @Override
    public void shibai1(String msg) {

    }

    @Override
    public void chenggonglogin(LoginBean loginBean) {

    }

    @Override
    public void shibailogin(LoginBean msg) {

    }

    @Override
    public void chenggongchange(ChangeBean Bean) {

    }

    @Override
    public void shibaichange(String msg) {

    }

    @Override
    public void onSuccess(TextBean t) {

    }

    @Override
    public void onErr(String errMsg) {

    }

    @Override
    public void chenggongfile(GrBean bean) {

    }

    @Override
    public void shibaifile(String msg) {

    }

    @Override
    public void chenggongcollect(CollectBean bean) {

    }

    @Override
    public void shibaicollect(String msg) {

    }

    @Override
    public void chenggonghot(Hot1Bean bean) {
        List<Hot1Bean.DataBean> data = bean.getData();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        recylerview.setLayoutManager(staggeredGridLayoutManager);
        adapter=new DemoAdapter(data,getActivity());
        recylerview.setItemAnimator(new DefaultItemAnimator());
        recylerview.setAdapter(adapter);
    }

    @Override
    public void shibaihot(String msg) {

    }

    @Override
    public void chenggongfavorite(FavoriteBean bean) {

    }

    @Override
    public void shibaifavorite(String msg) {

    }

    @Override
    public void onSuccessVCR(VCRBean t) {

    }

    @Override
    public void onErrVCR(String msg) {

    }

    @Override
    protected void initView(View inflate) {
        recylerview = inflate.findViewById(R.id.recylerview);
        recylerview.setHasFixedSize(true);

    }

    @Override
    protected int bindLayout() {
        return R.layout.hot1;
    }

    @SuppressLint("NewApi")
    @Override
    protected void initData() {
        BasePresenter.loadHot("EB52D99F972FFFA5BB57D4C1B3397877","android","101",1);
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected HotPersenter setPresenter() {
        return new HotPersenter();
    }


}
