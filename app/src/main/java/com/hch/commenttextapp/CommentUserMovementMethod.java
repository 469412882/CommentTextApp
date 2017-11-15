package com.hch.commenttextapp;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * TextView点击评论用户标签响应的事件
 *
 * Created by hch on 2017/10/17.
 */

public class CommentUserMovementMethod extends BaseMovementMethod {

    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        int action = event.getAction();

        int x = (int) event.getX();
        int y = (int) event.getY();

        x -= widget.getTotalPaddingLeft();
        y -= widget.getTotalPaddingTop();

        x += widget.getScrollX();
        y += widget.getScrollY();

        Layout layout = widget.getLayout();
        int line = layout.getLineForVertical(y);
        int off = layout.getOffsetForHorizontal(line, x);

        CommentUserSpan[] link = buffer.getSpans(off, off, CommentUserSpan.class);
        CommentUserSpan span = null;
        if (link.length > 0) {
            span = link[0];
        }
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (span != null) {
                    span.setPressed(true);
                    Selection.setSelection(buffer, buffer.getSpanStart(span), buffer.getSpanEnd(span));
                    return true;
                } else {
                    Selection.removeSelection(buffer);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (span != null) {
                    span.onClick(widget);
                    span.setPressed(false);
                    Selection.removeSelection(buffer);
                    return true;
                }
                Selection.removeSelection(buffer);
                break;
            case MotionEvent.ACTION_MOVE:
                if (span != null) {
                    span.setPressed(false);
                    return true;
                } else {
                    Selection.removeSelection(buffer);
                }
                break;
            default:
                if (span != null) {
                    span.setPressed(false);
                }
                Selection.removeSelection(buffer);
                break;
        }

        return false;
    }

    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new CommentUserMovementMethod();
        }

        return sInstance;
    }

    private static CommentUserMovementMethod sInstance;
}
