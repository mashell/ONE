package com.mashell.one.module.home.presenter;

import com.mashell.one.C;
import com.mashell.one.module.home.bean.OneMonth;
import com.mashell.one.module.home.contract.MonthContract;
import com.mashell.one.module.home.model.MonthModel;

import java.util.List;

import rx.Subscriber;

/**
 * Created by mashell on 16/12/6.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class MonthPresenter extends MonthContract.IMonthPresenter {

    public MonthPresenter(MonthContract.IMonthView view) {
        attachView(view);
        mModel = new MonthModel();
    }

    @Override
    public void getOneList(String month, int type) {
        switch (type) {
            case C.TYPE_ONE:
                mModel.getOneList(month)
                        .compose(getView().<List<OneMonth>>bind())
                        .subscribe(new Subscriber<List<OneMonth>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(List<OneMonth> oneMonths) {
                                getView().setAdapterData(oneMonths);
                            }
                        });
                break;

        }
    }
}
