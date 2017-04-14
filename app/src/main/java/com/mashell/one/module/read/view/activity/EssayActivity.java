package com.mashell.one.module.read.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mashell.one.R;
import com.mashell.one.base.BaseActivity;
import com.mashell.one.common.CropCircleTransformation;
import com.mashell.one.component.LoadMoreRecyclerView;
import com.mashell.one.module.main.bean.Comment;
import com.mashell.one.module.read.adapter.EssayAdapter;
import com.mashell.one.module.read.bean.EssayDetail;
import com.mashell.one.module.read.contract.EssayContract;
import com.mashell.one.module.read.presenter.EssayPresenter;
import com.mashell.one.util.TimeUtil;
import com.mashell.one.util.ToastUtil;
import com.mashell.one.util.Utils;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;

/**
 * Created by mashell on 16/12/21.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class EssayActivity extends BaseActivity<EssayPresenter> implements EssayContract.IEssayView, LoadMoreRecyclerView.LoadMoreListener {
    public static String INTENT_ID = "intent_id";

    @BindView(R.id.back_bt)
    ImageView mBackBt;
    @BindView(R.id.author_avatar)
    ImageView mAuthorAvatar;
    @BindView(R.id.author_name)
    TextView mAuthorName;
    @BindView(R.id.author_time)
    TextView mAuthorTime;
    @BindView(R.id.essay_title)
    TextView mEssayTitle;
    @BindView(R.id.essay_content)
    TextView mEssayContent;
    @BindView(R.id.essay_author_introduce)
    TextView mEssayAuthorIntroduce;
    @BindView(R.id.author_introduce_avatar)
    ImageView mAuthorIntroduceAvatar;
    @BindView(R.id.author_introduce_name)
    TextView mAuthorIntroduceName;
    @BindView(R.id.author_introduce_it)
    TextView mAuthorIntroduceIt;
    @BindView(R.id.author_introduce_weibo)
    TextView mAuthorIntroduceWeibo;
    @BindView(R.id.comment_rv)
    LoadMoreRecyclerView mCommentRv;
    @BindView(R.id.likeText)
    TextView mLikeText;
    @BindView(R.id.likeContainer)
    RelativeLayout mLikeContainer;
    @BindView(R.id.commentText)
    TextView mCommentText;
    @BindView(R.id.shareText)
    TextView mShareText;
    @BindView(R.id.shareContainer)
    RelativeLayout mShareContainer;

    private EssayAdapter mEssayAdapter;
    private String id;
    private int currentPage = 1;

    @Override
    public void initView() {
        id = getIntent().getStringExtra(INTENT_ID);
        mEssayAdapter = new EssayAdapter();
        mCommentRv.setLayoutManager(new LinearLayoutManager(this));
        mCommentRv.setNestedScrollingEnabled(false);
        mCommentRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mCommentRv.setPAGE_SIZE(28);
        mCommentRv.setLoadMoreListener(this);
        mCommentRv.setAdapter(mEssayAdapter);
        mPresenter.getAllData(id);
    }

    @Override
    public void addCommentData(Comment comment) {
        if (currentPage == 1)
        {
            //clear数组
        }
        //mEssayAdapter.setCommentItems(comment.data);

        mEssayAdapter.addData(comment.data);
        mCommentRv.notifyDataChange(currentPage, comment.count);
        currentPage++;
    }

    @Override
    public void setEssayDetail(EssayDetail essayDetail) {
        mAuthorName.setText(Utils.safeText(essayDetail.hpAuthor));
        mAuthorTime.setText(TimeUtil.formatTimeShort(essayDetail.hpMakettime));
        mEssayTitle.setText(Utils.safeText(essayDetail.hpTitle));
        mEssayContent.setText(Html.fromHtml(essayDetail.hpContent));
        mEssayAuthorIntroduce.setText(essayDetail.hpAuthorIntroduce);
        mAuthorIntroduceName.setText(Utils.safeText(essayDetail.author.get(0).userName));
        mAuthorIntroduceIt.setText(essayDetail.author.get(0).desc);
        mAuthorIntroduceWeibo.setText(Utils.safeText("weibo: " + essayDetail.author.get(0).wbName));

        Glide.with(this).load(essayDetail.author.get(0).webUrl)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(mAuthorAvatar);

        Glide.with(this).load(essayDetail.author.get(0).webUrl)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(mAuthorIntroduceAvatar);

        mLikeText.setText(Utils.safeText(essayDetail.praisenum));
        mShareText.setText(Utils.safeText(essayDetail.sharenum));
        mCommentText.setText(Utils.safeText(essayDetail.commentnum));
    }

    public static Intent getIntent(Context context, String id) {
        Intent intent = new Intent(context, EssayActivity.class);
        intent.putExtra(INTENT_ID, id);
        return intent;
    }

    @Override
    public void onLoadMore() {
        Log.e("一个", "加载更多");
        mPresenter.getCommentList(id, "2");
        //mPresenter.getCommentList(id, mEssayAdapter.getCommentItems().get(mEssayAdapter.getItemCount()).id);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_essay;
    }

    @Override
    public EssayPresenter createPresenter() {
        return new EssayPresenter(this);
    }

    @Override
    public <V> Observable.Transformer<V, V> bind() {
        return this.bindToLifecycle();
    }

    @OnClick({R.id.likeContainer, R.id.shareContainer, R.id.back_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.likeContainer:
                ToastUtil.show("点赞~");
                break;
            case R.id.shareContainer:
                ToastUtil.show("分享~");
                break;
            case R.id.back_bt:
                this.finish();
        }
    }
}
