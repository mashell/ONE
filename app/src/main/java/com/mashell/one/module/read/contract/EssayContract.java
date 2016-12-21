package com.mashell.one.module.read.contract;

import com.mashell.one.base.BaseModel;
import com.mashell.one.base.BasePresenter;
import com.mashell.one.base.BaseView;

/**
 * Created by mashell on 16/12/21.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public interface EssayContract {
    interface IEssayModel extends BaseModel{

    }

    interface IEssayView extends BaseView{

    }

    abstract class IEssayPresenter extends BasePresenter<IEssayView,IEssayModel>{

    }

}
