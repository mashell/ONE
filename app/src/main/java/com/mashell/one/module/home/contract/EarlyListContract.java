package com.mashell.one.module.home.contract;

import com.mashell.one.base.BaseModel;
import com.mashell.one.base.BasePresenter;
import com.mashell.one.base.BaseView;
import com.mashell.one.module.main.model.Month;

import java.util.List;

/**
 * Created by mashell on 16/11/30.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public interface EarlyListContract {

    interface IEarlyListModel extends BaseModel{
        List<Month> getEarlyMonth(int type);
    }

    interface IEarlyListView extends BaseView {
        void setTabStatus(int index);
        void recoveryTabStatus(int index);
        void changeTabStatus(int index);
        void setIntentStatus(int index);
    }

    abstract class IEarlyListPresenter extends BasePresenter<IEarlyListView,IEarlyListModel>{
        public abstract List<Month> getEarlyMonth(int type);
    }
}
