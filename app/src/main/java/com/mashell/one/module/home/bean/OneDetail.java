package com.mashell.one.module.home.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class OneDetail implements Serializable {

    @SerializedName("hpcontent_id")
    public String hpcontentId;
    @SerializedName("hp_title")
    public String hpTitle;
    @SerializedName("author_id")
    public String authorId;
    @SerializedName("hp_img_url")
    public String hpImgUrl;
    @SerializedName("hp_img_original_url")
    public String hpImgOriginalUrl;
    @SerializedName("hp_author")
    public String hpAuthor;
    @SerializedName("ipad_url")
    public String ipadUrl;
    @SerializedName("hp_content")
    public String hpContent;
    @SerializedName("hp_makettime")
    public String hpMakettime;
    @SerializedName("last_update_date")
    public String lastUpdateDate;
    @SerializedName("web_url")
    public String webUrl;
    @SerializedName("wb_img_url")
    public String wbImgUrl;
    @SerializedName("praisenum")
    public int praisenum;
    @SerializedName("sharenum")
    public int sharenum;
    @SerializedName("commentnum")
    public int commentnum;

}
