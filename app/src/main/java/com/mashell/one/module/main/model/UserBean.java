package com.mashell.one.module.main.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class UserBean implements Serializable{

    @SerializedName("user_id")
    public String userId;
    @SerializedName("user_name")
    public String userName;
    @SerializedName("web_url")
    public String webUrl;
    @SerializedName("desc")
    public String desc;
    @SerializedName("wb_name")
    public String wbName;
}
