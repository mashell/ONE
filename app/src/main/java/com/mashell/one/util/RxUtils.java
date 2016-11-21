package com.mashell.one.util;

import com.mashell.one.base.BaseResult;
import com.mashell.one.common.ApiException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by mashell on 16/11/17.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class RxUtils {

    /**
     * 网络请求的默认切换线程
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T, T> defaultSchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };
    }

    /**
     * 所有操作都在io线程上
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer ioSchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.observeOn(Schedulers.io()).subscribeOn(Schedulers.io());
            }
        };
    }

    /**
     * 统一处理请求，并且将结果提取出来
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<BaseResult<T>, T> handleResult() {
        return new Observable.Transformer<BaseResult<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseResult<T>> baseResultObservable) {
                return baseResultObservable.flatMap(new Func1<BaseResult<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(BaseResult<T> tBaseResult) {
                        if (tBaseResult.res == 0) {
                            return createData(tBaseResult.data);
                        } else return Observable.error(new ApiException(tBaseResult.res));
                    }
                });
            }
        };

    }

    /**
     * 用于创建一个Observable对象的方法
     * @param data
     * @param <T>
     * @return
     */
    private static <T> Observable<T> createData(final T data) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }



}
