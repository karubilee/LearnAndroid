package com.example.learnandroid.RecyclerView.Activity.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.learnandroid.R;
import com.example.learnandroid.RecyclerView.Activity.BaseActivity;

import butterknife.OnClick;

public class FragmentActivityTest extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_fragment;
    }

    @Override
    protected void setupUI() {
        replaceFragment(new RightFragment());
    }

    @OnClick(R.id.fragment_btn)
    public void onButtonClick() {
        replaceFragment(new AnotherRightFragment());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_fragment, fragment);
        if (fragment.getClass() != RightFragment.class){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
