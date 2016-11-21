package com.mashell.one.module.movie.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class MovieDetail implements Serializable {

    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("indexcover")
    public String indexcover;
    @SerializedName("detailcover")
    public String detailcover;
    @SerializedName("video")
    public String video;
    @SerializedName("verse")
    public String verse;
    @SerializedName("verse_en")
    public String verseEn;
    @SerializedName("score")
    public String score;
    @SerializedName("revisedscore")
    public String revisedscore;
    @SerializedName("review")
    public String review;
    @SerializedName("keywords")
    public String keywords;
    @SerializedName("movie_id")
    public String movieId;
    @SerializedName("info")
    public String info;
    @SerializedName("officialstory")
    public String officialstory;
    @SerializedName("charge_edt")
    public String chargeEdt;
    @SerializedName("web_url")
    public String webUrl;
    @SerializedName("praisenum")
    public int praisenum;
    @SerializedName("sort")
    public String sort;
    @SerializedName("releasetime")
    public String releasetime;
    @SerializedName("scoretime")
    public String scoretime;
    @SerializedName("maketime")
    public String maketime;
    @SerializedName("last_update_date")
    public String lastUpdateDate;
    @SerializedName("read_num")
    public String readNum;
    @SerializedName("sharenum")
    public int sharenum;
    @SerializedName("commentnum")
    public int commentnum;
    @SerializedName("servertime")
    public int servertime;
    @SerializedName("photo")
    public List<String> photo;

}
