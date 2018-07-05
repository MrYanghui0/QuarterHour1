package com.example.dell.quarterhour.view;

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


/**
 * Created by DELL on 2018/5/28.
 */

public interface IView extends BaseIView {
    void chenggong(AdvertisingBean bean);
    void shibai(String msg);
    void chengong1(RecommendBean bean);
    void shibai1(String msg);
    void chenggonglogin(LoginBean loginBean);
    void shibailogin(LoginBean loginBean);

    void chenggongchange(ChangeBean Bean);
    void shibaichange(String msg);

    void onSuccess(TextBean t);
    void onErr(String errMsg);

    void chenggongfile(GrBean bean);
    void shibaifile(String msg);

    //关注用户列表
    void chenggongcollect(CollectBean bean);
    void shibaicollect(String msg);

    void chenggonghot(Hot1Bean bean);
    void shibaihot(String msg);

    //收藏作品
    void chenggongfavorite(FavoriteBean bean);
    void shibaifavorite(String msg);
    //发布视频作品
    void onSuccessVCR(VCRBean t);
    void onErrVCR(String msg);
}
