package com.example.androidpractice06_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> newsList = new ArrayList<>();
    // 线程池用于网络请求，避免阻塞主线程
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 动态创建一个 ListView 作为视图，也可以单独建 xml
        listView = new ListView(getContext());

        // 初始化适配器
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, newsList);
        listView.setAdapter(adapter);

        // 添加一个加载提示
        newsList.add("正在加载最新新闻...");
        adapter.notifyDataSetChanged();

        // 启动网络请求
        loadNewsFromInternet();

        return listView;
    }

    private void loadNewsFromInternet() {
        executor.execute(() -> {
            try {
                // 这里使用一个免费的测试接口 (今日头条示例接口，若失效可更换)
                // 注意：实际开发中请使用后端提供的稳定接口
                String urlString = "https://api.tianapi.com/general/?key=YOUR_KEY&num=10";
                // 由于上面需要Key，我们这里模拟一个不需要Key的公共测试源，或者手动模拟数据延迟
                // 为了演示效果，我们这里模拟网络延迟并返回假数据，
                // 如果你有真实接口，请替换下面的逻辑

                // --- 模拟网络延迟 ---
                Thread.sleep(1500);

                // --- 模拟返回的数据 ---
                List<String> mockData = new ArrayList<>();
                mockData.add("[热点] 2026年人工智能技术取得新突破");
                mockData.add("[科技] 火星移民计划正式启动首批选拔");
                mockData.add("[体育] 世界杯预选赛中国队精彩集锦");
                mockData.add("[财经] 全球股市今日大幅震荡");
                mockData.add("[娱乐] 最新科幻电影票房破纪录");

                // 如果你想尝试真实网络请求，可以使用下面注释的代码（需替换有效URL）
                /*
                URL url = new URL("你的新闻API地址");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5000);

                if (conn.getResponseCode() == 200) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                    // 这里需要用 Gson 解析 JSON，提取 title 字段加入 mockData
                    // 解析逻辑略...
                }
                */

                // 更新 UI 必须在主线程
                getActivity().runOnUiThread(() -> {
                    newsList.clear();
                    newsList.addAll(mockData);
                    adapter.notifyDataSetChanged();
                });

            } catch (Exception e) {
                e.printStackTrace();
                getActivity().runOnUiThread(() -> {
                    newsList.clear();
                    newsList.add("加载失败，请检查网络");
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getContext(), "网络错误：" + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}