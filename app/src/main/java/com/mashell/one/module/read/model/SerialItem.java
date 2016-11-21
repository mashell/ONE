package com.mashell.one.module.read.model;

import com.google.gson.annotations.SerializedName;

import com.mashell.one.module.main.model.UserBean;

import java.io.Serializable;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class SerialItem implements Serializable {

    @SerializedName("id")
    public String id;
    @SerializedName("serial_id")
    public String serialId;
    @SerializedName("number")
    public String number;
    @SerializedName("title")
    public String title;
    @SerializedName("excerpt")
    public String excerpt;
    @SerializedName("read_num")
    public String readNum;
    @SerializedName("maketime")
    public String maketime;
    @SerializedName("author")
    public UserBean author;
    @SerializedName("has_audio")
    public boolean hasAudio;

}
