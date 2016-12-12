package com.mashell.one.base;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by mashell on 16/11/27.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public abstract class BasePresenter<V,M> {
    protected Reference<V> mViewRef;
    protected M mModel;

    //建立关联
    public void attachView(V view) {
        mViewRef = new WeakReference<>(view);
    }

    //获取view
    protected V getView() {
        return mViewRef.get();
    }

    //判断是否与View建立了关联
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    //该方法在activity或者Fragment的onDestory中调用
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}