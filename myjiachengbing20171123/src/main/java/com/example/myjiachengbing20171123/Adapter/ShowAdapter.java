package com.example.myjiachengbing20171123.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myjiachengbing20171123.Bean.Beans;
import com.example.myjiachengbing20171123.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by tangxiaoying on 2017/11/13.
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.MyViewHolder> implements View.OnClickListener{

    private  Context context;
    private List<Beans.DataBean> chalist;

    //利用接口回调实现点击事件
    //再实例，然后创建方法
    private OnItemClickListener mOnItemClickListener = null;
    //点击事件
    @Override
    public void onClick(View view) {
        if (mOnItemClickListener!=null){
            mOnItemClickListener.onItemClick(view, (Integer) view.getTag());
        }

    }
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public ShowAdapter(Context context, List<Beans.DataBean> chalist) {
        this.context = context;
        this.chalist = chalist;
        Log.i("33333", "onBindViewHolder: "+chalist.size());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.rcy_item_line,null);
        MyViewHolder holder=new MyViewHolder(view);
        //调用点击
        view.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv.setText(chalist.get(position).getContent());


        DraweeController ff= Fresco.newDraweeControllerBuilder()
                .setUri(chalist.get(position).getImage_url())
                .setAutoPlayAnimations(true)
                .build();
        holder.iv.setController(ff);
        //把条目的下标position设置给holder
        holder.itemView.setTag(position);



    }

    public void setmOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }

    @Override
    public int getItemCount() {
        return chalist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public SimpleDraweeView iv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.img);
        }
    }
}
