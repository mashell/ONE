package com.mashell.one.module.home.presenter;

import com.mashell.one.module.home.bean.OneDetail;
import com.mashell.one.module.home.contract.InnerHomeContract;
import com.mashell.one.module.home.model.InnerHomeModel;

import rx.Subscriber;

/**
 * Created by mashell on 16/11/28.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class IInnerHomePresenter extends InnerHomeContract.IInnerPresenter {

    public IInnerHomePresenter(InnerHomeContract.IInnerView view) {
        attachView(view);
        mModel = new InnerHomeModel();
    }

    @Override
    public void getOneDetail(String id) {
        mModel.getOneDetail(id)
                .compose(getView().<OneDetail>bind())
                .subscribe(new Subscriber<OneDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(OneDetail detail) {
                        getView().getOneDetailData(detail);
                    }
                });

    }
}
