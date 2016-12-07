package com.mashell.one.module.home.model;

import com.mashell.one.base.BaseResult;
import com.mashell.one.common.RetrofitInstance;
import com.mashell.one.module.home.bean.OneMonth;
import com.mashell.one.module.home.contract.MonthContract;
import com.mashell.one.util.RxUtils;

import java.util.List;

import rx.Observable;

/**
 * Created by mashell on 16/12/6.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class MonthModel implements MonthContract.IMonthModel {
    @Override
    public Observable<List<OneMonth>> getOneList(String month) {
        return RetrofitInstance.getApiInterface().
                getOneByMonth(month)
                .compose(RxUtils.<BaseResult<List<OneMonth>>>defaultSchedulers())
                .compose(RxUtils.<List<OneMonth>>handleResult());
    }
}
