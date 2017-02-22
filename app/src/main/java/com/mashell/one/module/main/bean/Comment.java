package com.mashell.one.module.main.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mashell on 17/2/22.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class Comment {

    @SerializedName("count")
    public int count;
    @SerializedName("data")
    public List<CommentItem> data;
}
