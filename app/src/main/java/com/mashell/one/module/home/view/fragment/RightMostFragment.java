package com.mashell.one.module.home.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mashell.one.R;
import com.mashell.one.base.BaseFragment;
import com.mashell.one.base.BasePresenter;

/**
 * Created by mashell on 16/11/24.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class RightMostFragment extends BaseFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initView() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_right_most;
    }

    @Override
    public BasePresenter createMvpPresenter() {
        return null;
    }
}
