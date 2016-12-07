package com.mashell.one.module.home.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mashell.one.R;
import com.mashell.one.base.BaseViewHolder;
import com.mashell.one.common.OnItemClickListener;
import com.mashell.one.module.home.bean.OneMonth;
import com.mashell.one.util.TimeUtil;
import com.mashell.one.util.Utils;

import butterknife.BindView;

/**
 * Created by mashell on 16/12/6.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class OneMonthViewHolder extends BaseViewHolder<OneMonth> {
    @BindView(R.id.oneMonthImg)
    ImageView oneMonthImg;
    @BindView(R.id.itemHpTitle)
    TextView itemHpTitle;
    @BindView(R.id.itemMakeTime)
    TextView itemMakeTime;
    @BindView(R.id.hp_content)
    TextView itemHpContent;

    public OneMonthViewHolder(View itemView, OnItemClickListener onItemClickListener) {
        super(itemView,onItemClickListener);
    }

    @Override
    public void bindData(OneMonth oneMonth) {
        itemHpTitle.setText(Utils.safeText(oneMonth.hpTitle));
        itemMakeTime.setText(TimeUtil.formatTimeShort(Utils.safeText(oneMonth.hpMakettime)));
        itemHpContent.setText(Utils.safeText(oneMonth.hpContent));
        Glide.with(getContext()).load(oneMonth.hpImgUrl).into(oneMonthImg);
    }
}
