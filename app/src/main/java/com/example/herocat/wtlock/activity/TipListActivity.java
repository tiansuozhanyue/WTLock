package com.example.herocat.wtlock.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.accloud.service.ACException;
import com.accloud.service.ACMsg;
import com.example.herocat.wtlock.R;
import com.example.herocat.wtlock.base.WTBaseActivity;
import com.example.herocat.wtlock.bean.LockBean;
import com.example.herocat.wtlock.bean.TipBean;
import com.example.herocat.wtlock.dapter.ActionListAdapter;
import com.example.herocat.wtlock.http.WTHttpUtil;
import com.example.herocat.wtlock.utils.AppUtil;
import com.example.herocat.wtlock.utils.ToastUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TipListActivity extends WTBaseActivity implements WTHttpUtil.WTCallBack {

    private ListView listView;
    private ActionListAdapter<TipBean.PayloadBean> adapter;
    private LockBean.PayloadBean._$1Bean.ListBean lockBean;
    private TextView lock_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiplist, this, "报警记录", null);
        initView();
        startLoading();
        getWarnList();
    }

    private void initView() {
        lockBean = (LockBean.PayloadBean._$1Bean.ListBean) getIntent().getSerializableExtra("lockBean");
        listView = findViewById(R.id.list);
        lock_name = findViewById(R.id.lock_name);

        lock_name.setText(lockBean.getDeviceName());

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

    private void getWarnList() {
        Map<String, String> map = new HashMap<>();
        map.put("DeviceMAC", lockBean.getDeviceMAC());
        WTHttpUtil.request("GetWarnList", map, this);

    }

    @Override
    public void success(ACMsg resp) {
        Gson gson = new Gson();
        TipBean tipBean = gson.fromJson(resp.toString(), TipBean.class);
        if (tipBean != null && tipBean.getPayload() != null) {
            adapter = new ActionListAdapter(this, tipBean.getPayload());
            listView.setAdapter(adapter);
        }
        endLoading();
    }

    @Override
    public void error(ACException e) {
        endLoading();
        ToastUtil.toast(e.getMessage());
    }

}
