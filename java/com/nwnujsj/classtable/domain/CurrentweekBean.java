package com.nwnujsj.classtable.domain;

public class CurrentweekBean
{
  private static int currentWeek = 1;

  public static int getCurrentWeek() {
    return currentWeek;
  }

  public static void setCurrentWeek(int currentWeek) {
    CurrentweekBean.currentWeek = currentWeek;
  }
}