package com.hch.commenttextapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CommentTextView commentTextView = findViewById(R.id.comment_text);
        CommentBean commentBean = new CommentBean();
        commentBean.setComment("大吉大利，今晚吃鸡，哈哈哈。 ");
        UserBean commentUser = new UserBean();
        commentUser.setUserName("小A");
        UserBean replyUser = new UserBean();
        replyUser.setUserName("小B");
        commentBean.setUser(commentUser);
        commentBean.setReplyUser(replyUser);
        commentTextView.setText(commentBean);
        findViewById(R.id.comment_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "响应item点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
