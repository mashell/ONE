package com.mashell.one.module.read.model;

import com.mashell.one.base.BaseResult;
import com.mashell.one.common.RetrofitInstance;
import com.mashell.one.module.read.bean.ReadArticleList;
import com.mashell.one.module.read.bean.ReadBanner;
import com.mashell.one.module.read.contract.ReadContract;
import com.mashell.one.util.RxUtils;

import java.util.List;

import rx.Observable;

/**
 * Created by mashell on 16/12/8.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class ReadModel implements ReadContract.IReadModel {

    @Override
    public Observable<List<ReadBanner>> getBannerUrl(){
        return RetrofitInstance.getApiInterface()
                .getReadBanner()
                .compose(RxUtils.<BaseResult<List<ReadBanner>>>defaultSchedulers())
                .compose(RxUtils.<List<ReadBanner>>handleResult());
    }

    @Override
    public Observable<ReadArticleList> getReadContent() {
        return RetrofitInstance.getApiInterface().getReadArticleList()
                .compose(RxUtils.<BaseResult<ReadArticleList>>defaultSchedulers())
                .compose(RxUtils.<ReadArticleList>handleResult());
    }
}
