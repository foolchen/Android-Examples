package com.foolchen.examples;

import android.os.Build;
import android.text.Html;
import android.util.Log;

import static android.text.Html.FROM_HTML_MODE_COMPACT;

/**
 * 工具类
 *
 * @author chenchong
 *         2017/4/19
 *         上午9:26
 */

public class Utils {
  private static final String TAG = "Examples";
  public static boolean LOG_ENABLE = true;

  public static void logv(String message) {
    if (LOG_ENABLE) Log.v(TAG, message);
  }

  public static void logd(String message) {
    if (LOG_ENABLE) Log.d(TAG, message);
  }

  public static void logi(String message) {
    if (LOG_ENABLE) Log.i(TAG, message);
  }

  public static void logw(String message) {
    if (LOG_ENABLE) Log.w(TAG, message);
  }

  public static void loge(String message) {
    if (LOG_ENABLE) Log.e(TAG, message);
  }

  public static String color(String text, int color) {
    return "<font color= '" + color + "'>" + text + "</font>";
  }

  public static CharSequence toHtml(String text) {
    CharSequence result;
    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) {
      result = Html.fromHtml(text);
    } else {
      result = Html.fromHtml(text, FROM_HTML_MODE_COMPACT);
    }
    return result;
  }
}
