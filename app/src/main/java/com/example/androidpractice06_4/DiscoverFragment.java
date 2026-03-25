package com.example.androidpractice06_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DiscoverFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText(
                "🧭 【发现】板块\n\n" +
                        "🔥 今日热搜榜\n" +
                        "📍 附近的活动与聚会\n" +
                        "💡 新奇科技产品推荐\n" +
                        "🎁 限时优惠活动\n\n" +
                        "(探索未知的世界)"
        );
        textView.setTextSize(16);
        textView.setPadding(40, 40, 40, 40);
        textView.setTextColor(0xFF333333);

        return textView;
    }
}