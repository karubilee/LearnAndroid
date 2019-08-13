package com.example.learnandroid.RecyclerView.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.learnandroid.R;
import com.example.learnandroid.RecyclerView.Data.MainRecycleViewItemData;

import java.util.List;


public class MainRecycleViewAdapter extends RecyclerView.Adapter<MainRecycleViewAdapter.ViewHolder> {

    private List<MainRecycleViewItemData> mRecycleViewItemData;


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView detailTextView;

        public ViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.main_RecyclerView_item_title);
            detailTextView = view.findViewById(R.id.main_RecyclerView_item_detail);
        }
    }

    public MainRecycleViewAdapter(List<MainRecycleViewItemData> data){
        mRecycleViewItemData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_recycleview_item,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MainRecycleViewItemData data = mRecycleViewItemData.get(i);
        viewHolder.titleTextView.setText(data.getTitle());
        viewHolder.detailTextView.setText(data.getDetail());
    }

    @Override
    public int getItemCount() {
        return mRecycleViewItemData.size();
    }

}
