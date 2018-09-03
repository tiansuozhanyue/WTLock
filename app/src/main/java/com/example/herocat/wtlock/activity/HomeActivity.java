package com.example.herocat.wtlock.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.accloud.service.ACException;
import com.accloud.service.ACMsg;
import com.example.herocat.wtlock.R;
import com.example.herocat.wtlock.base.WTBaseActivity;
import com.example.herocat.wtlock.bean.LockBean;
import com.example.herocat.wtlock.dapter.LockListAdapter;
import com.example.herocat.wtlock.http.WTHttpUtil;
import com.example.herocat.wtlock.utils.ToastUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends WTBaseActivity implements WTHttpUtil.WTCallBack, AdapterView.OnItemClickListener {

    private GridView gridView;
    private LockListAdapter listAdapter;
    private TextView location;
    private List<LockBean.PayloadBean._$1Bean.ListBean> listBeans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home, null, "望通智能锁", this);
        initView();
    }

    private void initView() {
        findViewById(R.id.open_history).setOnClickListener(this);
        gridView = findViewById(R.id.lockList);
        location = findViewById(R.id.location);
        listBeans = new ArrayList<>();
        listAdapter = new LockListAdapter(this, listBeans);
        gridView.setAdapter(listAdapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startLoading();
        listBeans.clear();
        getDevices();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.title_right://刷新
                startLoading();
                listBeans.clear();
                getDevices();
                break;
            case R.id.open_history://开锁记录
                startActivity(new Intent(this, ActionListActivity.class));
                break;
        }
    }

    private void getDevices() {
        Map<String, String> map = new HashMap<>();
        map.put("DeviceMAC", "112233445566");
        WTHttpUtil.request("GetDevices", map, this);
    }

    @Override
    public void success(ACMsg resp) {
        Gson gson = new Gson();
        LockBean lockBean = gson.fromJson(resp.toString(), LockBean.class);
        listBeans.addAll(lockBean.getPayload().get_$1().getList());
        listAdapter.notifyDataSetChanged();
        location.setText(lockBean.getPayload().get_$1().getDetail());
        endLoading();
    }

    @Override
    public void error(ACException e) {
        endLoading();
        ToastUtil.toast(e.getMessage());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        LockBean.PayloadBean._$1Bean.ListBean listBean = listBeans.get(position);
        Intent intent = new Intent(this, OpenLockActivity.class);
        intent.putExtra("lockBean", listBean);
        startActivity(intent);
    }

}
