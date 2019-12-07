package com.bw.week02_moni.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.week02_moni.MainActivity;
import com.bw.week02_moni.R;
import com.bw.week02_moni.entity.ShopEntity;

import java.util.List;

/**
 * 时间 :2019/12/7  9:33
 * 作者 :苗恒
 * 功能 :
 */
public class RxxpAdapter  extends RecyclerView.Adapter<RxxpAdapter.MyViewHolder>{
    Context context; List<ShopEntity.ResultBean.RxxpBean.CommodityListBean> commodityList;
    public RxxpAdapter(Context context, List<ShopEntity.ResultBean.RxxpBean.CommodityListBean> commodityList) {
        this.context=context;
        this.commodityList=commodityList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.rxxp_item,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
      holder.tv_name.setText(commodityList.get(position).getCommodityName());
      holder.tv_price.setText("￥"+commodityList.get(position).getPrice());
        Glide.with(context).load(commodityList.get(position).getMasterPic()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+commodityList.get(position).getCommodityName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private   ImageView imageView;
        private   TextView tv_name;
        private  TextView tv_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
}
