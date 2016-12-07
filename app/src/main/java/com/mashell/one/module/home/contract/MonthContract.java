package com.mashell.one.module.home.contract;

import com.mashell.one.base.BaseModel;
import com.mashell.one.base.BasePresenter;
import com.mashell.one.base.BaseView;
import com.mashell.one.module.home.bean.OneMonth;

import java.util.List;

import rx.Observable;

/**
 * Created by mashell on 16/12/6.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public interface MonthContract {

    interface IMonthModel extends BaseModel {
         Observable<List<OneMonth>> getOneList(String month);
    }

    interface IMonthView<T> extends BaseView {
        void setAdapterData(List<T> data);
    }

    abstract class IMonthPresenter extends BasePresenter<IMonthView, IMonthModel> {
        public abstract  void getOneList(String month,int type);
    }
}
