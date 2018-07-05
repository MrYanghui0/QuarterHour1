package com.example.dell.quarterhour.view.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dell.quarterhour.R;
import com.example.dell.quarterhour.adater.RecommendAdater;
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
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/6/5.
 */

public class Hot extends BaseHot<MyPresenter> implements IView, XBanner.XBannerAdapter,RecommendAdater.Shoucang {

    private XBanner xbanner;
    private List<String> list;
    private RecyclerView rec;
    private SwipeRefreshLayout duanzi_swfl;
    int page = 1;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

        }
    }

    @Override
    protected void initView(View inflate) {
        xbanner = inflate.findViewById(R.id.xbanner);
        rec = inflate.findViewById(R.id.hot_rec);
        duanzi_swfl = inflate.findViewById(R.id.duanzi_swfl);



    }

    @Override
    protected int bindLayout() {
        return R.layout.hot;
    }

    @SuppressLint("NewApi")
    @Override
    protected void initData() {
        BasePresenter.loadDataServer();
        BasePresenter.loadRecommend(page,"android","101","2");
        init();
    }

    private void init() {
        duanzi_swfl.setColorSchemeColors(Color.GRAY);
        duanzi_swfl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @SuppressLint("NewApi")
            @Override
            public void onRefresh() {
                duanzi_swfl.setRefreshing(false);
                page++;
                BasePresenter.loadRecommend(page,"android","101","1");
                Toast.makeText(getActivity(),"刷新成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected MyPresenter setPresenter() {
        return new MyPresenter();
    }

    @Override
    public void chenggong(AdvertisingBean bean) {
        List<AdvertisingBean.DataBean> data = bean.getData();
        list = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String icon = data.get(i).getIcon();
            list.add(icon);

        }
        xbanner.setData(list,null);
        xbanner.setmAdapter(this);

    }

    @Override
    public void shibai(String msg) {

    }

    @Override
    public void chengong1(RecommendBean bean) {
        List<RecommendBean.DataBean> data = bean.getData();
        RecommendAdater recommendAdater=new RecommendAdater(data,getActivity());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        rec.setNestedScrollingEnabled(false);
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(recommendAdater);
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
        Toast.makeText(getActivity(),"收藏成功",Toast.LENGTH_SHORT).show();
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
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(this).load(list.get(position)).into((ImageView) view);
    }


    @Override
    public void doShoucang(View view, int i, ImageView hot_collect) {
        hot_collect.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                BasePresenter.loadFavorite("10240","1","EB52D99F972FFFA5BB57D4C1B3397877","android","101");
                Toast.makeText(getActivity(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
