package com.mashell.one.module.read.contract;

import com.mashell.one.base.BaseModel;
import com.mashell.one.base.BasePresenter;
import com.mashell.one.base.BaseView;

/**
 * Created by mashell on 16/12/12.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public interface InnerReadContract {
    interface IInnerReadModel extends BaseModel{


    }

    interface IInnerReadView extends BaseView{
        void initData();
    }

    abstract class IInnerReadPresenter extends BasePresenter<IInnerReadView,IInnerReadModel>{

    }
}
