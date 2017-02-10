package com.cfy.administrator.exercisecfy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.cfy.administrator.exercisecfy.R;
import com.cfy.administrator.exercisecfy.adapter.MyCardViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyCardViewAdapter adapter;
    private List<Map<String,Object>> mList;
    private int[] imgs = {R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4,
                         R.mipmap.a5,R.mipmap.a6,R.mipmap.a7,
                         R.mipmap.a8,R.mipmap.a9,R.mipmap.a10,R.mipmap.a11,R.mipmap.a12,
                         R.mipmap.a13,R.mipmap.a14,R.mipmap.a15};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        init();
    }

    private void init() {
        mList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            Map map = new HashMap();
            map.put("img",imgs[i]);
            map.put("tv","人物"+(i+1));
            mList.add(map);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        adapter = new MyCardViewAdapter(this,mList);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(layoutManager);
    }
}
