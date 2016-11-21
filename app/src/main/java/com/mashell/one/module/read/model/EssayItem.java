package com.mashell.one.module.read.model;

import com.google.gson.annotations.SerializedName;

import com.mashell.one.module.main.model.UserBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class EssayItem implements Serializable{

    @SerializedName("content_id")
    public String contentId;
    @SerializedName("hp_title")
    public String hpTitle;
    @SerializedName("hp_makettime")
    public String hpMakettime;
    @SerializedName("guide_word")
    public String guideWord;
    @SerializedName("has_audio")
    public boolean hasAudio;
    @SerializedName("author")
    public List<UserBean> author;

}
