package com.mashell.one.common;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mashell.one.OneApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mashell on 16/11/17.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class RetrofitInstance {

    private Retrofit mRetrofit = null;
    private OkHttpClient mOkHttpClient = null;
    private ApiInterface mApiInterface = null;

    private RetrofitInstance() {
        initOkHttp();
        initRetrofit();
        mApiInterface = mRetrofit.create(ApiInterface.class);
    }

    private void initOkHttp() {
        //设置拦截器，打印出每次的请求结果,在初始化okhttp时 addInterceptor
        //带上token则 addNetworkInterceptor
        //https://drakeet.me/retrofit-2-0-okhttp-3-0-config

         HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //Cookie的持久化管理，为每次请求带上cookie
        //http://blog.csdn.net/lyhhj/article/details/51388147
        CookieJar mCookieJar = new CookieJar() {
            private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                cookieStore.put(url.host(), cookies);
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                List<Cookie> cookies = cookieStore.get(url.host());

                //cookies.get(0).getClass().
                return cookies != null ? cookies : new ArrayList<Cookie>();
            }
        };

        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(OneApp.isDebug ? loggingInterceptor : null)
                .cookieJar(mCookieJar)
                .addNetworkInterceptor(new StethoInterceptor())
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ApiInterface.HOST)
                .build();
    }

    private static class SingletonHolder {
        private static final RetrofitInstance INSTANCE = new RetrofitInstance();

    }

    //获取retrofit单例
    public static RetrofitInstance getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //获取apiInterface单例
    public static ApiInterface getApiInterface() {
        return getInstance().mApiInterface;
    }


}
