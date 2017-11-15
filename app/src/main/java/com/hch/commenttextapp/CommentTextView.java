package com.hch.commenttextapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 用于显示评论的TextView
 *
 * Created by hch on 2017/10/17.
 */

@SuppressLint("AppCompatCustomView")
public class CommentTextView extends TextView {

    public CommentTextView(Context context) {
        this(context, null);
    }

    public CommentTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setMovementMethod(CommentUserMovementMethod.getInstance());
        setClickable(false);
        setLongClickable(false);
    }

    public void setText(CommentBean comment) {
        SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
        if (comment.getUser() != null) {
            String str = comment.getUser().getUserName();
            stringBuilder.append(str);
            CommentUserSpan span = new CommentUserSpan(getContext(), comment.getUser());
            stringBuilder.setSpan(span, 0, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (comment.getReplyUser() != null) {
            stringBuilder.append("回复");
            int start = stringBuilder.toString().length();
            String str = comment.getReplyUser().getUserName();
            stringBuilder.append(str);
            CommentUserSpan span = new CommentUserSpan(getContext(), comment.getReplyUser());
            stringBuilder.setSpan(span, start, start + str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            stringBuilder.append("：");
        }
        stringBuilder.append(comment.getComment());
        setText(stringBuilder);
    }

}
