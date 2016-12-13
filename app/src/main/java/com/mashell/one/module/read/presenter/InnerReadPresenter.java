package com.mashell.one.module.read.presenter;

import com.mashell.one.module.read.contract.InnerReadContract;
import com.mashell.one.module.read.model.InnerReadModel;

/**
 * Created by mashell on 16/12/12.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class InnerReadPresenter extends InnerReadContract.IInnerReadPresenter {

    public InnerReadPresenter(InnerReadContract.IInnerReadView view) {
        attachView(view);
        mModel = new InnerReadModel();
    }

}
