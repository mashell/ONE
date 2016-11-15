package com.mashell.one.base;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.mashell.one.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mashell on 16/11/13.
 */

public class BaseApplication extends Application {
    public static boolean isDebug;
    public static String APP_NAME;
    //存放activity的List集合
    private List<Activity> mActivityList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        isDebug = Utils.isApkInDebug(this);
        APP_NAME = Utils.getApplicationName(this);
    }

    /**
     * add the activity into the list end
     * @param activity
     */
    public void addActivity(Activity activity) {
        try {
            if (activity != null && mActivityList != null) {
                int size = mActivityList.size();
                if (checkActivityIsContain(activity)) {
                    removeActivity(activity);
                    mActivityList.add(mActivityList.size(), activity);
                } else {
                    mActivityList.add(activity);
                }
                size = mActivityList.size();
                for (int i = 0; i < size; i++) {
                    Log.i("ActivityList","addActivity ==[" + i + "]" + " " + mActivityList.get(i));
                }
            }
        } catch (Exception e) {
            Log.e("ActivityList","addActivity" + e.getMessage());
        }
    }

    /**
     * remove the finished activity in the list.
     * @param activity
     * the activity is removed from activityList
     */
    public void removeActivity(Activity activity) {
        try {
            if (mActivityList != null) {
                mActivityList.remove(activity);
                Log.i("ActivityList","removeActivity==" + " " + activity + "activityList.size===" + mActivityList.size());
            }
        } catch (Exception e) {
            Log.e("ActivityList","removeActivity" + e.getMessage());
        }
    }
    /**
     * 判定某个Activity的状态,是否已经在List集合内
     * */
    public boolean checkActivityIsContain(Activity activity) {
        Log.i("ActivityList"," " + mActivityList.contains(activity));
        return mActivityList.contains(activity);
    }

    /**
     * finish all the activity in the list.
     *干掉所有的Activity用于程序退出
     * the activity calling this method hold the context
     */
    public void finishAllActivity() {
        if (mActivityList != null) {
            int size = mActivityList.size();
            for (int i = size - 1; i >= 0; i--) {
                Activity activity = mActivityList.get(i);
                if (activity != null) {
                    activity.finish();
                }
                Log.i("ActivityList","finishAllActivity ==[" + i + "]" + " " + activity);
                mActivityList.remove(activity);
            }
        }
    }
}
