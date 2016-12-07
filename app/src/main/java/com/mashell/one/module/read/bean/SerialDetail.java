package com.mashell.one.module.read.bean;

import com.google.gson.annotations.SerializedName;

import com.mashell.one.module.main.bean.UserBean;

import java.io.Serializable;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class SerialDetail implements Serializable {

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
    @SerializedName("content")
    public String content;
    @SerializedName("charge_edt")
    public String chargeEdt;
    @SerializedName("read_num")
    public String readNum;
    @SerializedName("maketime")
    public String maketime;
    @SerializedName("last_update_date")
    public String lastUpdateDate;
    @SerializedName("audio")
    public String audio;
    @SerializedName("web_url")
    public String webUrl;
    @SerializedName("input_name")
    public String inputName;
    @SerializedName("last_update_name")
    public String lastUpdateName;
    @SerializedName("author")
    public UserBean author;
    @SerializedName("praisenum")
    public int praisenum;
    @SerializedName("sharenum")
    public int sharenum;
    @SerializedName("commentnum")
    public int commentnum;

}
