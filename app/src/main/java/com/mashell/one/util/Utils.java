package com.mashell.one.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * Created by mashell on 16/11/13.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class Utils {

    //判断当前应用是否debug状态
    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    //获取当前应用名
    public static String getApplicationName(Context context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static String safeText(String string) {
        return TextUtils.isEmpty(string) ? "未知" : string;
    }

    public static String safeText(int intString) {
        return safeText(String.valueOf(intString));
    }
}
