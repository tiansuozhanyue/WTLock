package com.example.herocat.wtlock.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.herocat.wtlock.R;
import com.example.herocat.wtlock.utils.StatusBarUtil;
import com.example.herocat.wtlock.widget.WTLoadingDialog;

public class WTBaseActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout root_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_root);
        StatusBarUtil.setStatusBarLightMode(getWindow(), true);
        root_layout = findViewById(R.id.child_layout);
    }

    /**
     * 初始化头部
     *
     * @param l_left
     * @param title
     * @param r_left
     */
    protected void setContentView(@LayoutRes int layId, View.OnClickListener l_left, String title, View.OnClickListener r_left) {

        View contentView = LayoutInflater.from(this).inflate(layId, null);
        root_layout.addView(contentView);

        ImageView view_l = findViewById(R.id.title_left);
        ImageView view_r = findViewById(R.id.title_right);
        TextView title_text = findViewById(R.id.title_text);

        if (l_left == null) {
            view_l.setVisibility(View.GONE);
        } else {
            view_l.setOnClickListener(l_left);
        }

        if (r_left == null) {
            view_r.setVisibility(View.GONE);
        } else {
            view_r.setOnClickListener(r_left);
        }

        title_text.setText(title);

    }

    protected void startLoading() {
        WTLoadingDialog.showProgressDialog(this);
    }

    protected void endLoading() {
        WTLoadingDialog.hideProgressDialog();
    }


    @Override
    public void onClick(View v) {

    }

}
