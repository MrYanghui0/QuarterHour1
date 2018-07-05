package com.example.dell.quarterhour.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
import com.example.dell.quarterhour.persenter.ChangePersneter;
import com.example.dell.quarterhour.view.IView;

public  class ChangeActivity extends BaseActivity<ChangePersneter> implements IView {
    private String uid;
    private EditText one;
    private EditText two;
    private Button accomplish;
    private String one1;
    private String two1;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        one = findViewById(R.id.password_one);
        two = findViewById(R.id.password_two);
        setContentView(R.layout.activity_change);
        accomplish = findViewById(R.id.chenggong);
        accomplish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one1 = one.getText().toString();
                two1 = two.getText().toString();
                Log.e("aaaa",one1+"");
                BasePresenter.loadChange("10240","666666","123456");

            }
        });


    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {



    }

    @Override
    protected int setLayout() {
        return R.layout.activity_change;
    }

    @Override
    protected ChangePersneter setPresenter() {
        return new ChangePersneter();
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
        password = loginBean.getData().getPassword();
    }

    @Override
    public void shibailogin(LoginBean msg) {

    }

    @Override
    public void chenggongchange(ChangeBean Bean) {

        if(Bean.getCode().equals("0")){
                Toast.makeText(ChangeActivity.this,Bean.getMsg(),Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void shibaichange(String msg) {
        Toast.makeText(ChangeActivity.this,"修改失败",Toast.LENGTH_SHORT).show();
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
}
