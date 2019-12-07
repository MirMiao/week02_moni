package com.bw.week02_moni.presenter;

import com.bw.week02_moni.base.BasePresenter;
import com.bw.week02_moni.contract.IShopContract;
import com.bw.week02_moni.model.ShopModel;

/**
 * 时间 :2019/12/7  8:58
 * 作者 :苗恒
 * 功能 :
 */
public class ShopPresenter extends BasePresenter<ShopModel,IShopContract.IView> implements IShopContract.IPresenter {

    @Override
    protected ShopModel initModel() {
        return new ShopModel();
    }

    @Override
    public void getListData() {
         model.getListData(new IShopContract.IModel.ModelCallBack() {
             @Override
             public void success(Object data) {
                   getView().success(data);
             }

             @Override
             public void failue(Throwable throwable) {
                    getView().failue(throwable);
             }
         });
    }

    @Override
    public void getXBanerData() {
        model.getXBanerData(new IShopContract.IModel.ModelCallBack() {
            @Override
            public void success(Object data) {
                getView().success(data);
            }

            @Override
            public void failue(Throwable throwable) {
                   getView().failue(throwable);
            }
        });
    }
}
