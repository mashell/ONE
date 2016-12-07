package com.mashell.one.module.read.bean;

import com.google.gson.annotations.SerializedName;

import com.mashell.one.module.main.bean.UserBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class EssayDetail implements Serializable {

    @SerializedName("content_id")
    public String contentId;
    @SerializedName("hp_title")
    public String hpTitle;
    @SerializedName("sub_title")
    public String subTitle;
    @SerializedName("hp_author")
    public String hpAuthor;
    @SerializedName("auth_it")
    public String authIt;
    @SerializedName("hp_author_introduce")
    public String hpAuthorIntroduce;
    @SerializedName("hp_content")
    public String hpContent;
    @SerializedName("hp_makettime")
    public String hpMakettime;
    @SerializedName("wb_name")
    public String wbName;
    @SerializedName("wb_img_url")
    public String wbImgUrl;
    @SerializedName("last_update_date")
    public String lastUpdateDate;
    @SerializedName("web_url")
    public String webUrl;
    @SerializedName("guide_word")
    public String guideWord;
    @SerializedName("audio")
    public String audio;
    @SerializedName("praisenum")
    public int praisenum;
    @SerializedName("sharenum")
    public int sharenum;
    @SerializedName("commentnum")
    public int commentnum;
    @SerializedName("author")
    public List<UserBean> author;

}
