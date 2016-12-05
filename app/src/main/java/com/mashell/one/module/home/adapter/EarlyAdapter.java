package com.mashell.one.module.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mashell.one.R;
import com.mashell.one.common.OnItemClickListener;
import com.mashell.one.module.home.viewholder.EarlyViewHolder;
import com.mashell.one.module.main.model.Month;

import java.util.List;

/**
 * Created by mashell on 16/11/30.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class EarlyAdapter extends RecyclerView.Adapter<EarlyViewHolder> {

    private List<Month> datas;

    public EarlyAdapter(List<Month> datas) {
        this.datas = datas;
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public EarlyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_early_list,parent,false);
        return new EarlyViewHolder(itemView, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(EarlyViewHolder holder, int position) {
        holder.bindData(datas.get(position));
    }


    public String getEarlyListValue(int position) {
        return datas.get(position).monthValue;
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

}
