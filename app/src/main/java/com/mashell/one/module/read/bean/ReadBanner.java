package com.mashell.one.module.read.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class ReadBanner implements Serializable {

    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("cover")
    public String cover;
    @SerializedName("bottom_text")
    public String bottomText;
    @SerializedName("bgcolor")
    public String bgcolor;
    @SerializedName("pv_url")
    public String pvUrl;

}
