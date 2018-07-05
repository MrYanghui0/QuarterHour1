package com.example.dell.quarterhour.adater;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.example.dell.quarterhour.R;
import com.example.dell.quarterhour.bean.RecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.ui.widget.DanmakuView;

/**
 * Created by DELL on 2018/6/5.
 */

public class RecommendAdater extends RecyclerView.Adapter<RecommendAdater.Holder> {
    private List<RecommendBean.DataBean> list;
    private Context context;
    private DanmakuView mDanmakuView;
    private EditText editText;
    private Button send;
    private DanmakuContext mContext;
    private Button show;
    Shoucang shoucang;
    public void setShoucang(Shoucang shoucang) {
        this.shoucang = shoucang;
    }
    public interface Shoucang{
        void doShoucang(View view,int i,ImageView hot_collect);
    }


    public RecommendAdater(List<RecommendBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.hot_item,null);
        Holder holder=new Holder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        holder.simple1.setImageURI(list.get(position).getUser().getIcon()+"".split("\\|")[0]);
        holder.name.setText(list.get(position).getWorkDesc());
        holder.time.setText(list.get(position).getCreateTime());
        String s = list.get(position).getVideoUrl().toString();
        holder.simple2.stop();
        Glide.with(context).load(list.get(position).getCover()).into(holder.simple2.mPlayerThumb);
//        holder.simple2.init()
//                .setVideoPath("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4")
//             //   .setVideoPath(s)
//                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH)
//                .enableDanmaku()
//                .stop();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private boolean flag;
        private boolean flag1;
        private final SimpleDraweeView simple1;
        private final IjkPlayerView simple2;
        private final TextView name;
        private final TextView time;
        private final ImageView hot_like;
        private final ImageView hot_collect;
        private final ImageView hot_zhuanfa;
        private final RecyclerView rec;

        public Holder(View itemView) {
            super(itemView);
            rec = itemView.findViewById(R.id.hot_rec);
            simple1 = itemView.findViewById(R.id.fanxian_simple);
            simple2 = itemView.findViewById(R.id.fanxian_simple1);
            name = itemView.findViewById(R.id.faxian_name);
            time = itemView.findViewById(R.id.faxian_time);
            hot_like = itemView.findViewById(R.id.hot_like);
            hot_collect = itemView.findViewById(R.id.hot_collect);
            hot_zhuanfa = itemView.findViewById(R.id.hot_zhuanfa);

            hot_zhuanfa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showBottomSheetDialog();
                    showBottomDialog();
                }
            });
            hot_like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag){
                        hot_like.setImageResource(R.drawable.dx1);
                    }else{
                        hot_like.setImageResource(R.drawable.dx);
                    }
                    flag =! flag;

                }
            });
            hot_collect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (flag1){
                        hot_collect.setImageResource(R.drawable.hwjx);

                    }else{
                        hot_collect.setImageResource(R.mipmap.scc);

                    }
                    flag1 =! flag1;

                }
            });

        }
    }

    private void showBottomDialog() {
        final BottomSheetDialog dialog= new BottomSheetDialog(context);
        View dialogView= LayoutInflater.from(context).inflate(R.layout.dialog_layout,null);
        Button tvSure = (Button) dialogView.findViewById(R.id.tv_sure);
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(dialogView);
        dialog.show();
    }

    private void showBottomSheetDialog() {

    }

}
