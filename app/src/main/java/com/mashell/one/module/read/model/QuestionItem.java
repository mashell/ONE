package com.mashell.one.module.read.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class QuestionItem implements Serializable {

    @SerializedName("question_id")
    public String questionId;
    @SerializedName("question_title")
    public String questionTitle;
    @SerializedName("answer_title")
    public String answerTitle;
    @SerializedName("answer_content")
    public String answerContent;
    @SerializedName("question_makettime")
    public String questionMakettime;
}
