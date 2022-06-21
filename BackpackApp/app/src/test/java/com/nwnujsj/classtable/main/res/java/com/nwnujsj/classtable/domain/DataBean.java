package com.nwnujsj.classtable.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataBean {
  private static ClassInfoBean[][] classinfoone = (ClassInfoBean[][]) Array.newInstance(ClassInfoBean.class, new int[]{5, 7});
  private static ClassInfoBean[][] classinfotwo = (ClassInfoBean[][]) Array.newInstance(ClassInfoBean.class, new int[]{5, 7});
  private static boolean iSnull = false;
  private static ArrayList<InfoBean> jsonInfo;
  private static ArrayList<ScoreBean> jsonScore;
  private static ArrayList<EnglishScoreBean> jsonenglish;

  public static ClassInfoBean[][] getClassinfoone() {
    return classinfoone;
  }

  public static void setClassinfoone(ClassInfoBean[][] classinfoone) {
    DataBean.classinfoone = classinfoone;
  }

  public static ClassInfoBean[][] getClassinfotwo() {
    return classinfotwo;
  }

  public static void setClassinfotwo(ClassInfoBean[][] classinfotwo) {
    DataBean.classinfotwo = classinfotwo;
  }

  public static boolean isiSnull() {
    return iSnull;
  }

  public static void setiSnull(boolean iSnull) {
    DataBean.iSnull = iSnull;
  }

  public static ArrayList<InfoBean> getJsonInfo() {
    return jsonInfo;
  }

  public static void setJsonInfo(ArrayList<InfoBean> jsonInfo) {
    DataBean.jsonInfo = jsonInfo;
  }

  public static ArrayList<ScoreBean> getJsonScore() {
    return jsonScore;
  }

  public static void setJsonScore(ArrayList<ScoreBean> jsonScore) {
    DataBean.jsonScore = jsonScore;
  }

  public static ArrayList<EnglishScoreBean> getJsonenglish() {
    return jsonenglish;
  }

  public static void setJsonenglish(ArrayList<EnglishScoreBean> jsonenglish) {
    DataBean.jsonenglish = jsonenglish;
  }
}