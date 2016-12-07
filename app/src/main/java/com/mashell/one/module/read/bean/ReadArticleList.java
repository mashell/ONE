package com.mashell.one.module.read.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class ReadArticleList {

    @SerializedName("essay")
    public List<EssayItem> essay;
    @SerializedName("serial")
    public List<SerialItem> serial;
    @SerializedName("question")
    public List<QuestionItem> question;

}
