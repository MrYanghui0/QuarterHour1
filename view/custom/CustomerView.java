package com.example.dell.quarterhour.view.custom;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.dell.quarterhour.R;

/**
 * Created by DELL on 2018/6/14.
 */

public class CustomerView  extends RelativeLayout {
    private ImageView image_show;
    private ImageView image_jian;
    private ImageView image_report;
    private ImageView image_copy;

    public CustomerView(Context context) {
        super(context);
    }

    public CustomerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.crosstalk_customer, this, false);
        image_show = view.findViewById(R.id.image_show);
        image_jian = view.findViewById(R.id.image_jian);
        image_report = view.findViewById(R.id.image_report);
        image_copy = view.findViewById(R.id.image_copy);

        //加号按钮的点击事件,展示另外三张图片
        image_show.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                image_jian.setVisibility(View.VISIBLE);
                image_show.setVisibility(View.GONE);
                showMenu();
            }
        });

        //减号的点击事件,隐藏另外三张图片
        image_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                image_jian.setVisibility(View.GONE);
                image_show.setVisibility(View.VISIBLE);
                hideMenu();
            }
        });

        addView(view);
    }

    public CustomerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //属性动画,,展示出来
    public void showMenu(){
        //三个平移动画 平移出来
        ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(image_copy
                ,"translationX",0,-118*2);
        ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(image_report
                ,"translationX",0,-118*1);

        //旋转动画
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(image_jian, "rotation", 0, 135, 0);
        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(image_report, "rotation", 0, 180, 0);
        ObjectAnimator rotation3 = ObjectAnimator.ofFloat(image_copy, "rotation", 0, 180, 0);

        //组合动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(800);//动画时长
        animatorSet.setInterpolator(new OvershootInterpolator());
        //设置动画一起播放
        animatorSet.playTogether(rotation1,rotation2,rotation3,secondAnimator,thirdAnimator);

        animatorSet.start();

    }

    public void hideMenu(){
        //三个平移回去

        ObjectAnimator secondAnimator = ObjectAnimator.ofFloat(image_copy
                , "translationX", image_copy.getTranslationX(), 0);
        ObjectAnimator thirdAnimator = ObjectAnimator.ofFloat(image_report
                , "translationX", image_report.getTranslationX(), 0);
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(image_show, "rotation", 0, 185, 0);
        ObjectAnimator rotation2 = ObjectAnimator.ofFloat(image_copy, "rotation", 0, 230, 0);
        ObjectAnimator rotation4 = ObjectAnimator.ofFloat(image_report, "rotation", 0, 230, 0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(800);
        animatorSet.setInterpolator(new OvershootInterpolator());
        animatorSet.playTogether(rotation1,rotation2,rotation4,secondAnimator,thirdAnimator);

        animatorSet.start();
    }

}
