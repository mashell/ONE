package com.mashell.one.module.music.bean;

import com.google.gson.annotations.SerializedName;

import com.mashell.one.module.main.bean.UserBean;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class MusicDetail {

    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("cover")
    public String cover;
    @SerializedName("isfirst")
    public String isfirst;
    @SerializedName("story_title")
    public String storyTitle;
    @SerializedName("story")
    public String story;
    @SerializedName("lyric")
    public String lyric;
    @SerializedName("info")
    public String info;
    @SerializedName("platform")
    public String platform;
    @SerializedName("music_id")
    public String musicId;
    @SerializedName("charge_edt")
    public String chargeEdt;
    @SerializedName("related_to")
    public String relatedTo;
    @SerializedName("web_url")
    public String webUrl;
    @SerializedName("praisenum")
    public int praisenum;
    @SerializedName("sort")
    public String sort;
    @SerializedName("maketime")
    public String maketime;
    @SerializedName("last_update_date")
    public String lastUpdateDate;
    @SerializedName("read_num")
    public String readNum;
    @SerializedName("author")
    public UserBean author;
    @SerializedName("story_author")
    public UserBean storyAuthor;
    @SerializedName("sharenum")
    public int sharenum;
    @SerializedName("commentnum")
    public int commentnum;


}
