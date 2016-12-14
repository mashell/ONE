package com.mashell.one.module.read.presenter;

import com.mashell.one.module.read.bean.ReadBannerDetail;
import com.mashell.one.module.read.contract.BannerDetailContract;
import com.mashell.one.module.read.model.BannerDetailModel;

import java.util.List;

import rx.Subscriber;

/**
 * Created by mashell on 16/12/14.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class BannerDetailPresenter extends BannerDetailContract.IBannerDetailPresenter {

    public BannerDetailPresenter(BannerDetailContract.IBannerDetailView view) {
        attachView(view);
        mModel = new BannerDetailModel();
    }

    @Override
    public void getBannerDetail(String id) {
        mModel.getBannerDetail(id)
                .compose(getView().<List<ReadBannerDetail>>bind())
                .subscribe(new Subscriber<List<ReadBannerDetail>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<ReadBannerDetail> readBannerDetails) {

                    }
                });
    }
}
