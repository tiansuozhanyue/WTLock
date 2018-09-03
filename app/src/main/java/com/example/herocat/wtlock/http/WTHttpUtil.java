package com.example.herocat.wtlock.http;

import com.accloud.cloudservice.AC;
import com.accloud.cloudservice.PayloadCallback;
import com.accloud.service.ACException;
import com.accloud.service.ACMsg;
import com.example.herocat.wtlock.utils.AppUtil;
import com.example.herocat.wtlock.utils.LogUtil;

import java.util.Map;

public class WTHttpUtil {

    //    private static String SUBDOMAIN = "wangtong";
    private static String SUBDOMAIN = "";
    private static String NAME = "Demo";
    private static int VERSION = 1;

    public static void request(String faction, Map<String, String> map, final WTCallBack wtCallBack) {
        ACMsg req = new ACMsg();
        req.setName(faction);
        LogUtil.i("---> faction  :  " + faction);
        if (map != null && map.size() > 0)
            for (String key : map.keySet()) {
                req.put(key, map.get(key));
                LogUtil.i("--->" + key + "  :  " + map.get(key));
            }
        AC.sendToService(NAME, VERSION, req, new PayloadCallback<ACMsg>() {
            @Override
            public void success(ACMsg resp) {
                //发送成功并接收服务的响应消息
                if (wtCallBack != null) {
                    LogUtil.i("请求成功--->" + resp.toString());
                    wtCallBack.success(resp);
                }
            }

            @Override
            public void error(ACException e) {
                //网络错误或其他，根据e.getErrorCode()做不同的提示或处理
                if (wtCallBack != null) {
                    LogUtil.i("请求错误--->" + e.getErrorCode() + " = " + e.getMessage());
                    wtCallBack.error(e);
                }
            }
        });

    }

    public interface WTCallBack {
        void success(ACMsg resp);

        void error(ACException e);
    }

}
