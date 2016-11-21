package com.mashell.one.module.read.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class ReadBannerDetail implements Serializable {

    @SerializedName("item_id")
    public String itemId;
    @SerializedName("title")
    public String title;
    @SerializedName("author")
    public String author;
    @SerializedName("introduction")
    public String introduction;
    @SerializedName("web_url")
    public String webUrl;
    @SerializedName("number")
    public int number;
    @SerializedName("type")
    public String type;

}
