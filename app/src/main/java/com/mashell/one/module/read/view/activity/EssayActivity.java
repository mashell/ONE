package com.mashell.one.module.read.view.activity;

import com.mashell.one.R;
import com.mashell.one.base.BaseActivity;
import com.mashell.one.module.read.contract.EssayContract;
import com.mashell.one.module.read.presenter.EssayPresenter;

import rx.Observable;

/**
 * Created by mashell on 16/12/21.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class EssayActivity extends BaseActivity<EssayPresenter> implements EssayContract.IEssayView{

    @Override
    public void initView() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_essay;
    }

    @Override
    public EssayPresenter createPresenter() {
        return new EssayPresenter(this);
    }

    @Override
    public <V> Observable.Transformer<V, V> bind() {
        return this.bindToLifecycle();
    }
}
