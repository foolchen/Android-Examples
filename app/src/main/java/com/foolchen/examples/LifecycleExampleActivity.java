package com.foolchen.examples;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.util.Date;

import static com.foolchen.examples.Utils.color;
import static com.foolchen.examples.Utils.logi;
import static com.foolchen.examples.Utils.logv;
import static com.foolchen.examples.Utils.toHtml;

/**
 * 生命周期演示
 *
 * @author chenchong
 *         2017/4/19
 *         上午9:20
 */

public class LifecycleExampleActivity extends AppCompatActivity {
  private static final String TAG = "LifecycleExampleActivity";
  private static final String KEY_DATA = "data";
  private final StringBuilder mBuilder = new StringBuilder();
  private TextView mTextView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    logv("onCreate");

    setContentView(R.layout.activity_lifecycle_example);
    mTextView = (TextView) findViewById(R.id.textview);

    if (savedInstanceState != null) {
      mBuilder.append(savedInstanceState.getString(KEY_DATA));
    }
    mBuilder.append(new Date()).append(" onCreate").append("<br/>");
  }

  @Override protected void onRestart() {
    super.onRestart();
    logv("onRestart");
    mBuilder.append(new Date()).append(" onRestart").append("<br/>");
  }

  @Override protected void onStart() {
    super.onStart();
    logv("onStart");
    mBuilder.append(new Date()).append(" onStart").append("<br/>");
  }

  @Override protected void onResume() {
    super.onResume();
    logv("onResume");
    mBuilder.append(new Date()).append(" onResume").append("<br/>");
    mTextView.setText(toHtml(mBuilder.toString()));
  }

  @Override protected void onPause() {
    super.onPause();
    logv("onPause");
    mBuilder.append(new Date()).append(" onPause").append("<br/>");
  }

  @Override protected void onStop() {
    super.onStop();
    logv("onStop");
    mBuilder.append(new Date()).append("onStop").append("<br/>");
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    logi("onDestroy");
    mBuilder.append(color(new Date().toString(), Color.RED))
        .append(color(" onDestroy", Color.RED))
        .append("<br/>");
  }

  @Override protected void onSaveInstanceState(Bundle savedInstanceState) {
    logi("onSaveInstanceState");
    mBuilder.append(color(new Date().toString(), Color.GREEN))
        .append(color(" onSaveInstanceState", Color.GREEN))
        .append("<br/>");
    savedInstanceState.putString(KEY_DATA, mBuilder.toString());
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    logi("onRestoreInstanceState");
    mBuilder.append(new Date()).append(" onRestoreInstanceState").append("<br/>");
  }
}
