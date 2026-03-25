package com.example.androidpractice06_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(
                "🎬 【视频】板块\n\n" +
                        "▶️ 热门短视频推荐\n" +
                        "▶️ 4K 纪录片：地球脉动\n" +
                        "▶️ 用户原创：我的编程日常\n" +
                        "▶️ 直播回放：昨晚的技术峰会\n\n" +
                        "(此处可接入视频流媒体列表)"
        );
        textView.setTextSize(16);
        textView.setPadding(40, 40, 40, 40);
        textView.setTextColor(0xFF333333);

        return textView;
    }
}