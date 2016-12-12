package com.mashell.one.module.read.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mashell.one.R;
import com.mashell.one.base.BaseFragment;
import com.mashell.one.component.GlideImageLoader;
import com.mashell.one.module.read.contract.ReadContract;
import com.mashell.one.module.read.presenter.ReadPresenter;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;
import rx.Observable;

import static com.mashell.one.R.id.readBanner;

/**
 * Created by mashell on 16/11/14.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class ReadFragment extends BaseFragment<ReadPresenter> implements ReadContract.IReadView {
    @BindView(readBanner)
    Banner mBanner;

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
    public int bindLayout() {
        return R.layout.fragment_read;
    }

    @Override
    public void initView() {
        mvpPresenter.getBanner();
    }

    @Override
    public void initBannerData(List<String> bannerData) {
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setImages(bannerData);
        mBanner.start();
    }

    @Override
    public ReadPresenter createMvpPresenter() {
        return new ReadPresenter(this);
    }

    @Override
    public <V> Observable.Transformer<V, V> bind() {
        return this.bindToLifecycle();
    }
}
