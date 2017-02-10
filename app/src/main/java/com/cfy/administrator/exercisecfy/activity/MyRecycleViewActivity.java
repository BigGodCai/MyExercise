package com.cfy.administrator.exercisecfy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cfy.administrator.exercisecfy.R;
import com.cfy.administrator.exercisecfy.adapter.MyRecycleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyRecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Map<String,Object>> mList;
    private MyRecycleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        mList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 50; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("tv",i+"......");
            mList.add(map);
        }
        adapter = new MyRecycleAdapter(this,mList);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
    }
}
