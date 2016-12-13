package com.mashell.one.module.read.view.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.mashell.one.R;
import com.mashell.one.base.BaseFragment;
import com.mashell.one.module.read.bean.EssayItem;
import com.mashell.one.module.read.bean.QuestionItem;
import com.mashell.one.module.read.bean.SerialItem;
import com.mashell.one.module.read.contract.InnerReadContract;
import com.mashell.one.module.read.presenter.InnerReadPresenter;

import butterknife.BindView;
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

    public static InnerReadFragment getInstance(EssayItem essayItem, SerialItem serialItem, QuestionItem questionItem){
        InnerReadFragment innerReadFragment = new InnerReadFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ESSAY_ITEM,essayItem);
        bundle.putSerializable(SERIAL_ITEM,serialItem);
        bundle.putSerializable(QUESTION_ITEM,questionItem);
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
}
