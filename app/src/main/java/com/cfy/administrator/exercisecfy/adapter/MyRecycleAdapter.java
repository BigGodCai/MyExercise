package com.cfy.administrator.exercisecfy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cfy.administrator.exercisecfy.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/3.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyHolder> {
    private Context mContext;
    private List<Map<String,Object>> mList;

    public MyRecycleAdapter(Context context, List<Map<String, Object>> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(mContext).inflate(R.layout.item_recycle,parent,false);
        MyHolder myHolder = new MyHolder(vi);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tv.setText(mList.get(position).get("tv").toString());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView tv ;
        public MyHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }
}
