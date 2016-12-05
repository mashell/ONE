package com.mashell.one.base;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.mashell.one.OneApp;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

/**
 * BaseActivity 链接 https://www.zhihu.com/question/47045239/answer/105086885
 */

public abstract class BaseActivity<P extends BasePresenter> extends RxAppCompatActivity {
    protected String TAG;
    //是否Debug模式
    private boolean isDebug;
    private String APP_NAME;
    private View mContextView = null;
    //是否沉浸状态栏
    private boolean ifSetStatusBar = true;
    //是否允许全屏
    private boolean ifAllowFullScreen = false;
    //是否允许旋转屏幕
    private boolean ifAllowScreenRotate = true;

    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
        isDebug = OneApp.isDebug;
        APP_NAME = OneApp.APP_NAME;
        mvpPresenter = createPresenter();
        try {
            Bundle bundle = getIntent().getExtras();
            mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);

            if (ifAllowFullScreen) {
                this.getWindow()
                        .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
                requestWindowFeature(Window.FEATURE_NO_TITLE);
            }

            if (ifSetStatusBar) {
                setStatusBar();
            }

            setContentView(mContextView);

            if (!ifAllowScreenRotate) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            } else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        } catch (Exception e) {
            Log.e("Activity ERROR", TAG + "catch a Exception");
            e.printStackTrace();
        }

        OneApp.getContext().addActivity(this);
        ButterKnife.bind(this);
        initView();
    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
    /**
     * [初始化]
     */
    public abstract void initView();

    /**
     * [绑定布局]
     */
    protected abstract int bindLayout();

    /**
     * [初始化Presenter]
     */
    public abstract P createPresenter();

    public View getContentView() {
        return mContextView;
    }

    /**
     * [显示短Toast]
     */
    public void showShortToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    /**
     * [显示长Toast]
     */
    public void showLongToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
    }

    /**
     * [是否允许全屏]
     *
     * @param allowFullScreen 是否允许全屏
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.ifAllowScreenRotate = allowFullScreen;
    }

    /**
     * [是否设置沉浸状态栏]
     *
     * @param isSetStatusBar 是否设置沉浸状态栏
     */
    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.ifSetStatusBar = isSetStatusBar;
    }

    /**
     * [是否允许屏幕旋转]
     *
     * @param ifAllowFullScreen 是否允许屏幕旋转
     */
    public void setScreenRoate(boolean ifAllowFullScreen) {
        this.ifAllowFullScreen = ifAllowFullScreen;
    }

    /**
     * [日志输出]
     *
     * @param msg 日志信息
     */
    protected void $Log(String msg) {
        if (isDebug) {
            Log.d(APP_NAME, msg);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null)
            mvpPresenter.detachView();
        OneApp.getContext().removeActivity(this);
    }
}
