package com.mashell.one.module.read.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mashell.one.R;
import com.mashell.one.base.BaseActivity;
import com.mashell.one.common.OnItemClickListener;
import com.mashell.one.module.read.adapter.BannerAdapter;
import com.mashell.one.module.read.bean.ReadBannerDetail;
import com.mashell.one.module.read.contract.BannerDetailContract;
import com.mashell.one.module.read.presenter.BannerDetailPresenter;

import java.util.List;

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
    public static final String INTENT_ID ="intent_id";

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

    private BannerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        mLinearLayout.setBackgroundColor(Color.parseColor(getIntent().getStringExtra(INTENT_COLOR)));
        mDetailTitle.setText(getIntent().getStringExtra(INTENT_TITLE));
        mBottomText.setText(getIntent().getStringExtra(INTENT_BOTTOM_TXT));
        Glide.with(this).load(getIntent().getStringExtra(INTENT_URL)).into(mBottomImg);
        adapter = new BannerAdapter();
        mBannerRecyclerView.setLayoutManager(new LinearLayoutManager(this){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBannerRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(BannerDetailActivity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        mPresenter.getBannerDetail(getIntent().getStringExtra(INTENT_ID));
    }

    @Override
    public void setBannerDetailData(List<ReadBannerDetail> list) {
        adapter.setReadBannerDetails(list);
        adapter.notifyDataSetChanged();
    }

    public static Intent getInstance(Context context, String title, String bottomText, String bgColor, String url,String id){
        Intent intent = new Intent(context,BannerDetailActivity.class);
        intent.putExtra(INTENT_TITLE,title);
        intent.putExtra(INTENT_BOTTOM_TXT,bottomText);
        intent.putExtra(INTENT_URL,url);
        intent.putExtra(INTENT_COLOR,bgColor);
        intent.putExtra(INTENT_ID,id);
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
    public void finish() {
        super.finish();
        this.overridePendingTransition(0,R.anim.activity_close);
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
