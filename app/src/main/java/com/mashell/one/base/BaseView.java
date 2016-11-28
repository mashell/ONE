package com.mashell.one.base;

import rx.Observable;


/**
 * Created by mashell on 16/11/27.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public interface BaseView{

    /**
     * rxLifecycle的调用
     */
    <V>Observable.Transformer<V,V> bind();
}
