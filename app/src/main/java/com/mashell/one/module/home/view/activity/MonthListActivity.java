package com.mashell.one.module.home.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mashell.one.R;
import com.mashell.one.base.BaseActivity;
import com.mashell.one.component.SpaceItemDecoration;
import com.mashell.one.module.home.adapter.MonthAdapter;
import com.mashell.one.module.home.contract.MonthContract;
import com.mashell.one.module.home.presenter.MonthPresenter;
import com.mashell.one.module.main.bean.Month;
import com.mashell.one.util.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;

/**
 * Created by mashell on 16/12/5.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class MonthListActivity<T> extends BaseActivity<MonthPresenter> implements MonthContract.IMonthView<T>{
    @BindView(R.id.backButton)
    ImageView backButton;
    @BindView(R.id.monthTitle)
    TextView monthTitle;
    @BindView(R.id.monthRecyclerView)
    RecyclerView mRecyclerView;
    private MonthAdapter<T> adapter;
    private List<T> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        int intentType= getIntent().getIntExtra("intentType",0);
        Month month = (Month) getIntent().getSerializableExtra("intentTitle");
        datas = new ArrayList<>();
        monthTitle.setText(Utils.safeText(month.monthKey));
        adapter = new MonthAdapter<>(datas,intentType, month.monthValue);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(8));
        mRecyclerView.setAdapter(adapter);
        mvpPresenter.getOneList(month.monthValue,intentType);
    }

    @OnClick(R.id.backButton)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.backButton:
                finish();
                break;
        }
    }

    @Override
    public void setAdapterData(List<T> data) {
        adapter.setDatas(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public <V> Observable.Transformer<V, V> bind() {
        return this.bindToLifecycle();
    }

    @Override
    public MonthPresenter createPresenter() {
        return new MonthPresenter(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_month_list;
    }

    public static Intent getIntent(Context context,int type,Month month){
        Intent intent = new Intent(context,MonthListActivity.class);
        intent.putExtra("intentType",type);
        intent.putExtra("intentTitle",month);
        return intent;
    }
}
