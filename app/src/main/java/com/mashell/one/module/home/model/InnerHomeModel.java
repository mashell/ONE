package com.mashell.one.module.home.model;

import com.mashell.one.base.BaseResult;
import com.mashell.one.common.RetrofitInstance;
import com.mashell.one.module.home.bean.OneDetail;
import com.mashell.one.module.home.contract.InnerHomeContract;
import com.mashell.one.util.RxUtils;

import rx.Observable;

/**
 * Created by mashell on 16/11/28.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class InnerHomeModel implements InnerHomeContract.IInnerModel {
    @Override
    public Observable<OneDetail> getOneDetail(String id) {
        return RetrofitInstance.getApiInterface().getOneDetail(id)
                .compose(RxUtils.<BaseResult<OneDetail>>defaultSchedulers())
                .compose(RxUtils.<OneDetail>handleResult());
    }
}
