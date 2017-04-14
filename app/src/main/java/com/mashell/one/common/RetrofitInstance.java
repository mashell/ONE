package com.mashell.one.common;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mashell.one.base.OneApp;
import com.mashell.one.util.Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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


        //网络请求cache缓存
        File cacheFile = new File(OneApp.getContext().getExternalCacheDir(), "XiQueApp");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 20);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (Utils.isNetworkConnected(OneApp.getContext())) {
                    request = request.newBuilder()
                            //网络可用，强制缓存
                            .cacheControl(CacheControl.FORCE_NETWORK)
                            .build();
                } else{
                    request = request.newBuilder()
                            //网络不可用，读取缓存
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (Utils.isNetworkConnected(OneApp.getContext())) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时
                    response = response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为2周
                    int maxStale = 60 * 60 * 24 * 14;
                    response = response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };

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
//                .cache(cache)
//                .addInterceptor(cacheInterceptor)
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
