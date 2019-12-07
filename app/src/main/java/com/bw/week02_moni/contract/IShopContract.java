package com.bw.week02_moni.contract;

import com.bw.week02_moni.base.IBaseModel;
import com.bw.week02_moni.base.IBaseView;

/**
 * 时间 :2019/12/7  8:44
 * 作者 :苗恒
 * 功能 :
 */
public interface IShopContract {
    interface IModel extends IBaseModel {
        void getListData(ModelCallBack modelCallBack);
        void getXBanerData(ModelCallBack modelCallBack);
        interface ModelCallBack{
            void success(Object data);
            void failue(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void success(Object data);
        void failue(Throwable throwable);
    }
    interface IPresenter{
        void getListData();
        void getXBanerData();
    }
}
