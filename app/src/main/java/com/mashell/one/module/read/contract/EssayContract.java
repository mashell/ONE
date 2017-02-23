package com.mashell.one.module.read.contract;

import com.mashell.one.base.BaseModel;
import com.mashell.one.base.BasePresenter;
import com.mashell.one.base.BaseView;
import com.mashell.one.module.main.bean.Comment;
import com.mashell.one.module.read.bean.EssayAndComment;
import com.mashell.one.module.read.bean.EssayDetail;

import rx.Observable;

/**
 * Created by mashell on 16/12/21.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public interface EssayContract {
    interface IEssayModel extends BaseModel{
        Observable<Comment> getEssayComment(String id, String num);
        Observable<EssayDetail> getEssayDetail(String id);
        Observable<EssayAndComment> getAllData(String id, String num);
    }

    interface IEssayView extends BaseView{
        void setEssayDetail(EssayDetail essayDetail);
        void addCommentData(Comment comment);
    }

    abstract class IEssayPresenter extends BasePresenter<IEssayView,IEssayModel>{
        public abstract void getAllData(String id);
        public abstract void getCommentList(String id,String num);
        public abstract void getEssayDetail(String id);
    }

}
