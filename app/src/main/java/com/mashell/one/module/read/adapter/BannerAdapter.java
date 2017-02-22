package com.mashell.one.module.read.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mashell.one.R;
import com.mashell.one.common.OnItemClickListener;
import com.mashell.one.module.read.bean.ReadBannerDetail;
import com.mashell.one.module.read.viewholder.BannerHolder;

import java.util.List;

/**
 * Created by mashell on 16/12/19.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class BannerAdapter extends RecyclerView.Adapter<BannerHolder> {

    private List<ReadBannerDetail> mReadBannerDetails;

    private OnItemClickListener mOnItemClickListener;

    public void setReadBannerDetails(List<ReadBannerDetail> readBannerDetails) {
        mReadBannerDetails = readBannerDetails;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public BannerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BannerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner_detail,parent,false),
                mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(BannerHolder holder, int position) {
        holder.bindData(mReadBannerDetails.get(position));
    }

    @Override
    public int getItemCount() {
        return mReadBannerDetails == null ? 0 :mReadBannerDetails.size();
    }

}
