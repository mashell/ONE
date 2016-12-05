package com.mashell.one.module.home.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mashell.one.C;
import com.mashell.one.R;
import com.mashell.one.base.BaseActivity;
import com.mashell.one.common.OnItemClickListener;
import com.mashell.one.module.home.adapter.EarlyAdapter;
import com.mashell.one.module.home.contract.EarlyListContract;
import com.mashell.one.module.home.presenter.EarlyListPresenter;
import com.mashell.one.util.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;

/**
 * Created by mashell on 16/11/28.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class EarlyListActivity extends BaseActivity<EarlyListPresenter> implements EarlyListContract.IEarlyListView {
    @Nullable
    @BindView(R.id.earlyRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tabEssay)
    TextView tabEssay;
    @BindView(R.id.tabSerial)
    TextView tabSerial;
    @BindView(R.id.tabQuestion)
    TextView tabQuestion;
    @BindView(R.id.tabContainer)
    LinearLayout tabContainer;

    private int intentType;
    private int currentTab;

    @Override
    public void initView() {
        intentType = getIntent().getIntExtra("intentType", 0);
        setIntentStatus(intentType);
        final EarlyAdapter adapter = new EarlyAdapter(mvpPresenter.getEarlyMonth(intentType));
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                ToastUtil.show(adapter.getEarlyListValue(position));
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void setIntentStatus(int index) {
        if (index == C.TYPE_TAB_ESSAY)
            tabContainer.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.tabQuestion,R.id.tabEssay,R.id.tabSerial})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tabEssay:
                setTabStatus(C.TYPE_TAB_ESSAY);
                break;

            case R.id.tabSerial:
                setTabStatus(C.TYPE_TAB_SERIAL);
                break;

            case R.id.tabQuestion:
                setTabStatus(C.TYPE_TAB_QUESTION);
                break;
        }
    }

    @Override
    public void setTabStatus(int index) {
        recoveryTabStatus(currentTab);
        changeTabStatus(index);
        switch (index) {
            case C.TYPE_TAB_ESSAY:

                break;

            case C.TYPE_TAB_SERIAL:

                break;

            case C.TYPE_TAB_QUESTION:

                break;
        }
    }

    @Override
    public void recoveryTabStatus(int index) {
        switch (index) {
            case C.TYPE_TAB_ESSAY:
                tabEssay.setTextColor(ContextCompat.getColor(this,R.color.tab_unselect));
                break;

            case C.TYPE_TAB_SERIAL:
                tabSerial.setTextColor(ContextCompat.getColor(this,R.color.tab_unselect));
                break;

            case C.TYPE_TAB_QUESTION:
                tabQuestion.setTextColor(ContextCompat.getColor(this,R.color.tab_unselect));
                break;
        }
    }

    @Override
    public void changeTabStatus(int index) {
        switch (index) {
            case C.TYPE_TAB_ESSAY:
                tabEssay.setTextColor(ContextCompat.getColor(this,R.color.tab_selected));
                currentTab = C.TYPE_TAB_ESSAY;
                break;

            case C.TYPE_TAB_SERIAL:
                currentTab = C.TYPE_TAB_SERIAL;
                tabSerial.setTextColor(ContextCompat.getColor(this,R.color.tab_unselect));
                break;

            case C.TYPE_TAB_QUESTION:
                currentTab = C.TYPE_TAB_QUESTION;
                tabQuestion.setTextColor(ContextCompat.getColor(this,R.color.tab_unselect));
                break;
        }
    }

    @Override
    public EarlyListPresenter createPresenter() {
        return new EarlyListPresenter(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_early_list;
    }

    @Override
    public <V> Observable.Transformer<V, V> bind() {
        return null;
    }

    public static Intent getInstance(Context context, int intentType) {
        Intent intent = new Intent(context, EarlyListActivity.class);
        intent.putExtra("intentType", intentType);
        return intent;
    }
}
