package com.example.androidpractice06_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MineFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(
                "👤 【我的】个人中心\n\n" +
                        "用户名：User_2026\n" +
                        "等级：Lv.5 资深用户\n" +
                        "积分：12800\n\n" +
                        "设置 | 收藏 | 历史 | 反馈\n\n" +
                        "(点击登录/注册)"
        );
        textView.setTextSize(16);
        textView.setPadding(40, 40, 40, 40);
        textView.setTextColor(0xFF333333);

        return textView;
    }
}