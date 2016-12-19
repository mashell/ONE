package com.mashell.one.module.read.contract;

import com.mashell.one.base.BaseModel;
import com.mashell.one.base.BasePresenter;
import com.mashell.one.base.BaseView;
import com.mashell.one.module.read.bean.ReadArticleList;
import com.mashell.one.module.read.bean.ReadBanner;

import java.util.List;

import rx.Observable;

/**
 * Created by mashell on 16/12/8.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public interface ReadContract {

    interface IReadModel extends BaseModel{
        Observable<List<ReadBanner>> getBannerUrl();
        Observable<ReadArticleList> getReadContent();
    }

    interface IReadView extends BaseView{
        void initBannerData(List<String> bannerData);
        void setBannerData(List<ReadBanner> list);
        void initReadContent(ReadArticleList articleList);
    }

    abstract class IReadPresenter extends BasePresenter<IReadView,IReadModel>{
        public abstract void getBanner();
        public abstract void getReadContent();
    }
}
