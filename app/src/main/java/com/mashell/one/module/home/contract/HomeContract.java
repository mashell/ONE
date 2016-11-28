package com.mashell.one.module.home.contract;

import com.mashell.one.base.BaseModel;
import com.mashell.one.base.BasePresenter;
import com.mashell.one.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by mashell on 16/11/27.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public interface HomeContract {

    interface IModel extends BaseModel {
         Observable<List<String>> getIdList();
    }

    interface IHomeView extends BaseView{
        void initListFragment(List<String> idList);
    }

    abstract class IHomePresenter extends BasePresenter<IHomeView,IModel> {
         public abstract void getIdList();
    }
}
