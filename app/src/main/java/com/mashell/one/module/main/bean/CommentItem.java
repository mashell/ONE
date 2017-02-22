package com.mashell.one.module.main.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mashell on 17/2/22.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class CommentItem {
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
    public UserBean touser;
    @SerializedName("type")
    public int type;

}
