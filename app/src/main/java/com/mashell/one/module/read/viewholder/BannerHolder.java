package com.mashell.one.module.read.viewholder;

import android.view.View;
import android.widget.TextView;

import com.mashell.one.R;
import com.mashell.one.base.BaseViewHolder;
import com.mashell.one.common.OnItemClickListener;
import com.mashell.one.module.read.bean.ReadBannerDetail;

import butterknife.BindView;

/**
 * Created by mashell on 16/12/19.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class BannerHolder extends BaseViewHolder {
    @BindView(R.id.itemTitle)
    TextView mItemTitle;
    @BindView(R.id.itemAuthor)
    TextView mItemAuthor;
    @BindView(R.id.itemDetail)
    TextView mItemDetail;

    public BannerHolder(View itemView, OnItemClickListener mOnItemClickListener) {
        super(itemView, mOnItemClickListener);
    }

    @Override
    public void bindData(Object o) {
        ReadBannerDetail data = (ReadBannerDetail) o;
        mItemTitle.setText((getAdapterPosition()+1)+" "+data.title);
        mItemAuthor.setText(data.author);
        mItemDetail.setText(data.introduction);
    }
}
