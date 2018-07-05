package com.example.dell.quarterhour.adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.quarterhour.R;
import com.example.dell.quarterhour.bean.RecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by DELL on 2018/6/12.
 */

public class CrosstalkAdater extends RecyclerView.Adapter<CrosstalkAdater.MyHolder> {
    private List<RecommendBean.DataBean> list;
    private Context context;
    private  ImageView copy;
    private  ImageView image_report;
    private  ImageView image_show;
    private  ImageView image_jian;
    public CrosstalkAdater(List<RecommendBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.crosstalk_item,null);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.simple.setImageURI(list.get(position).getUser().getIcon()+"".split("\\|")[0]);
        holder.name.setText(list.get(position).getWorkDesc());
        holder.time.setText(list.get(position).getCreateTime());




    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView simple;
        private final TextView name;
        private final TextView time;


        public MyHolder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.crosstalk_simple);
            name = itemView.findViewById(R.id.crosstalk_name);
            time = itemView.findViewById(R.id.crosstalk_time);
        }
    }
}
