package com.example.herocat.wtlock.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.accloud.cloudservice.AC;
import com.accloud.service.ACAccountMgr;
import com.example.herocat.wtlock.R;

public class LuncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luncher);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initAction();
            }
        }, 1500);

    }

    private void initAction() {
        ACAccountMgr accountMgr = AC.accountMgr();
        if (accountMgr.isLogin()) { //由此进入主页
            startActivity(new Intent(this, HomeActivity.class));
//            startActivity(new Intent(this, LoginActivity.class));
        } else {  //提示让用户输入用户名及密码
            startActivity(new Intent(this, LoginActivity.class));
        }
        finish();
    }

}
