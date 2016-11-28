package com.mashell.one.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
        Log.e("mashell", TAG + "-------onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContextView = inflater.inflate(bindLayout(), container, false);
        ButterKnife.bind(this, mContextView);
        mvpPresenter = createMvpPresenter();
        initView();
        Log.e("mashell", TAG + "-------onCreateView");
        return mContextView;
    }

    public abstract P createMvpPresenter();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.e("mashell", TAG + "-------onAttach");

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("mashell", TAG + "-------onViewCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("mashell", TAG + "-------onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("mashell", TAG + "-------onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("mashell", TAG + "-------onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("mashell", TAG + "-------onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("mashell", TAG + "-------onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null)
            mvpPresenter.detachView();
        Log.e("mashell", TAG + "-------onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("mashell", TAG + "-------onDetach");

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
