package com.bw.week02_moni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.week02_moni.adapter.MlssAdapter;
import com.bw.week02_moni.adapter.PzshAdapter;
import com.bw.week02_moni.adapter.RxxpAdapter;
import com.bw.week02_moni.base.BaseActivity;
import com.bw.week02_moni.contract.IShopContract;
import com.bw.week02_moni.entity.ShopEntity;
import com.bw.week02_moni.entity.XBanerEntity;
import com.bw.week02_moni.presenter.ShopPresenter;
import com.google.gson.Gson;
import com.stx.xhb.androidx.XBanner;

import java.util.List;

public class MainActivity extends BaseActivity<ShopPresenter> implements IShopContract.IView {


    private XBanner xBanner;
    private RecyclerView rxxp;
    private RecyclerView pzsh;
    private RecyclerView mlss;

    @Override
    protected ShopPresenter initPresenter() {
        return new ShopPresenter();
    }

    @Override
    protected int bindLayoutid() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
       presenter.getListData();
       presenter.getXBanerData();
    }

    @Override
    protected void initView() {
        xBanner = findViewById(R.id.xb);
        rxxp = findViewById(R.id.rxxp);
        pzsh = findViewById(R.id.pzsh);
        mlss = findViewById(R.id.mlss);
        rxxp.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        pzsh.setLayoutManager(new LinearLayoutManager(this));
        mlss.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    public void success(Object data) {
        //请求成功的数据
        if(data instanceof ShopEntity){
            RxxpAdapter rxxpAdapter = new RxxpAdapter(MainActivity.this, ((ShopEntity) data).getResult().getRxxp().getCommodityList());
            rxxp.setAdapter(rxxpAdapter);
            PzshAdapter pzshAdapter = new PzshAdapter(MainActivity.this, ((ShopEntity) data).getResult().getPzsh().getCommodityList());
            pzsh.setAdapter(pzshAdapter);
            MlssAdapter mlssAdapter = new MlssAdapter(MainActivity.this, ((ShopEntity) data).getResult().getMlss().getCommodityList());
            mlss.setAdapter(mlssAdapter);

        }else if(data instanceof XBanerEntity){
            final List<XBanerEntity.ResultBean> result = ((XBanerEntity) data).getResult();
            xBanner.setBannerData(result);
            xBanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(MainActivity.this).load(result.get(position).getImageUrl()).into((ImageView) view);
                }
            });
        }
    }

    @Override
    public void failue(Throwable throwable) {

    }

    @Override
    public void showLoding() {

    }

    @Override
    public void hideShowLoding() {

    }
}
