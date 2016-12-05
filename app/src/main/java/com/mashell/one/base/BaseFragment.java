package com.mashell.one.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


/**
 * Created by mashell on 16/11/13.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public abstract class BaseFragment<P extends BasePresenter> extends com.trello.rxlifecycle.components.support.RxFragment {
    private View mContextView = null;
    private String TAG = this.getClass().getSimpleName();
    protected P mvpPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContextView = inflater.inflate(bindLayout(), container, false);
        ButterKnife.bind(this, mContextView);
        mvpPresenter = createMvpPresenter();
        initView();
        return mContextView;
    }

    public abstract P createMvpPresenter();

    @Override
    public void onDetach() {
        super.onDetach();
        if (mvpPresenter != null)
            mvpPresenter.detachView();
    }

    /**
     * [初始化控件]
     */
    public abstract void initView();


    /**
     * [绑定布局]
     */
    public abstract int bindLayout();

    /**
     * [获取view]
     */

    public View getView() {
        return mContextView;
    }


}
