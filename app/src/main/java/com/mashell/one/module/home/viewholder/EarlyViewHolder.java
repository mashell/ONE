package com.mashell.one.module.home.viewholder;

import android.view.View;
import android.widget.TextView;

import com.mashell.one.R;
import com.mashell.one.base.BaseViewHolder;
import com.mashell.one.common.OnItemClickListener;
import com.mashell.one.module.main.bean.Month;

import butterknife.BindView;

/**
 * Created by mashell on 16/11/30.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class EarlyViewHolder extends BaseViewHolder<Month> {
    @BindView(R.id.early_date_txt)
    TextView dateTxt;

    public EarlyViewHolder(View view, OnItemClickListener mOnItemClickListener) {
        super(view,mOnItemClickListener);
    }


    public void bindData(Month s) {
        dateTxt.setText(s.monthKey);
    }
}
