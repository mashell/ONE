package com.mashell.one.module.music.model;

import com.google.gson.annotations.SerializedName;

import com.mashell.one.module.main.model.UserBean;

import java.io.Serializable;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class MusicItem implements Serializable {

    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("cover")
    public String cover;
    @SerializedName("platform")
    public String platform;
    @SerializedName("music_id")
    public String musicId;
    @SerializedName("author")
    public UserBean author;

}
