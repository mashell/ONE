package com.mashell.one.module.read.presenter;

import com.mashell.one.module.read.contract.EssayContract;
import com.mashell.one.module.read.model.EssayModel;

/**
 * Created by mashell on 16/12/21.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class EssayPresenter extends EssayContract.IEssayPresenter {

    public EssayPresenter(EssayContract.IEssayView view) {
        attachView(view);
        mModel = new EssayModel();
    }
}
