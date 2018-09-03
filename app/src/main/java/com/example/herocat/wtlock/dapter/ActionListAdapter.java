package com.example.herocat.wtlock.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.herocat.wtlock.R;
import com.example.herocat.wtlock.bean.ActionBean;
import com.example.herocat.wtlock.bean.LockBean;
import com.example.herocat.wtlock.bean.TipBean;
import com.example.herocat.wtlock.utils.StringUtil;
import com.example.herocat.wtlock.widget.WTLineTextView;

import java.util.List;

public class ActionListAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> listBeans;

    public ActionListAdapter(Context context, List<T> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @Override
    public int getCount() {
        return listBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return listBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adpater_action_list_item, null);
        WTLineTextView textView = view.findViewById(R.id.action_item);
        T t = listBeans.get(position);
        if (t instanceof TipBean.PayloadBean) {
            TipBean.PayloadBean listBean = (TipBean.PayloadBean) t;
            textView.setLeftText(listBean.getDescription());
            textView.setRightText(fomateTime(listBean.getCreateTime()));
        } else {
            ActionBean.PayloadBean actionBean = (ActionBean.PayloadBean) t;
            textView.setLeftText(actionBean.getDeviceName());
            textView.setRightText(fomateTime(actionBean.getCreateTime()));
        }

        return view;
    }

    // 2018-08-31 12:12:12 789
    private String fomateTime(String time) {
        StringBuffer buffer = new StringBuffer();
        if (!StringUtil.isEmpty(time)) {
            String[] times = time.split(" ");
            String[] times2 = times[1].split(":");
            buffer.append(times[0].replace("-", ".") + " ");
            buffer.append(times2[0] + ":");
            buffer.append(times2[1]);
        }
        return buffer.toString();
    }

}
