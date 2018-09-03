package com.example.herocat.wtlock.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.accloud.cloudservice.AC;
import com.accloud.cloudservice.PayloadCallback;
import com.accloud.service.ACAccountMgr;
import com.accloud.service.ACException;
import com.accloud.service.ACUserInfo;
import com.example.herocat.wtlock.R;
import com.example.herocat.wtlock.base.WTBaseActivity;
import com.example.herocat.wtlock.utils.DisplayUtil;
import com.example.herocat.wtlock.utils.LogUtil;
import com.example.herocat.wtlock.utils.StringUtil;
import com.example.herocat.wtlock.utils.ToastUtil;

public class LoginActivity extends WTBaseActivity {

    private EditText phoneEdit, pswEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login, null, "用户登录", null);
        initView();
    }

    private void initView() {
        phoneEdit = findViewById(R.id.phone);
        pswEdit = findViewById(R.id.psw);
        findViewById(R.id.login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.login:
                login();
                break;
        }
    }

    private void login() {

        String account = phoneEdit.getText().toString();
        String password = pswEdit.getText().toString();

        if (StringUtil.isEmpty(account)) {
            ToastUtil.toast("请输入手机号");
        } else if (account.length() != 11) {
            ToastUtil.toast("请输入正确的手机号");
        } else if (StringUtil.isEmpty(password)) {
            ToastUtil.toast("请输入密码");
        } else {
            ACAccountMgr accountMgr = AC.accountMgr();
            accountMgr.login(account, password, new PayloadCallback<ACUserInfo>() {
                @Override
                public void success(ACUserInfo userInfo) {
                    //获得用户userId和nickName，由此进入主页
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }

                @Override
                public void error(ACException e) {
                    //网络错误或其他，根据e.getErrorCode()做不同的提示或处理
                    LogUtil.i(e.getErrorCode() + "=" + e.getDescription());
                }
            });
        }

    }

}
