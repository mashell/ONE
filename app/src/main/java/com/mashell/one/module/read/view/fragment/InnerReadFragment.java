package com.mashell.one.module.read.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mashell.one.R;
import com.mashell.one.base.BaseFragment;
import com.mashell.one.module.read.bean.EssayItem;
import com.mashell.one.module.read.bean.QuestionItem;
import com.mashell.one.module.read.bean.SerialItem;
import com.mashell.one.module.read.contract.InnerReadContract;
import com.mashell.one.module.read.presenter.InnerReadPresenter;
import com.mashell.one.module.read.view.activity.EssayActivity;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;

/**
 * Created by mashell on 16/12/12.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class InnerReadFragment extends BaseFragment<InnerReadPresenter> implements InnerReadContract.IInnerReadView {

    public static final String ESSAY_ITEM = "essay_item";
    public static final String SERIAL_ITEM = "serial_item";
    public static final String QUESTION_ITEM = "question_item";
    @BindView(R.id.essay_layout)
    RelativeLayout mEssayLayout;
    @BindView(R.id.serial_layout)
    RelativeLayout mSerialLayout;
    @BindView(R.id.question_layout)
    RelativeLayout mQuestionLayout;

    private EssayItem mEssayItem;
    private SerialItem mSerialItem;
    private QuestionItem mQuestionItem;

    @BindView(R.id.essayTitle)
    TextView essayTitle;
    @BindView(R.id.essayAuthor)
    TextView essayAuthor;
    @BindView(R.id.essayWord)
    TextView essayWord;
    @BindView(R.id.serialTitle)
    TextView serialTitle;
    @BindView(R.id.serialAuthor)
    TextView serialAuthor;
    @BindView(R.id.serialWord)
    TextView serialWord;
    @BindView(R.id.questionTitle)
    TextView questionTitle;
    @BindView(R.id.questionAuthor)
    TextView questionAuthor;
    @BindView(R.id.questionWord)
    TextView questionWord;

    @Override
    public void initView() {
        mEssayItem = (EssayItem) getArguments().getSerializable(ESSAY_ITEM);
        mSerialItem = (SerialItem) getArguments().getSerializable(SERIAL_ITEM);
        mQuestionItem = (QuestionItem) getArguments().getSerializable(QUESTION_ITEM);
        initData();
    }

    @Override
    public void initData() {
        essayTitle.setText(mEssayItem.hpTitle);
        essayAuthor.setText(mEssayItem.author.get(0).userName);
        essayWord.setText(mEssayItem.guideWord);
        serialTitle.setText(mSerialItem.title);
        serialWord.setText(mSerialItem.excerpt);
        serialAuthor.setText(mSerialItem.author.userName);
        questionTitle.setText(mQuestionItem.questionTitle);
        questionWord.setText(mQuestionItem.answerContent);
        questionAuthor.setText(mQuestionItem.answerTitle);
    }

    public static InnerReadFragment getInstance(EssayItem essayItem, SerialItem serialItem, QuestionItem questionItem) {
        InnerReadFragment innerReadFragment = new InnerReadFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ESSAY_ITEM, essayItem);
        bundle.putSerializable(SERIAL_ITEM, serialItem);
        bundle.putSerializable(QUESTION_ITEM, questionItem);
        innerReadFragment.setArguments(bundle);
        return innerReadFragment;
    }

    @Override
    public InnerReadPresenter createMvpPresenter() {
        return new InnerReadPresenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_inner_read;
    }

    @Override
    public <V> Observable.Transformer<V, V> bind() {
        return this.bindToLifecycle();
    }

    @OnClick({R.id.essay_layout, R.id.serial_layout, R.id.question_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.essay_layout:
                getContext().startActivity(EssayActivity.getIntent(getContext(),mEssayItem.contentId));
                break;
            case R.id.serial_layout:
                break;
            case R.id.question_layout:
                break;
        }
    }
}
