package com.mashell.one.module.home.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mashell.one.R;
import com.mashell.one.base.BaseFragment;

import rx.functions.Func1;

/**
 * Created by mashell on 16/11/14.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class HomeFragment extends BaseFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private Func1<String,String> mFunc1 = new Func1<String, String>() {
        @Override
        public String call(String s) {
            return s+"拼接的";
        }
    };

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }
}
