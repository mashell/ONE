package com.mashell.one.module.read.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mashell on 16/11/21.
 * Email: mashell624@163.com
 * Github: https://github.com/mashell
 */

public class QuestionDetail implements Serializable {

    @SerializedName("question_id")
    public String questionId;
    @SerializedName("question_title")
    public String questionTitle;
    @SerializedName("question_content")
    public String questionContent;
    @SerializedName("answer_title")
    public String answerTitle;
    @SerializedName("answer_content")
    public String answerContent;
    @SerializedName("question_makettime")
    public String questionMakettime;
    @SerializedName("recommend_flag")
    public String recommendFlag;
    @SerializedName("charge_edt")
    public String chargeEdt;
    @SerializedName("last_update_date")
    public String lastUpdateDate;
    @SerializedName("web_url")
    public String webUrl;
    @SerializedName("read_num")
    public String readNum;
    @SerializedName("guide_word")
    public String guideWord;
    @SerializedName("praisenum")
    public int praisenum;
    @SerializedName("sharenum")
    public int sharenum;
    @SerializedName("commentnum")
    public int commentnum;

}
