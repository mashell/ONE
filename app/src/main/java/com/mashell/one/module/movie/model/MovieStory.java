package com.mashell.one.module.movie.model;

import com.google.gson.annotations.SerializedName;

import com.mashell.one.module.main.model.UserBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class MovieStory implements Serializable {

    @SerializedName("count")
    public int count;
    @SerializedName("data")
    public List<DataBean> data;

    public static class DataBean {
        @SerializedName("id")
        public String id;
        @SerializedName("movie_id")
        public String movieId;
        @SerializedName("title")
        public String title;
        @SerializedName("content")
        public String content;
        @SerializedName("user_id")
        public String userId;
        @SerializedName("sort")
        public String sort;
        @SerializedName("praisenum")
        public int praisenum;
        @SerializedName("input_date")
        public String inputDate;
        @SerializedName("story_type")
        public String storyType;
        @SerializedName("user")
        public UserBean user;

    }
}
