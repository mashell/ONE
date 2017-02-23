package com.mashell.one.module.read.presenter;

import com.mashell.one.module.main.bean.Comment;
import com.mashell.one.module.read.bean.EssayAndComment;
import com.mashell.one.module.read.bean.EssayDetail;
import com.mashell.one.module.read.contract.EssayContract;
import com.mashell.one.module.read.model.EssayModel;

import rx.Subscriber;

/**
 * Created by mashell on 16/12/21.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class EssayPresenter extends EssayContract.IEssayPresenter {

    public EssayPresenter(EssayContract.IEssayView view) {
        attachView(view);
        mModel = new EssayModel();
    }

    @Override
    public void getAllData(String id) {
        mModel.getAllData(id,"0")
                .compose(getView().<EssayAndComment>bind())
                .subscribe(new Subscriber<EssayAndComment>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(EssayAndComment essayAndComment) {
                        getView().setEssayDetail(essayAndComment.mEssayDetail);
                        getView().addCommentData(essayAndComment.mComment);
                    }
                });

    }

    @Override
    public void getEssayDetail(String id){
        mModel.getEssayDetail(id)
                .compose(getView().<EssayDetail>bind())
                .subscribe(new Subscriber<EssayDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(EssayDetail essayDetail) {
                        getView().setEssayDetail(essayDetail);
                    }
                });
    }

    @Override
    public void getCommentList(String id,String num) {
        mModel.getEssayComment(id,num)
                .compose(getView().<Comment>bind())
                .subscribe(new Subscriber<Comment>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Comment comment) {
                        getView().addCommentData(comment);
                    }
                });

    }
}
