package com.zdsoft.testswipeview;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends Activity {
//声明变量
    ListView lv ;
    SwipeRefreshLayout swipeView;

    //数据源
    ArrayList<String> datas = new ArrayList<String>();
    //适配器
    ArrayAdapter adapter ;

    boolean flg = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        lv = (ListView) findViewById(R.id.lv);
        swipeView = (SwipeRefreshLayout) findViewById(R.id.swipeView);
        getData();
        //创建适配器对象
        adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,datas);
        //设置适配器
        lv.setAdapter(adapter);

        //以下代码是对SwipeView的操作
        //修改进度条的背景颜色
        swipeView.setProgressBackgroundColorSchemeColor(Color.GRAY);
        //修改进度条的颜色
        swipeView.setColorSchemeColors(Color.YELLOW,Color.GREEN);
        //为swipeView设置下拉监听
        swipeView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                datas.clear();
                if(flg)
                {
                    refresh();
                }else
                {
                    getData();
                }
                adapter.notifyDataSetChanged();
                flg = !flg ;
                //刷新结束，关闭刷新效果
                swipeView.setRefreshing(false);
            }
        });
    }

    private void getData() {
        datas.add("武汉");
        datas.add("重庆");
        datas.add("上海");
        datas.add("漠河");
        datas.add("杭州");
        datas.add("苏州");
        datas.add("海南");
    }

    private void refresh() {
        datas.add("热干面，周黑鸭");
        datas.add("火锅，小面");
        datas.add("房价，虾饺");
        datas.add("冻豆腐");
        datas.add("丝绸，西湖，马云");
        datas.add("美女");
        datas.add("椰子，阳光，槟榔");
    }
}
