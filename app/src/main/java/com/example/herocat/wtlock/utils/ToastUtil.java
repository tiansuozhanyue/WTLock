package com.example.herocat.wtlock.utils;

import android.widget.Toast;

import com.example.herocat.wtlock.WTAplication;

public class ToastUtil {

    public static void toast(String info) {
        Toast.makeText(WTAplication.getContext(), info, Toast.LENGTH_SHORT);
    }

}
