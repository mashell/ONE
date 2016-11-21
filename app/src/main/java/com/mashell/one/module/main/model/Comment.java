package com.mashell.one.module.main.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class Comment implements Serializable {

    @SerializedName("count")
    public int count;
    @SerializedName("data")
    public List<DataBean> data;

    public static class DataBean {
        @SerializedName("id")
        public String id;
        @SerializedName("quote")
        public String quote;
        @SerializedName("content")
        public String content;
        @SerializedName("praisenum")
        public int praisenum;
        @SerializedName("device_token")
        public String deviceToken;
        @SerializedName("del_flag")
        public String delFlag;
        @SerializedName("reviewed")
        public String reviewed;
        @SerializedName("user_info_id")
        public String userInfoId;
        @SerializedName("input_date")
        public String inputDate;
        @SerializedName("created_at")
        public String createdAt;
        @SerializedName("updated_at")
        public String updatedAt;
        @SerializedName("user")
        public UserBean user;
        @SerializedName("touser")
        public Object touser;
        @SerializedName("score")
        public String score;
        @SerializedName("type")
        public int type;

    }

}
