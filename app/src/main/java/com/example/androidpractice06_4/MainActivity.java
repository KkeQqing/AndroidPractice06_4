package com.example.androidpractice06_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

public class MainActivity extends FragmentActivity {

    // 定义 Tab 配置
    private static final String[] TAB_TITLES = {"新闻", "阅读", "视频", "发现", "我的"};

    // 对应你的 Fragment 类对象
    private static final Class<?>[] TAB_FRAGMENTS = {
            NewsFragment.class,
            ReadFragment.class,
            VideoFragment.class,
            DiscoverFragment.class,
            MineFragment.class
    };

    // 图标资源数组
    private static final int[] TAB_ICONS_NORMAL = {
            R.drawable.ic_news_normal,
            R.drawable.ic_read_normal,
            R.drawable.ic_video_normal,
            R.drawable.ic_discover_normal,
            R.drawable.ic_mine_normal
    };
    private static final int[] TAB_ICONS_SELECTED = {
            R.drawable.ic_news_selected,
            R.drawable.ic_read_selected,
            R.drawable.ic_video_selected,
            R.drawable.ic_discover_selected,
            R.drawable.ic_mine_selected
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 初始化 FragmentTabHost
        FragmentTabHost tabHost = findViewById(android.R.id.tabhost);

        // setup 方法参数：上下文，FragmentManager，容器ID
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        // 2. 循环添加 Tab
        for (int i = 0; i < TAB_TITLES.length; i++) {
            //  inflate 自定义的 tab_item 布局
            View tabView = LayoutInflater.from(this).inflate(R.layout.tab_item, null);

            ImageView icon = tabView.findViewById(R.id.tab_icon);
            TextView text = tabView.findViewById(R.id.tab_text);

            // 设置默认状态（未选中）
            icon.setImageResource(TAB_ICONS_NORMAL[i]);
            text.setText(TAB_TITLES[i]);
            text.setTextColor(getResources().getColor(android.R.color.darker_gray, null));

            // 创建 TabSpec 并添加
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(TAB_TITLES[i]).setIndicator(tabView);
            tabHost.addTab(tabSpec, TAB_FRAGMENTS[i], null);
        }

        // 3. 设置监听器，处理切换时的图标变色
        tabHost.setOnTabChangedListener(tabId -> {
            int currentTab = tabHost.getCurrentTab(); // 获取当前选中的索引

            // 遍历所有 Tab，重置状态
            for (int i = 0; i < TAB_TITLES.length; i++) {
                // 获取第 i 个 Tab 的视图
                View tabView = tabHost.getTabWidget().getChildTabViewAt(i);
                ImageView icon = tabView.findViewById(R.id.tab_icon);
                TextView text = tabView.findViewById(R.id.tab_text);

                if (i == currentTab) {
                    // 选中状态
                    icon.setImageResource(TAB_ICONS_SELECTED[i]);
                    text.setTextColor(getResources().getColor(android.R.color.holo_red_light, null));
                } else {
                    // 未选中状态
                    icon.setImageResource(TAB_ICONS_NORMAL[i]);
                    text.setTextColor(getResources().getColor(android.R.color.darker_gray, null));
                }
            }
        });

        // 4. 默认选中第一个 (其实默认就是0，但这行代码可以触发一次监听逻辑确保图标正确)
        tabHost.setCurrentTab(0);
    }
}