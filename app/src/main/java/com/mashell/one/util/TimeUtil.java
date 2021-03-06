package com.mashell.one.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by mashell on 16/11/28.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class TimeUtil {
    /**
     * 带星期显示的ONE时间格式
     * @param time
     * @return
     */
    public static String formatTimeShort(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatOneShort(date);
    }

    /**
     * 不带星期显示的ONE时间格式
     * @param time
     * @return
     */
    public static String formatTimeLong(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatOneLong(date);
    }

    /**
     * 转ONE时间格式
     */
    public static String formatOneShort(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM.yyyy", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }

    /**
     * 转ONE时间格式
     */
    public static String formatOneLong(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE dd MMM.yyyy", Locale.ENGLISH);
        return simpleDateFormat.format(date);
    }

    public static String formatOne(Calendar calendar){
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM.yyyy", Locale.ENGLISH);
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
