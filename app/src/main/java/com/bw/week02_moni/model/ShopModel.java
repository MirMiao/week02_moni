package com.bw.week02_moni.model;

import android.text.method.MovementMethod;

import com.bw.week02_moni.base.IBaseModel;
import com.bw.week02_moni.contract.IShopContract;
import com.bw.week02_moni.entity.ShopEntity;
import com.bw.week02_moni.entity.XBanerEntity;
import com.bw.week02_moni.util.VolleyUtil;
import com.google.gson.Gson;

/**
 * 时间 :2019/12/7  8:53
 * 作者 :苗恒
 * 功能 :
 */
public class ShopModel implements IShopContract.IModel {

    @Override
    public void getListData(final ModelCallBack modelCallBack) {
        VolleyUtil.getInstance().doGet("http://172.17.8.100/small/commodity/v1/commodityList", new VolleyUtil.VolleyCallBack() {
            @Override
            public void success(String response) {
                ShopEntity shopEntity = new Gson().fromJson(response, ShopEntity.class);
                modelCallBack.success(shopEntity);
            }

            @Override
            public void failur(Throwable throwable){
                modelCallBack.failue(throwable);
            }
        });
    }

    @Override
    public void getXBanerData(final ModelCallBack modelCallBack) {
           VolleyUtil.getInstance().doGet("http://172.17.8.100/small/commodity/v1/bannerShow", new VolleyUtil.VolleyCallBack() {
               @Override
               public void success(String response) {
                   XBanerEntity xBanerEntity = new Gson().fromJson(response, XBanerEntity.class);
                   modelCallBack.success(xBanerEntity);
               }

               @Override
               public void failur(Throwable throwable) {
                   modelCallBack.failue(throwable);
               }
           });
    }
}
