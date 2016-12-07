package com.mashell.one.module.home.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mashell.one.R;
import com.mashell.one.base.BaseFragment;
import com.mashell.one.module.home.bean.OneDetail;
import com.mashell.one.module.home.contract.InnerHomeContract;
import com.mashell.one.module.home.presenter.IInnerHomePresenter;
import com.mashell.one.util.TimeUtil;
import com.mashell.one.util.Utils;

import butterknife.BindView;
import rx.Observable;

/**
 * Created by mashell on 16/11/24.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class InnerHomeFragment extends BaseFragment<InnerHomeContract.IInnerPresenter> implements InnerHomeContract.IInnerView{
    @BindView(R.id.home_Img)
    ImageView homeImg;
    @BindView(R.id.home_hp_title_txt)
    TextView homeTitle;
    @BindView(R.id.home_hp_author_txt)
    TextView homeAuthor;
    @BindView(R.id.home_hp_content_txt)
    TextView homeContent;
    @BindView(R.id.home_time_txt)
    TextView homeTime;
    @BindView(R.id.laud_num_txt)
    TextView homeNum;

    public static String INTENT_KEY = "innerId";


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
        String oneId = getArguments().getString(INTENT_KEY);
        mvpPresenter.getOneDetail(oneId);
    }


    @Override
    public int bindLayout() {
        return R.layout.fragment_innner_home;
    }

    @Override
    public <V> Observable.Transformer<V, V> bind() {
        return this.bindToLifecycle();
    }

    public static Fragment getInstance(String id) {
        InnerHomeFragment innerHomeFragment = new InnerHomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(INTENT_KEY,id);
        innerHomeFragment.setArguments(bundle);
        return innerHomeFragment;
    }

    @Override
    public void getOneDetailData(OneDetail detail) {
        homeTitle.setText(detail.hpTitle);
        homeAuthor.setText(detail.hpAuthor);
        homeContent.setText(detail.hpContent);
        homeTime.setText(TimeUtil.formatTimeLong(detail.hpMakettime));
        homeNum.setText(Utils.safeText(detail.praisenum));
        Glide.with(this).load(detail.hpImgUrl).placeholder(R.mipmap.default_hp_image).into(homeImg);
    }

    @Override
    public InnerHomeContract.IInnerPresenter createMvpPresenter() {
        return new IInnerHomePresenter(this);
    }
}
