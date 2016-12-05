package com.mashell.one.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.mashell.one.C;
import com.mashell.one.module.main.model.Month;

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

        for (int i = number;i>0;i--){
            calendar.add(Calendar.MONTH,-1);
            Month month = new Month(calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH), TimeUtil.formatOne(calendar));
            monthList.add(month);
        }
        return monthList;
    }
}
