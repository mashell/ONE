package com.mashell.one.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.mashell.one.C;
import com.mashell.one.module.main.bean.Month;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


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

    //版本号
    public static int getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //版本号的名称
    public static String getVersionName(Context context) {
        try {
            PackageManager mPackageManager = context.getPackageManager();
            PackageInfo _info = mPackageManager.getPackageInfo(context.getPackageName(), 0);
            return _info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    //是否联网
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(
                    Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断是否是wifi连接
     */
    public static boolean isWifi(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info != null && info.getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * 根据最早时间返回Month的List列表
     */

    public static List<Month> getMonthList(Calendar calendar, int type) {
        int nowYear = calendar.get(Calendar.YEAR);
        int nowMonth = calendar.get(Calendar.MONTH);
        int number;
        List<Month> monthList = new ArrayList<>();
        if (type == C.LONG_TYPE) {
            number = (nowYear - 2012) * 12 + (nowMonth - 9);
        } else {
            number = (nowYear - 2016) * 12 + nowMonth;
        }

        for (int i = number; i > 0; i--) {
            if (i == number) {
                Month month = new Month(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1), "本月");
                monthList.add(month);
            } else {
                Month month = new Month(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH)+1), TimeUtil.formatOne(calendar));
                monthList.add(month);
            }
            calendar.add(Calendar.MONTH, -1);
        }
        return monthList;
    }
}
