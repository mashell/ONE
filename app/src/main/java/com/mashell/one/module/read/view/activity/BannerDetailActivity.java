package com.mashell.one.module.read.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mashell.one.R;
import com.mashell.one.base.BaseActivity;
import com.mashell.one.module.read.contract.BannerDetailContract;
import com.mashell.one.module.read.presenter.BannerDetailPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;

/**
 * Created by mashell on 16/12/14.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class BannerDetailActivity extends BaseActivity<BannerDetailPresenter> implements BannerDetailContract.IBannerDetailView {

    public static final String INTENT_TITLE ="intent_title";
    public static final String INTENT_BOTTOM_TXT ="intent_bottom_txt";
    public static final String INTENT_URL ="intent_url";
    public static final String INTENT_COLOR ="intent_color";

    @BindView(R.id.mainContainer)
    LinearLayout mLinearLayout;
    @BindView(R.id.bannerDetailImg)
    ImageView mBottomImg;
    @BindView(R.id.detailTitle)
    TextView mDetailTitle;
    @BindView(R.id.bottomText)
    TextView mBottomText;
    @BindView(R.id.closeButton)
    ImageView closeButton;
    @BindView(R.id.bannerDetailRecycler)
    RecyclerView mBannerRecyclerView;


    @Override
    public void initView() {
        mLinearLayout.setBackgroundColor(Color.parseColor(getIntent().getStringExtra(INTENT_COLOR)));
        mDetailTitle.setText(getIntent().getStringExtra(INTENT_TITLE));
        mBottomText.setText(getIntent().getStringExtra(INTENT_BOTTOM_TXT));
        Glide.with(this).load(getIntent().getStringExtra(INTENT_URL)).into(mBottomImg);

    }

    public static Intent getInstance(Context context, String title, String bottomText, String bgColor, String url){
        Intent intent = new Intent(context,BannerDetailActivity.class);
        intent.putExtra("INTENT_TITLE",title);
        intent.putExtra("INTENT_BOTTOM_TXT",bottomText);
        intent.putExtra("INTENT_URL",url);
        intent.putExtra("INTENT_COLOR",bgColor);
        return intent;
    }

    @OnClick(R.id.closeButton)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.closeButton:
                finish();
                break;
        }
    }

    @Override
    public BannerDetailPresenter createPresenter() {
        return new BannerDetailPresenter(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_banner_detail;
    }

    @Override
    public <V> Observable.Transformer<V, V> bind() {
        return this.bindToLifecycle();
    }
}
