package com.foolchen.examples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 主Activity，一个App的入口
 */
public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.lifecycle_example) {
      startActivity(LifecycleExampleActivity.class);
    }
  }

  private void startActivity(Class clazz) {
    Intent intent = new Intent(this, clazz);
    startActivity(intent);
  }
}
