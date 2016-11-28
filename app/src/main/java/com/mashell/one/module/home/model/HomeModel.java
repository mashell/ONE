package com.mashell.one.module.home.model;

import com.mashell.one.base.BaseResult;
import com.mashell.one.common.RetrofitInstance;
import com.mashell.one.module.home.contract.HomeContract;
import com.mashell.one.util.RxUtils;

import java.util.List;

import rx.Observable;

/**
 * Created by mashell on 16/11/27.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class HomeModel implements HomeContract.IModel{

    @Override
    public Observable<List<String>> getIdList() {
        return RetrofitInstance.getApiInterface().getOneIdList()
                .compose(RxUtils.<BaseResult<List<String>>>defaultSchedulers())
                .compose(RxUtils.<List<String>>handleResult());
    }

}
