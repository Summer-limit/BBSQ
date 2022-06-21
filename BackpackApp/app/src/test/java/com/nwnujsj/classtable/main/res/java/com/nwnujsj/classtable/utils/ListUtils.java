package com.nwnujsj.classtable.utils;

public class ListUtils
{
  private static final int MIN_DELAY_TIME = 1000;
  private static long lastClickTime = 0L;
  
  public static boolean isFastClick()
  {
    boolean bool = true;
    long l = System.currentTimeMillis();
    if (l - lastClickTime >= 1000L) {
      bool = false;
    }
    lastClickTime = l;
    return bool;
  }
}
