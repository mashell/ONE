package com.mashell.one.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mashell on 16/11/13.
 */

public abstract class BaseFragment extends Fragment {
    private View mContextView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContextView = inflater.inflate(bindLayout(),container,false);
        return mContextView;
    }

    /**
     * [绑定布局]
     *
     * @return
     */
    public abstract int bindLayout();


}
