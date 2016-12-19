package com.mashell.one.module.read.contract;

import com.mashell.one.base.BaseModel;
import com.mashell.one.base.BasePresenter;
import com.mashell.one.base.BaseView;
import com.mashell.one.module.read.bean.ReadBannerDetail;

import java.util.List;

import rx.Observable;

/**
 * Created by mashell on 16/12/14.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public interface BannerDetailContract {

    interface IBannerDetailModel extends BaseModel{
        Observable<List<ReadBannerDetail>> getBannerDetail(String id);
    }

    interface IBannerDetailView extends BaseView{
        void setBannerDetailData(List<ReadBannerDetail> list);

    }

    abstract class IBannerDetailPresenter extends BasePresenter<IBannerDetailView,IBannerDetailModel>{
        public abstract void getBannerDetail(String id);
    }
}
