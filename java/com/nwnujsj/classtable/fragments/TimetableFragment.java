package com.nwnujsj.classtable.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nwnujsj.classtable.R;
import com.nwnujsj.classtable.domain.ClassInfoBean;
import com.nwnujsj.classtable.domain.CurrentweekBean;
import com.nwnujsj.classtable.domain.DataBean;

import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"ResourceAsColor"})
public class TimetableFragment extends Fragment {
  private TextView tv_classname00;
  private TextView tv_classname01;
  private TextView tv_classname02;
  private TextView tv_classname03;
  private TextView tv_classname04;
  private TextView tv_classname05;
  private TextView tv_classname06;
  private TextView tv_classname10;
  private TextView tv_classname11;
  private TextView tv_classname12;
  private TextView tv_classname13;
  private TextView tv_classname14;
  private TextView tv_classname15;
  private TextView tv_classname16;
  private TextView tv_classname20;
  private TextView tv_classname21;
  private TextView tv_classname22;
  private TextView tv_classname23;
  private TextView tv_classname24;
  private TextView tv_classname25;
  private TextView tv_classname26;
  private TextView tv_classname30;
  private TextView tv_classname31;
  private TextView tv_classname32;
  private TextView tv_classname33;
  private TextView tv_classname34;
  private TextView tv_classname35;
  private TextView tv_classname36;
  private TextView tv_classname40;
  private TextView tv_classname41;
  private TextView tv_classname42;
  private TextView tv_classname43;
  private TextView tv_classname44;
  private TextView tv_classname45;
  private TextView tv_classname46;
  private TextView tv_weekid;
  private View view;
  private int weekflag = 1;

//初始化数据
  private void initData() {
    weekflag = CurrentweekBean.getCurrentWeek();
    tv_weekid.setText("第" + weekflag + "周");
    tv_classname00.setText("大学语文");
    tv_classname00.setBackgroundColor(Color.parseColor("BLUE"));

  }

  private void initView()
  {
    tv_weekid = view.findViewById(R.id.tv_timetable_weekid);
    tv_classname00 = view.findViewById(R.id.tv_firstsegment_monday);
    tv_classname01 = view.findViewById(R.id.tv_firstsegment_tuesday);
    tv_classname02 = view.findViewById(R.id.tv_firstsegment_wednesday);
    tv_classname03 = view.findViewById(R.id.tv_firstsegment_thursday);
    tv_classname04 = view.findViewById(R.id.tv_firstsegment_friday);
    tv_classname05 = view.findViewById(R.id.tv_firstsegment_saturday);
    tv_classname06 = view.findViewById(R.id.tv_firstsegment_sunday);

    tv_classname10 = view.findViewById(R.id.tv_secondsegment_monday);
    tv_classname11 = view.findViewById(R.id.tv_secondsegment_tuesday);
    tv_classname12 = view.findViewById(R.id.tv_secondsegment_wednesday);
    tv_classname13 = view.findViewById(R.id.tv_secondsegment_thursday);
    tv_classname14 = view.findViewById(R.id.tv_secondsegment_friday);
    tv_classname15 = view.findViewById(R.id.tv_secondsegment_saturday);
    tv_classname16 = view.findViewById(R.id.tv_secondsegment_sunday);

    tv_classname20 = view.findViewById(R.id.tv_thirdsegment_monday);
    tv_classname21 = view.findViewById(R.id.tv_thirdsegment_tuesday);
    tv_classname22 = view.findViewById(R.id.tv_thirdsegment_wednesday);
    tv_classname23 = view.findViewById(R.id.tv_thirdsegment_thursday);
    tv_classname24 = view.findViewById(R.id.tv_thirdsegment_friday);
    tv_classname25 = view.findViewById(R.id.tv_thirdsegment_saturday);
    tv_classname26 = view.findViewById(R.id.tv_thirdsegment_sunday);

    tv_classname30 = view.findViewById(R.id.tv_fourthsegment_monday);
    tv_classname31 = view.findViewById(R.id.tv_fourthsegment_tuesday);
    tv_classname32 = view.findViewById(R.id.tv_fourthsegment_wednesday);
    tv_classname33 = view.findViewById(R.id.tv_fourthsegment_thursday);
    tv_classname34 = view.findViewById(R.id.tv_fourthsegment_friday);
    tv_classname35 = view.findViewById(R.id.tv_fourthsegment_saturday);
    tv_classname36 = view.findViewById(R.id.tv_fourthsegment_sunday);

    tv_classname40 = view.findViewById(R.id.tv_fifthsegment_monday);
    tv_classname41 = view.findViewById(R.id.tv_fifthsegment_tuesday);
    tv_classname42 = view.findViewById(R.id.tv_fifthsegment_wednesday);
    tv_classname43 = view.findViewById(R.id.tv_fifthsegment_thursday);
    tv_classname44 = view.findViewById(R.id.tv_fifthsegment_friday);
    tv_classname45 = view.findViewById(R.id.tv_fifthsegment_saturday);
    tv_classname46 = view.findViewById(R.id.tv_fifthsegment_sunday);

  }
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_timetable, null);
    initView();
    initData();
    return view;
  }
}

