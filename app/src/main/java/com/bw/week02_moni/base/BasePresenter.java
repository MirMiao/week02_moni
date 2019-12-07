package com.bw.week02_moni.base;

import java.lang.ref.WeakReference;

/**
 * 时间 :2019/12/7  8:37
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    public WeakReference<V> weakReference;
    public BasePresenter(){
        model=initModel();
    }
    public void attachView(V v){
        weakReference=new WeakReference<>(v);
    }

    protected abstract M initModel();
    public void disAttach(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    public   V getView(){
        return weakReference.get();
    }
}
