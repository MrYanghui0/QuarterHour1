package com.example.dell.quarterhour.adater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.quarterhour.R;
import com.example.dell.quarterhour.bean.CollectBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by DELL on 2018/6/11.
 */

public class CollectAdater extends RecyclerView.Adapter<CollectAdater.Holder> {
    private List<CollectBean.DataBean> list;
    private Context context;

    public CollectAdater(List<CollectBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.collect_item,null);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.simple.setImageURI(list.get(position).getIcon());
        holder.name.setText(list.get(position).getNickname());
        holder.text.setText(list.get(position).getUsername());
        holder.time.setText(list.get(position).getCreatetime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simple;
        private final TextView name;
        private final TextView text;
        private final TextView time;

        public Holder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.collect_simple);
            name = itemView.findViewById(R.id.collect_name);
            text = itemView.findViewById(R.id.collect_text);
            time = itemView.findViewById(R.id.collect_time);
        }
    }
}
