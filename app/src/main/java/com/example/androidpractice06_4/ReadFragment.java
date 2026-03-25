package com.example.androidpractice06_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ReadFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 创建一个 TextView 作为页面内容
        TextView textView = new TextView(getContext());
        textView.setText(
                "📚 【阅读】板块\n\n" +
                        "1. 《2026年技术展望》连载...\n" +
                        "2. 经典文学：《三体》重读计划\n" +
                        "3. 每日英语：科技词汇积累\n" +
                        "4. 深度好文：碎片化时代的思考\n\n" +
                        "(此处可接入具体的文章列表 API)"
        );
        textView.setTextSize(16);
        textView.setPadding(40, 40, 40, 40);
        textView.setTextColor(0xFF333333); // 深灰色文字

        return textView;
    }
}