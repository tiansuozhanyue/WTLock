package com.example.herocat.wtlock.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.herocat.wtlock.R;
import com.example.herocat.wtlock.utils.StringUtil;


/**
 * <pre>
 *     author: memoThree
 *     time  : ${DATA}.
 *     desc  :
 * </pre>
 */

public class WTLineTextView extends RelativeLayout {

    private TextView text_left;
    private TextView text_right;

    public WTLineTextView(Context context) {
        this(context, null);
    }

    public WTLineTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public WTLineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.list_item, this, true);
        text_left = findViewById(R.id.text_left);
        text_right = findViewById(R.id.text_right);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.mime_line_style);
        if (typedArray != null) {
            String left_text = typedArray.getString(R.styleable.mime_line_style_left_text);
            String right_text = typedArray.getString(R.styleable.mime_line_style_right_text);
            text_left.setText(left_text);
            text_right.setText(right_text);
        }

    }

    public void setRightText(String msg) {
        if (!StringUtil.isEmpty(msg))
            text_right.setText(msg);
    }

    public void setLeftText(String msg) {
        if (!StringUtil.isEmpty(msg))
            text_left.setText(msg);
    }

}
