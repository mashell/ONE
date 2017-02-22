package com.mashell.one.module.read.bean;

import com.mashell.one.module.main.bean.Comment;

/**
 * Created by mashell on 17/2/22.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class EssayAndComment {
    public Comment mComment;
    public EssayDetail mEssayDetail;

    public EssayAndComment(Comment comment, EssayDetail essayDetail) {
        mComment = comment;
        mEssayDetail = essayDetail;
    }
}
