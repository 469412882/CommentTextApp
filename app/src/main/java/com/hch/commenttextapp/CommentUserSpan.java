package com.hch.commenttextapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

/**
 * 评论用户
 * 
 * Created by hch on 2017/10/17.
 */

@SuppressLint("ParcelCreator")
public class CommentUserSpan extends ClickableSpan {

    private UserBean user;
    private Context context;
    private boolean isPressed;
    private int normalColor;
    private int pressedColor;

    public CommentUserSpan(Context context, UserBean commentUser) {
        super();
        this.user = commentUser;
        this.context = context;
        normalColor = Color.TRANSPARENT;
        pressedColor = context.getResources().getColor(R.color.colorPressed);
    }

    @Override
    public void onClick(View widget) {
        Toast.makeText(context, "点击" + user.getUserName(), Toast.LENGTH_SHORT).show();
    }

    public void setPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(Color.BLUE);
        ds.bgColor = isPressed ? pressedColor : normalColor;
    }
}
