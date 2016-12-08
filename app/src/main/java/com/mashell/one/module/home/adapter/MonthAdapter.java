package com.mashell.one.module.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mashell.one.R;
import com.mashell.one.base.BaseViewHolder;
import com.mashell.one.common.OnItemClickListener;
import com.mashell.one.module.home.viewholder.OneMonthViewHolder;

import java.util.List;

/**
 * Created by mashell on 16/12/6.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class MonthAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private OnItemClickListener mOnItemClickListener;
    private List<T> datas;
    private int type;
    private String month;

    public MonthAdapter(List<T> datas, int type, String month) {
        this.datas = datas;
        this.type = type;
        this.month = month;
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public T getDatas(int position){
        return datas.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new OneMonthViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_one_month, parent, false), mOnItemClickListener);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder) holder).bindData(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }
}
