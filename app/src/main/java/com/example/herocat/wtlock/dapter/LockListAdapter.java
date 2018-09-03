package com.example.herocat.wtlock.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.herocat.wtlock.R;
import com.example.herocat.wtlock.bean.LockBean;

import java.util.List;

public class LockListAdapter extends BaseAdapter {

    private Context context;
    private List<LockBean.PayloadBean._$1Bean.ListBean> listBeans;

    public LockListAdapter(Context context, List<LockBean.PayloadBean._$1Bean.ListBean> listBeans) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.adpater_lock_list_item, null);
        ImageView lock_image = view.findViewById(R.id.lock_image);
        TextView lock_name = view.findViewById(R.id.lock_name);

        LockBean.PayloadBean._$1Bean.ListBean listBean = listBeans.get(position);
        lock_image.setImageResource("10".equals(listBean.getStatus()) ? R.mipmap.lock_open : R.mipmap.lock_close);
        lock_name.setText(listBean.getDeviceName());

        return view;
    }
}
