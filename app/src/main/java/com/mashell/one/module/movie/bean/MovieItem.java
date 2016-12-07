package com.mashell.one.module.movie.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class MovieItem implements Serializable {

    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("verse")
    public String verse;
    @SerializedName("verse_en")
    public String verseEn;
    @SerializedName("score")
    public String score;
    @SerializedName("revisedscore")
    public String revisedscore;
    @SerializedName("releasetime")
    public String releasetime;
    @SerializedName("scoretime")
    public String scoretime;
    @SerializedName("cover")
    public String cover;
    @SerializedName("servertime")
    public int servertime;
}
