package com.mashell.one.module.home.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.mashell.one.C;
import com.mashell.one.R;
import com.mashell.one.base.BaseFragment;
import com.mashell.one.base.FragmentAdapter;
import com.mashell.one.module.home.contract.HomeContract;
import com.mashell.one.module.home.presenter.HomePresenter;
import com.mashell.one.module.home.view.activity.EarlyListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observable;

/**
 * Created by mashell on 16/11/14.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class HomeFragment extends BaseFragment<HomeContract.IHomePresenter> implements HomeContract.IHomeView {
    @BindView(R.id.fragmentViewPager)
    ViewPager fragmentViewPager;

    @Override
    public void initListFragment(List<String> idList) {
        LeftMostFragment leftMostFragment = new LeftMostFragment();
        RightMostFragment rightMostFragment = new RightMostFragment();

        final List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(leftMostFragment);

        for (int i = 0; i < idList.size(); i++) {
            fragmentList.add(InnerHomeFragment.getInstance(idList.get(i)));
        }
        fragmentList.add(rightMostFragment);
        FragmentAdapter adapter = new FragmentAdapter(getChildFragmentManager(), fragmentList);
        fragmentViewPager.setAdapter(adapter);
        fragmentViewPager.setCurrentItem(1);
        fragmentViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    fragmentViewPager.setCurrentItem(position + 1);
                    mPresenter.getIdList();
                    Toast.makeText(getActivity(),"正在刷新",Toast.LENGTH_SHORT).show();
                } else if (position == fragmentList.size() - 1) {
                    fragmentViewPager.setCurrentItem(position - 1);
                    getContext().startActivity(EarlyListActivity.getInstance(getContext(), C.TYPE_ONE));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initView() {
        mPresenter.getIdList();
    }

    @Override
    public <V> Observable.Transformer<V, V> bind() {
        return this.bindToLifecycle();
    }

    @Override
    public HomeContract.IHomePresenter createMvpPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

}
