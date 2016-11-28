package com.mashell.one.module.home.presenter;

import com.mashell.one.module.home.contract.HomeContract;
import com.mashell.one.module.home.model.HomeModel;

import java.util.List;

import rx.Subscriber;

/**
 * Created by mashell on 16/11/27.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class HomePresenter extends HomeContract.IHomePresenter {


    public HomePresenter(HomeContract.IHomeView view) {
        attachView(view);
        mModel = new HomeModel();
    }

    @Override
    public void getIdList() {
        mModel.getIdList()
                .compose(getView().<List<String>>bind())
                .subscribe(new Subscriber<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<String> strings) {
                        getView().initListFragment(strings);
                    }
                });
    }
}




////    @Override
////    public void attachView(Object mvpView) {
////
////    }
////
////    @Override
////    public void detachView() {
////
////    }
//    private HomeContract.IHomeView view;
//
//    public HomePresenter(HomeContract.IHomeView view) {
//        this.view = view;
//        view.setPresenter(this);
//    }
//
//    @Override
//    public void start() {
//        getIdList();
//    }
//
//    @Override
//    public void getIdList() {
//        RetrofitInstance.getApiInterface().getOneIdList()
//                .compose(RxUtils.<BaseResult<List<String>>>defaultSchedulers())
//                .compose(RxUtils.<List<String>>handleResult())
//                .subscribe(new Subscriber<List<String>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<String> strings) {
//                        view.initListFragment(strings);
//                    }
//                });
//    }
