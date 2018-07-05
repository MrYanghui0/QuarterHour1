package com.example.dell.quarterhour.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import com.example.dell.quarterhour.persenter.LoginPersneter;
import com.example.dell.quarterhour.view.IView;

public class OtherloginActivity extends BaseActivity<LoginPersneter> implements IView {

    private TextView forget;
    private String uid;
    private SharedPreferences.Editor edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        final EditText mobile = findViewById(R.id.mobile);
        final EditText password = findViewById(R.id.password);
        Button otherlogin = findViewById(R.id.otherlogin);
        forget = findViewById(R.id.forget);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent=new Intent(OtherloginActivity.this, ForgetActivity.class);
                    startActivity(intent);
            }
        });
        otherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile1 = mobile.getText().toString();
                String password1 = password.getText().toString();
                BasePresenter.loadLogin(mobile1,password1);

            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_otherlogin;
    }

    @Override
    protected LoginPersneter setPresenter() {
        return new LoginPersneter();
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

        if(loginBean.getCode()==0){
            uid = loginBean.getData().getUid();
            String token = loginBean.getData().getToken();
            Toast.makeText(this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
            SharedPreferences chenggong = getSharedPreferences("" +
                    "", MODE_PRIVATE);
            edit = chenggong.edit();
            edit.putString("uid",uid);
            edit.putString("token",token);
            edit.apply();
            finish();
        }else {
            Toast.makeText(this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void shibailogin(LoginBean bean) {
        Toast.makeText(this,bean.getMsg(),Toast.LENGTH_SHORT).show();
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
}
