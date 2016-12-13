package com.mashell.one.module.read.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mashell.one.C;
import com.mashell.one.R;
import com.mashell.one.base.BaseFragment;
import com.mashell.one.base.FragmentAdapter;
import com.mashell.one.component.GlideImageLoader;
import com.mashell.one.module.home.view.activity.EarlyListActivity;
import com.mashell.one.module.home.view.fragment.LeftMostFragment;
import com.mashell.one.module.home.view.fragment.RightMostFragment;
import com.mashell.one.module.read.bean.ReadArticleList;
import com.mashell.one.module.read.contract.ReadContract;
import com.mashell.one.module.read.presenter.ReadPresenter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;

/**
 * Created by mashell on 16/11/14.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class ReadFragment extends BaseFragment<ReadPresenter> implements ReadContract.IReadView {
    @BindView(R.id.readBanner)
    Banner mBanner;
    @BindView(R.id.readViewPager)
    ViewPager mViewPager;

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
        mPresenter.getBanner();
        mPresenter.getReadContent();
    }

    @Override
    public void initBannerData(List<String> bannerData) {
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setImages(bannerData);
        mBanner.start();
    }

    @Override
    public void initReadContent(ReadArticleList articleList) {
        LeftMostFragment leftMostFragment = new LeftMostFragment();
        RightMostFragment rightMostFragment = new RightMostFragment();

        final List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(leftMostFragment);

        for (int i = 0; i < articleList.essay.size(); i++) {
            fragmentList.add(InnerReadFragment.getInstance(articleList.essay.get(i),articleList.serial.get(i),articleList.question.get(i)));
        }
        fragmentList.add(rightMostFragment);
        FragmentAdapter adapter = new FragmentAdapter(getChildFragmentManager(), fragmentList);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(1);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mViewPager.setCurrentItem(position + 1);
                    mPresenter.getReadContent();
                    Toast.makeText(getActivity(),"正在刷新",Toast.LENGTH_SHORT).show();
                } else if (position == fragmentList.size() - 1) {
                    mViewPager.setCurrentItem(position - 1);
                    getContext().startActivity(EarlyListActivity.getInstance(getContext(), C.TYPE_ONE));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
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
