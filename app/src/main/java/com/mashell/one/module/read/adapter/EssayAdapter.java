package com.mashell.one.module.read.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mashell.one.module.main.bean.CommentItem;
import com.mashell.one.module.read.viewholder.EssayViewHolder;

import java.util.List;

/**
 * Created by mashell on 17/2/22.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class EssayAdapter extends RecyclerView.Adapter<EssayViewHolder>{
    private List<CommentItem> mCommentItems;
    //数据总共有多少条
    private int size;

    public void setCommentItems(List<CommentItem> mCommentItems){
        this.mCommentItems = mCommentItems;
    }

    public List<CommentItem> getCommentItems() {
        return mCommentItems;
    }

    public void addData(List<CommentItem> mCommentItems){
        this.mCommentItems.addAll(mCommentItems);
    }

    @Override
    public EssayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EssayViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(EssayViewHolder holder, int position) {
        holder.bindData(mCommentItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mCommentItems == null ? 0 : mCommentItems.size();
    }
}
