package com.example.herocat.wtlock.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.accloud.service.ACException;
import com.accloud.service.ACMsg;
import com.example.herocat.wtlock.R;
import com.example.herocat.wtlock.base.WTBaseActivity;
import com.example.herocat.wtlock.bean.ActionBean;
import com.example.herocat.wtlock.bean.LockBean;
import com.example.herocat.wtlock.dapter.ActionListAdapter;
import com.example.herocat.wtlock.http.WTHttpUtil;
import com.example.herocat.wtlock.utils.AppUtil;
import com.example.herocat.wtlock.utils.ToastUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionListActivity extends WTBaseActivity implements WTHttpUtil.WTCallBack {

    private ListView listView;
    private ActionListAdapter<ActionBean.PayloadBean> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_locklist, this, "操作记录", null);
        listView = findViewById(R.id.list);
        startLoading();
        getDownList();
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

    private void getDownList() {
        WTHttpUtil.request("GetDownList", null, this);
    }

    @Override
    public void success(ACMsg resp) {
        Gson gson = new Gson();
        ActionBean bean = gson.fromJson(resp.toString(), ActionBean.class);
        if (bean != null && bean.getPayload() != null) {
            adapter = new ActionListAdapter(this, bean.getPayload());
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
