package com.mashell.one.module.read.model;

import com.mashell.one.base.BaseResult;
import com.mashell.one.common.RetrofitInstance;
import com.mashell.one.module.read.bean.ReadBannerDetail;
import com.mashell.one.module.read.contract.BannerDetailContract;
import com.mashell.one.util.RxUtils;

import java.util.List;

import rx.Observable;

/**
 * Created by mashell on 16/12/14.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class BannerDetailModel implements BannerDetailContract.IBannerDetailModel {
    @Override
    public Observable<List<ReadBannerDetail>> getBannerDetail(String id) {
        return RetrofitInstance.getApiInterface().getReadBannerDetail(id)
                .compose(RxUtils.<BaseResult<List<ReadBannerDetail>>>defaultSchedulers())
                .compose(RxUtils.<List<ReadBannerDetail>>handleResult());
    }
}
