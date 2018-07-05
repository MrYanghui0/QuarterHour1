package com.example.dell.quarterhour.persenter;

import com.example.dell.quarterhour.model.https.RetrofitUntils;
import com.example.dell.quarterhour.view.IView;

/**
 * Created by DELL on 2018/6/19.
 */

public class FavoritePersenter  extends BasePresenter<IView> {
    private RetrofitUntils retrofitUntils;
    public FavoritePersenter(){
        //拿到单例
        retrofitUntils= RetrofitUntils.getInsatnce();
    }

}
