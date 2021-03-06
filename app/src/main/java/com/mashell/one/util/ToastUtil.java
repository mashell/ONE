package com.mashell.one.util;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.mashell.one.base.OneApp;

/**
 * Created by HugoXie on 16/5/20.
 *
 * Email: Hugo3641@gamil.com
 * GitHub: https://github.com/xcc3641
 * Info:
 */
public class ToastUtil {

    public static void show(String content) {
        Toast.makeText(OneApp.getContext(), content, Toast.LENGTH_SHORT).show();
    }

    public static void show(@StringRes int res) {
        Toast.makeText(OneApp.getContext(), res, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String content) {
        Toast.makeText(OneApp.getContext(), content, Toast.LENGTH_LONG).show();
    }

    public static void showLong(@StringRes int res) {
        Toast.makeText(OneApp.getContext(), res, Toast.LENGTH_SHORT).show();
    }
}
