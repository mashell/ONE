package com.mashell.one.module.read.presenter;

import com.mashell.one.module.read.bean.ReadArticleList;
import com.mashell.one.module.read.bean.ReadBanner;
import com.mashell.one.module.read.contract.ReadContract;
import com.mashell.one.module.read.model.ReadModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by mashell on 16/12/8.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class ReadPresenter extends ReadContract.IReadPresenter {

    public ReadPresenter(ReadContract.IReadView view) {
        attachView(view);
        mModel = new ReadModel();
    }

    @Override
    public void getBanner(){
        mModel.getBannerUrl()
                .compose(getView().<List<ReadBanner>>bind())
                .subscribe(new Subscriber<List<ReadBanner>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<ReadBanner> readBanners) {
                        List<String> bannerUrl = new ArrayList<String>();
                        for (int i = 0;i<readBanners.size();i++){
                            bannerUrl.add(readBanners.get(i).cover);
                        }
                        getView().initBannerData(bannerUrl);
                    }
                });
    }

    @Override
    public void getReadContent() {
        mModel.getReadContent()
                .compose(getView().<ReadArticleList>bind())
                .subscribe(new Subscriber<ReadArticleList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ReadArticleList readArticleList) {
                        getView().initReadContent(readArticleList);
                    }
                });
    }
}
