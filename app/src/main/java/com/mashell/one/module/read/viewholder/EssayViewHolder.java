package com.mashell.one.module.read.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mashell.one.R;
import com.mashell.one.base.BaseViewHolder;
import com.mashell.one.common.CropCircleTransformation;
import com.mashell.one.module.main.bean.CommentItem;
import com.mashell.one.util.TimeUtil;
import com.mashell.one.util.Utils;

import butterknife.BindView;

/**
 * Created by mashell on 17/2/22.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class EssayViewHolder extends BaseViewHolder {

    @BindView(R.id.comment_avatar)
    ImageView mCommentAvatar;
    @BindView(R.id.comment_name)
    TextView mCommentName;
    @BindView(R.id.comment_time)
    TextView mCommentTime;
    @BindView(R.id.comment_like)
    TextView mCommentLike;
    @BindView(R.id.comment_content)
    TextView mCommentContent;
    @BindView(R.id.usered_name)
    TextView mUseredName;
    @BindView(R.id.userd_content)
    TextView mUserdContent;
    @BindView(R.id.commented)
    LinearLayout mCommented;

    public EssayViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_comment);
    }

    @Override
    public void bindData(Object o) {
        CommentItem item = (CommentItem) o;

        mCommentName.setText(Utils.safeText(item.user.userName));
        mCommentTime.setText(TimeUtil.formatTimeShort(item.inputDate));
        mCommentLike.setText(Utils.safeText(item.praisenum));

        if (!"".equals(item.quote)) {
            mCommented.setVisibility(View.VISIBLE);
            mUseredName.setText(Utils.safeText(item.touser.userName) + ": ");
            mUserdContent.setText(Utils.safeText(item.quote));
        }

        mCommentContent.setText(Utils.safeText(item.content));

        Glide.with(getContext()).load(item.user.webUrl)
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(mCommentAvatar);
    }
}
