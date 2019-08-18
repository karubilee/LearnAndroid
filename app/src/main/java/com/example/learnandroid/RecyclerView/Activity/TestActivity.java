package com.example.learnandroid.RecyclerView.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.learnandroid.R;

import butterknife.BindView;

public class TestActivity extends BaseActivity {

    @BindView(R.id.return_button)
    Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String data = intent.getStringExtra(TEST_DATA_STRING);
        Log.d(this.getClass().getSimpleName(), data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.test_activity;
    }

    @Override
    protected void setupUI() {
        returnButton.setOnClickListener(btn -> {
            Intent intentResult = new Intent();
            intentResult.putExtra(TEST_DATA_STRING, "返回值");
            setResult(RESULT_OK, intentResult);
            finish();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "Add", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "Remove", Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intentResult = new Intent();
        intentResult.putExtra(TEST_DATA_STRING, "返回值");
        setResult(RESULT_OK, intentResult);
        finish();
    }
}
