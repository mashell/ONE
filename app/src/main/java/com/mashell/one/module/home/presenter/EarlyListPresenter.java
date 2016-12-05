package com.mashell.one.module.home.presenter;

import com.mashell.one.module.home.contract.EarlyListContract;
import com.mashell.one.module.home.model.EarlyListModel;
import com.mashell.one.module.main.model.Month;

import java.util.List;

/**
 * Created by mashell on 16/11/30.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class EarlyListPresenter extends EarlyListContract.IEarlyListPresenter {

    public EarlyListPresenter(EarlyListContract.IEarlyListView view) {
        attachView(view);
        mModel = new EarlyListModel();
    }

    @Override
    public List<Month> getEarlyMonth(int type) {
        return mModel.getEarlyMonth(type);
    }
}
