package com.example.learnandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnandroid.RecyclerView.Activity.Fragment.FragmentActivityTest;
import com.example.learnandroid.RecyclerView.Activity.Test2Activity;
import com.example.learnandroid.RecyclerView.Activity.TestActivity;
import com.example.learnandroid.RecyclerView.Activity.Transition.TransitionActivity;
import com.example.learnandroid.RecyclerView.Adapter.MainRecycleViewAdapter;
import com.example.learnandroid.RecyclerView.Data.MainRecycleViewItemData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MainRecycleViewItemData> data = new ArrayList<>();

    private static String TEST_DATA_STRING = "testDataString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initItemData();
        RecyclerView recyclerView = findViewById(R.id.main_RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MainRecycleViewAdapter adapter = new MainRecycleViewAdapter(data);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClick((v, i) -> {
            Intent intent = new Intent();
            switch (i) {
                case 0:
                    intent.setClass(v.getContext(), TestActivity.class);
                    intent.putExtra(TEST_DATA_STRING, "TestData");
                    break;
                case 1:
                    Test2Activity.actionStart(MainActivity.this, "后面activity启动", "");
                    return;
                case 2:
                    Intent intentV = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.baidu.com"));
                    v.getContext().startActivity(intentV);
                    return;
                case 3:
                    intent.setClass(MainActivity.this, TestActivity.class);
                    intent.putExtra(TEST_DATA_STRING, "startActivityForResult");
                    startActivityForResult(intent, 1);
                    return;
                case 4:
                    intent.setClass(MainActivity.this, TransitionActivity.class);
                    intent.putExtra(TEST_DATA_STRING, "TransitionActivity");
                    break;
                case 5:
                    intent.setClass(MainActivity.this, FragmentActivityTest.class);
                    break;
                default:
                    break;
            }
            v.getContext().startActivity(intent);
        });
    }


    private void initItemData() {
        data.add(new MainRecycleViewItemData("TestActivity", "this is for test TestActivity"));
        data.add(new MainRecycleViewItemData("TestActivity2", "this is for test actionstart"));
        data.add(new MainRecycleViewItemData("开启手机browser", "this is for 隐式浏览器"));
        data.add(new MainRecycleViewItemData("TestActivity", "this is for 有回调返回"));
        data.add(new MainRecycleViewItemData("TransitionActivity", "this is for TransitionActivity"));
        data.add(new MainRecycleViewItemData("Fragment", "this is for Fragment"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            String returnData = data.getStringExtra(TEST_DATA_STRING);
            Toast.makeText(this, returnData, Toast.LENGTH_LONG).show();
        }
    }
}
