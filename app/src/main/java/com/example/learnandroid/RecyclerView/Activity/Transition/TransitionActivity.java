package com.example.learnandroid.RecyclerView.Activity.Transition;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import com.example.learnandroid.R;
import com.example.learnandroid.RecyclerView.Activity.BaseActivity;

import butterknife.OnClick;

public class TransitionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_transition;
    }

    @Override
    protected void setupUI() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.transition_button)
    public void onButtonClickPendingTransition() {
        Intent intent = new Intent(TransitionActivity.this, TransitionActivity2.class);
        startActivity(intent);
        overridePendingTransition(R.animator.slide_in_right, R.animator.slide_out_left);
    }

    @OnClick({R.id.transition_button1, R.id.transition_button2, R.id.transition_button3})
    public void onButtonClick(View v) {
        switch (v.getId()) {
            //https://blog.csdn.net/qq_37043246/article/details/77838450
            case R.id.transition_button1:
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeCustomAnimation(this,R.animator.slide_in_right,R.animator.slide_out_left);
                ActivityCompat.startActivity(this, new Intent(this,TransitionActivity2.class),compat.toBundle());
                break;
            case R.id.transition_button2:
                break;
            case R.id.transition_button3:
                break;
        }
    }
}
