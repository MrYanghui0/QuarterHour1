package com.example.dell.quarterhour.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.dell.quarterhour.R;
import com.example.dell.quarterhour.adater.CollectAdater;
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
import com.example.dell.quarterhour.persenter.CollectPersenter;
import com.example.dell.quarterhour.view.IView;

import java.util.List;

public class CollectActivity extends BaseActivity<CollectPersenter> implements IView {

    private SharedPreferences chenggong;

    private RecyclerView rec;
    private String token;
    private String uid;
    private TextView simple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void initData() {
        chenggong =getSharedPreferences("chenggong", MODE_PRIVATE);
        chenggong.getBoolean("isLogin",true);
        uid = chenggong.getString("uid", "");
        token = chenggong.getString("token", "");
        BasePresenter.loadCollect("10240", "EB52D99F972FFFA5BB57D4C1B3397877","android","101");
    }

    @Override
    protected void initView() {
        rec = findViewById(R.id.collect_rec);
        simple = findViewById(R.id.simple);
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_collect;
    }

    @Override
    protected CollectPersenter setPresenter() {
        return new CollectPersenter();
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
        List<CollectBean.DataBean> data = bean.getData();
        CollectAdater collectAdater=new CollectAdater(data,this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(collectAdater);
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
}
