package com.example.dell.quarterhour.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.example.dell.quarterhour.R;
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
import com.example.dell.quarterhour.view.custom.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/6/5.
 */

public class Video extends BaseFragment<HotPersenter> implements IView {

    private TabLayout tabLayout;
    private NoScrollViewPager viewpager;
    private List<Fragment> list;
    private int theme = R.style.AppTheme;
    private String[] tab = {"热门", "关注"};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            theme = savedInstanceState.getInt("theme");
            setTheme(theme);
        }
    }

    @Override
    protected void initView(View inflate) {
        tabLayout = inflate.findViewById(R.id.tabLayout);
        viewpager = inflate.findViewById(R.id.viewpager);
        init();
        viewpager.setAdapter(new MyVpAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewpager);
            }
        });
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewpager);

    }
    public void setTheme(int theme) {
        this.theme = theme;
    }
    @Override
    protected int bindLayout() {
        return R.layout.video;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected HotPersenter setPresenter() {
        return new HotPersenter();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return null;
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
    public void shibailogin(LoginBean loginBean) {

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

    class MyVpAdapter extends FragmentPagerAdapter {


        public MyVpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tab[position];
        }
    }
    private void init() {
        list = new ArrayList<>();
        Hot1 hot1=new Hot1();
        Nearby nearby=new Nearby();
        list.add(hot1);
        list.add(nearby);
    }
}