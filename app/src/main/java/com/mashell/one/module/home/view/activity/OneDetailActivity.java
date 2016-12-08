package com.mashell.one.module.home.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.mashell.one.R;
import com.mashell.one.base.BaseActivity;
import com.mashell.one.base.BasePresenter;
import com.mashell.one.module.home.view.fragment.InnerHomeFragment;

/**
 * Created by mashell on 16/12/8.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class OneDetailActivity extends BaseActivity {
    @Override
    public void initView() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        InnerHomeFragment innerHomeFragment = (InnerHomeFragment) InnerHomeFragment.getInstance(getIntent().getStringExtra("intentId"));
        transaction.replace(R.id.fragmentContainer,innerHomeFragment);
        transaction.commit();
    }

    public static Intent getIntent(Context context,String id){
        Intent intent = new Intent(context, OneDetailActivity.class);
        intent.putExtra("intentId",id);
        return intent;
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_one_detail;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
