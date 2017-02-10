package com.cfy.administrator.exercisecfy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cfy.administrator.exercisecfy.activity.CardViewActivity;
import com.cfy.administrator.exercisecfy.activity.MyRecycleViewActivity;
import com.cfy.administrator.exercisecfy.activity.MySpinnerActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private List<String> mList;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

    }

    private void init() {
        intent = new Intent();
        mList = new ArrayList<String>();
        loadData();
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setOnItemClickListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,mList){
            @Override
            public boolean isEnabled(int position) {
                return super.isEnabled(position);
            }

            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = (TextView) super.getView(position, convertView, parent);
                if(tv.getText().toString().contains("#")){
                    tv.setGravity(Gravity.CENTER);
                } else {
                    tv.setGravity(Gravity.LEFT);
                }
                return tv;
            }
        };
        mListView.setAdapter(adapter);

    }

    private void loadData() {
        mList.add("#汇总页面");
        mList.add("RecycleView");
        mList.add("spinner三级联动");
        mList.add("CardView");
    }

    @Override
    public void onItemClick(AdapterView<?> view, View view1, int i, long l) {
        if(mList.get(i).equals("RecycleView")){
            intent.setClass(this,MyRecycleViewActivity.class);
            startActivity(intent);
        }

        if(mList.get(i).equals("spinner三级联动")){
            intent.setClass(this,MySpinnerActivity.class);
            startActivity(intent);
        }
        if(mList.get(i).equals("CardView")){
            intent.setClass(this,CardViewActivity.class);
            startActivity(intent);
        }
    }
}
