package com.mashell.one.module.read.model;

import com.mashell.one.base.BaseResult;
import com.mashell.one.common.RetrofitInstance;
import com.mashell.one.module.main.bean.Comment;
import com.mashell.one.module.read.bean.EssayAndComment;
import com.mashell.one.module.read.bean.EssayDetail;
import com.mashell.one.module.read.contract.EssayContract;
import com.mashell.one.util.RxUtils;

import rx.Observable;
import rx.functions.Func2;

/**
 * Created by mashell on 16/12/21.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class EssayModel implements EssayContract.IEssayModel {

    @Override
    public Observable<EssayAndComment> getAllData(String id, String num) {
        Observable<Comment> commentObservable = getEssayComment(id, "0");
        Observable<EssayDetail> essayDetailObservable = getEssayDetail(id);
        return Observable.zip(commentObservable, essayDetailObservable, new Func2<Comment, EssayDetail, EssayAndComment>() {
            @Override
            public EssayAndComment call(Comment comment, EssayDetail essayDetail) {
                return new EssayAndComment(comment,essayDetail);
            }
        });
    }

    @Override
    public Observable<Comment> getEssayComment(String id, String num) {
        return RetrofitInstance.getApiInterface().getComment("essay", id, num)
               .compose(RxUtils.<BaseResult<Comment>>defaultSchedulers())
                .compose(RxUtils.<Comment>handleResult());
    }

    @Override
    public Observable<EssayDetail> getEssayDetail(String id) {
        return RetrofitInstance.getApiInterface().getEssayDetail(id)
                .compose(RxUtils.<BaseResult<EssayDetail>>defaultSchedulers())
                .compose(RxUtils.<EssayDetail>handleResult());
    }
}
