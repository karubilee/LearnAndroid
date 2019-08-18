package com.example.learnandroid.RecyclerView.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnandroid.R;

public class Test2Activity extends AppCompatActivity {

    public static void actionStart(Context context, String str1, String str2) {
        Intent intent = new Intent(context, Test2Activity.class);
        intent.putExtra("param1", str1);
        intent.putExtra("param2", str2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        Intent intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("param1") + intent.getStringExtra("param2"), Toast.LENGTH_LONG).show();
    }

}
