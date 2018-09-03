package com.example.herocat.wtlock.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.accloud.cloudservice.AC;
import com.accloud.cloudservice.PayloadCallback;
import com.accloud.service.ACException;
import com.accloud.service.ACMsg;
import com.accloud.service.ACObject;
import com.example.herocat.wtlock.R;
import com.example.herocat.wtlock.base.WTBaseActivity;
import com.example.herocat.wtlock.bean.LockBean;
import com.example.herocat.wtlock.http.WTHttpUtil;
import com.example.herocat.wtlock.utils.AppUtil;
import com.example.herocat.wtlock.utils.LogUtil;
import com.example.herocat.wtlock.utils.ToastUtil;

import java.util.HashMap;
import java.util.Map;

public class OpenLockActivity extends WTBaseActivity implements WTHttpUtil.WTCallBack, CompoundButton.OnCheckedChangeListener {

    private TextView open_button, location, power, name;
    private LockBean.PayloadBean._$1Bean.ListBean lockBean;
    private boolean lock_open;
    private Switch swith_lock;
    private boolean isClickAble = true;
    private boolean swith_open;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_lock, this, "望通智能锁", this);
        initView();
//        startLoading();
//        saveBLEData();
    }

    private void initView() {

        lockBean = (LockBean.PayloadBean._$1Bean.ListBean) getIntent().getSerializableExtra("lockBean");

        open_button = findViewById(R.id.open_lock);
        location = findViewById(R.id.location);
        power = findViewById(R.id.power);
        name = findViewById(R.id.name);
        swith_lock = findViewById(R.id.swith_lock);

        location.setText(lockBean.getDetail());
        power.setText(lockBean.getPower() + "%");
        name.setText(lockBean.getDeviceName());
        open_button.setBackgroundResource("10".equals(lockBean.getStatus()) ? R.drawable.shape_button_blue : R.drawable.shape_button_gray);

        findViewById(R.id.tip_button).setOnClickListener(this);
        findViewById(R.id.open_lock_temporary).setOnClickListener(this);
        open_button.setOnClickListener(this);
        swith_lock.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {

            case R.id.title_left://返回
                finish();
                break;

            case R.id.title_right://刷新
//                startLoading();
//                saveBLEData();
                break;

            case R.id.open_lock://开锁
                if (isClickAble) {
                    if (lock_open) {
                        open_button.setBackgroundResource(R.drawable.shape_button_blue);
                        open_button.setText("关锁");
                    } else {
                        open_button.setBackgroundResource(R.drawable.shape_button_gray);
                        open_button.setText("开锁");
                    }
                    lock_open = !lock_open;

                    if (swith_open) {
                        isClickAble = false;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                isClickAble = true;
                            }
                        }, 5000);
                    }

                }
                break;

            case R.id.open_lock_temporary://临时开锁码
                Intent intent = new Intent(this, OpenLockCodeActivity.class);
                intent.putExtra("lockBean", lockBean);
                startActivity(intent);
                break;

            case R.id.tip_button://报警记录
                Intent intent1 = new Intent(this, TipListActivity.class);
                intent1.putExtra("lockBean", lockBean);
                startActivity(intent1);
                break;

        }
    }

    private void saveBLEData() {
        Map<String, String> map = new HashMap<>();
        map.put("DeviceMAC", lockBean.getDeviceMAC());
        map.put("Data", "FA0B010166484533015089");
        WTHttpUtil.request("SaveBLEData", map, this);
    }

    @Override
    public void success(ACMsg resp) {
        endLoading();
    }

    @Override
    public void error(ACException e) {
        endLoading();
        ToastUtil.toast(e.getMessage());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        swith_open = isChecked;
        isClickAble = true;
    }
}
