package com.nwnujsj.classtable.utils;

public class ButtonUtils
{
  private static long DIFF = 1000L;
  private static int lastButtonId = -1;
  private static long lastClickTime = 0L;
  
  public static boolean isFastDoubleClick()
  {
    return isFastDoubleClick(-1, DIFF);
  }
  
  public static boolean isFastDoubleClick(int paramInt)
  {
    return isFastDoubleClick(paramInt, DIFF);
  }
  
  public static boolean isFastDoubleClick(int paramInt, long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = lastClickTime;
    if ((lastButtonId == paramInt) && (lastClickTime > 0L) && (l1 - l2 < paramLong)) {
      return true;
    }
    lastClickTime = l1;
    lastButtonId = paramInt;
    return false;
  }
}
