package com.mashell.one.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by mashell on 16/11/28.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class TimeUtil {
    public static String formatTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatWeek(date)+formatOne(date);
    }

    /**
     * 转ONE时间格式
     */
    public static String formatOne(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" dd MMM.yyyy", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }


    /**
     * 获取日期
     */

    public static String formatWeek(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }
}
