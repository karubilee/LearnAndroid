package com.example.learnandroid.RecyclerView.Activity.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.learnandroid.R;
import com.example.learnandroid.RecyclerView.Activity.BaseActivity;

import butterknife.OnClick;

public class BroadCastActivity extends BaseActivity {

    private IntentFilter mIntentFilter = null;

    private MyBroadcastReceiver mMyBroadcastRecvier = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        broadcast();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //broadcast
    private void broadcast(){
        //过滤器
        mIntentFilter = new IntentFilter("com.example.broadcasttest.My_BROADCAST");
        //创建广播接收者的对象
        mMyBroadcastRecvier =  new MyBroadcastReceiver();
        //注册广播接收者的对象
        registerReceiver(mMyBroadcastRecvier, mIntentFilter);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_broadcast;
    }

    @Override
    protected void setupUI() {

    }

    @OnClick(R.id.send_broad_cast)
    public void OnClick(){
        Intent intent1 = new Intent("com.example.broadcasttest.My_BROADCAST");
        sendBroadcast(intent1);
    }

}
