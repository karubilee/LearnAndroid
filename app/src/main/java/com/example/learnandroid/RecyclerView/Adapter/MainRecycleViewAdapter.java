package com.example.learnandroid.RecyclerView.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnandroid.R;
import com.example.learnandroid.RecyclerView.Data.MainRecycleViewItemData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainRecycleViewAdapter extends RecyclerView.Adapter<MainRecycleViewAdapter.ViewHolder> {

    private List<MainRecycleViewItemData> mRecycleViewItemData;
    private OnItemClick onItemClick;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.main_RecyclerView_item_title)
        TextView titleTextView;
        @BindView(R.id.main_RecyclerView_item_detail)
        TextView detailTextView;

        private ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public MainRecycleViewAdapter(List<MainRecycleViewItemData> data) {
        mRecycleViewItemData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_recycleview_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MainRecycleViewItemData data = mRecycleViewItemData.get(i);
        viewHolder.titleTextView.setText(data.getTitle());
        viewHolder.detailTextView.setText(data.getDetail());
        viewHolder.itemView.setOnClickListener(v -> {
            onItemClick.onItemClick(v, i);
        });
    }

    @Override
    public int getItemCount() {
        return mRecycleViewItemData.size();
    }

    public interface OnItemClick {
        void onItemClick(View view, int position);
    }

    public void setOnItemClick(OnItemClick itemClick) {
        this.onItemClick = itemClick;
    }

}
