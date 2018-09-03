package com.example.herocat.wtlock.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.accloud.service.ACException;
import com.accloud.service.ACMsg;
import com.accloud.service.ACObject;
import com.example.herocat.wtlock.R;
import com.example.herocat.wtlock.base.WTBaseActivity;
import com.example.herocat.wtlock.bean.LockBean;
import com.example.herocat.wtlock.bean.LockCodeBean;
import com.example.herocat.wtlock.http.WTHttpUtil;
import com.example.herocat.wtlock.utils.ToastUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class OpenLockCodeActivity extends WTBaseActivity implements WTHttpUtil.WTCallBack {

    private LockBean.PayloadBean._$1Bean.ListBean lockBean;
    private TextView open_lock_code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_lock_code, this, "望通智能锁", null);
        lockBean = (LockBean.PayloadBean._$1Bean.ListBean) getIntent().getSerializableExtra("lockBean");
        open_lock_code = findViewById(R.id.open_lock_code);
        startLoading();
        getPinCode();

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {

            case R.id.title_left://返回
                finish();
                break;

        }
    }

    private void getPinCode() {
        Map<String, String> map = new HashMap<>();
        map.put("DeviceMAC", lockBean.getDeviceMAC());
        WTHttpUtil.request("GetPinCode", map, this);
    }

    @Override
    public void success(ACMsg resp) {
        Gson gson = new Gson();
        LockCodeBean codeBean = gson.fromJson(resp.toString(), LockCodeBean.class);
        open_lock_code.setText(codeBean.getPayload().getPinCode());
        endLoading();
    }

    @Override
    public void error(ACException e) {
        endLoading();
        ToastUtil.toast(e.getMessage());
    }
}
