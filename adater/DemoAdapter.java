package com.example.dell.quarterhour.adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.example.dell.quarterhour.R;
import com.example.dell.quarterhour.bean.Hot1Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by DELL on 2018/6/15.
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.Holder> {
    private List<Hot1Bean.DataBean> list;
    private Context context;
    private List<Integer> heightList;

    public DemoAdapter(List<Hot1Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;

        heightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int height = new Random().nextInt(300) + 500;//[100,300)的随机数
            heightList.add(height);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.hot1_item,null);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        String s = list.get(position).getVideoUrl().toString();
        holder.image.stop();
        Glide.with(context).load(list.get(position).getCover()).into(holder.image.mPlayerThumb);
//        holder.image.init()
//                .setVideoPath("http://jzvd.nathen.cn/342 a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4")
//                //.setVideoPath(s)
//                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
//                .enableDanmaku()
//                    .stop();
//        ViewGroup.LayoutParams layoutParams = holder.image.getLayoutParams();
//        layoutParams.height=heightList.get(position);
//        holder.image.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder implements com.example.dell.quarterhour.adater.Holder {
        private final IjkPlayerView image;

        public Holder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hot1_image);

        }

    }

}
