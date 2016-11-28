package com.mashell.one.module.home.contract;

import com.mashell.one.base.BaseModel;
import com.mashell.one.base.BasePresenter;
import com.mashell.one.base.BaseView;
import com.mashell.one.module.home.bean.OneDetail;

import rx.Observable;

/**
 * Created by mashell on 16/11/28.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public interface InnerHomeContract {
    interface IInnerModel extends BaseModel{
        Observable<OneDetail> getOneDetail(String id);
    }

    interface IInnerView extends BaseView{
        void getOneDetailData(OneDetail detail);
    }

    abstract class IInnerPresenter extends BasePresenter<IInnerView,IInnerModel>{
        public abstract void getOneDetail(String id);
    }
}
