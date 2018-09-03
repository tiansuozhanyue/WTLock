package com.example.herocat.wtlock.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.herocat.wtlock.R;

public class WTLoadingDialog {

    private static Dialog mLoadingDialog;
    private static Activity context;

    /**
     * 显示加载对话框
     */
    public static void showProgressDialog(Activity context) {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        WTLoadingDialog.context = context;

        mLoadingDialog = new Dialog(context, R.style.loading_dialog_style);
        mLoadingDialog.setCancelable(false);
        mLoadingDialog.setContentView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        mLoadingDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    mLoadingDialog.dismiss();
                    return true;
                }
                return false;
            }
        });
        backgroundAlpha(0.5f);
        mLoadingDialog.show();

    }

    /**
     * 隐藏加载对话框
     */
    public static void hideProgressDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            backgroundAlpha(1f);
            mLoadingDialog.dismiss();
            mLoadingDialog = null;
        }
    }

    /**
     * 设置背景透明度
     *
     * @param bgAlpha
     */
    private static void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        context.getWindow().setAttributes(lp);
    }


}
