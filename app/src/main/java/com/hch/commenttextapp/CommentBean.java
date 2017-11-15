package com.hch.commenttextapp;

/**
 * Created by hch on 2017/11/15.
 */

public class CommentBean {
    /* 评论内容 */
    private String comment;
    /* 评论人 */
    private UserBean user;
    /* 回复人 */
    private UserBean replyUser;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public UserBean getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(UserBean replyUser) {
        this.replyUser = replyUser;
    }
}
