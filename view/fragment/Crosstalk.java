package com.example.dell.quarterhour.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dell.quarterhour.R;
import com.example.dell.quarterhour.adater.CrosstalkAdater;
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
import com.example.dell.quarterhour.persenter.MyPresenter;
import com.example.dell.quarterhour.view.IView;
import com.example.dell.quarterhour.view.activity.BaseHot;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by DELL on 2018/6/5.
 */

public class Crosstalk extends BaseHot<MyPresenter> implements IView {

    private RecyclerView rec;
    private SimpleDraweeView simple;
    private DrawerLayout drawerlayout;

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
        List<RecommendBean.DataBean> data = bean.getData();
        CrosstalkAdater crosstalkAdater=new CrosstalkAdater(data,getActivity());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(crosstalkAdater);
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
        rec = inflate.findViewById(R.id.crosstalk_rec);
        simple = inflate.findViewById(R.id.simple);
        drawerlayout = inflate.findViewById(R.id.drawerlayout);

    }

    @Override
    protected int bindLayout() {
        return R.layout.crosstalk;
    }

    @SuppressLint("NewApi")
    @Override
    protected void initData() {
        BasePresenter.loadRecommend(1,"android","101","EB52D99F972FFFA5BB57D4C1B3397877");
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected MyPresenter setPresenter() {
        return new MyPresenter();
    }
}
