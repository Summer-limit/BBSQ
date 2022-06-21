package com.nwnujsj.classtable.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.nwnujsj.classtable.R;
import com.nwnujsj.classtable.activites.HomeActivity;
import com.nwnujsj.classtable.utils.ListUtils;
import com.nwnujsj.classtable.utils.LoginUtil;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint("ValidFragment")
public class SettingFragment<weekname> extends Fragment {
    private AlertDialog aboutwe;
    private int currentWeek;
    private AlertDialog exit;
    private AlertDialog help;
    private HomeActivity homeactivity;
    private int[] icon = {0, R.drawable.item_setting_userinfo, 0, R.drawable.item_setting_classsetting, R.drawable.item_setting_smsmanger, 0, R.drawable.item_setting_law, R.drawable.item_setting_aboutwe, R.drawable.item_setting_help, 0, 0, 0};
    private AlertDialog law;
    private AlertDialog login;
    private ListView lv_setting_menu;
    private String[] names = {" ", "账号管理", " ", "课表设置", "消息提醒", " ", "使用条款", "关于我们", "帮助和反馈", " ", "退出", " "};
    private AlertDialog tableSetting;
    private TextView tv_tablesetting_weekname;
    private String[] weekname = new String[]{"第一周", "第二周", "第三周", "第四周", "第五周", "第六周", "第七周", "第八周", "第九周", "第十周", "第十一周", "第十二周", "第十三周", "第十四周", "第十五周", "第十六周", "第十七周", "第十八周", "第十九周", "第二十周"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, null);
        ListView lv_setting_menu = view.findViewById(R.id.lv_setting_menu);
        lv_setting_menu.setOnItemClickListener(new myListener());
        lv_setting_menu.setAdapter(new myAdapter());
        //LoginUtil.login();
        return view;
    }
    //通过定义内部类实现初始化每一个条目的内容
    private class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv_setting_menuname;
            if (icon[position] != 0) {
                convertView = View.inflate(getActivity(), R.layout.item_fragment_setting_menu, null);
                ImageView iv_setting_menuicon = convertView.findViewById(R.id.iv_setting_menuicon);
                tv_setting_menuname = convertView.findViewById(R.id.tv_setting_menuname);
                iv_setting_menuicon.setImageResource(icon[position]);
                tv_setting_menuname.setText(names[position]);
            } else {
                if (names[position].equals("退出")) {
                    convertView = View.inflate(getActivity(), R.layout.item_fragment_setting_exitmenu, null);
                    tv_setting_menuname = convertView.findViewById(R.id.tv_setting_exit);
                    tv_setting_menuname.setText(names[position]);
                } else {
                    convertView = View.inflate(getActivity(), R.layout.item_fragment_setting_nullmenu, null);
                }
            }
            return convertView;
        }
    }

    //通过定义内部类实现每一个条目的点击事件
    private class myListener implements OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (names[position]) {
                case "账号管理":
                    showDialogLogin();
                    break;
                case "课表设置":
                    showDialogTablesetting();
                    break;
                case "消息提醒":
                    showDialogMessage();
                    break;
                case "使用条款":
                    showDialogLaw();
                    break;
                case "帮助和反馈":
                    showDialogHelp();
                    break;
                case "关于我们":
                    showDialogAboutus();
                    break;
                case "退出":
                    Toast.makeText(getActivity(), names[position], Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    //以下方法实现每一个条目的弹窗

    //1.实现的账号管理弹窗
    private void  showDialogLogin(){
        Builder builder = new Builder(getActivity());
        builder.setCancelable(false);
        View view = View.inflate(getActivity(), R.layout.dialog_login, null);
        AlertDialog dialog = builder.create();
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        dialog.show();
        dialog.setContentView(view);
        dialog.getWindow().setLayout(width, (int) (width * 0.48));
        dialog.show();
        EditText et_login_username = view.findViewById(R.id.et_login_username);
        EditText et_login_password = view.findViewById(R.id.et_login_password);
        Button btn_login_ok = view.findViewById(R.id.btn_login_ok);
        Button btn_login_quit = view.findViewById(R.id.btn_login_quit);
        btn_login_quit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    //2.实现的课表设置弹窗
    private void  showDialogTablesetting(){
        Builder builder = new Builder(getActivity());
        builder.setCancelable(false);
        View view = View.inflate(getActivity(), R.layout.dialog_setting_classtable, null);
        AlertDialog dialog = builder.create();
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        dialog.show();
        dialog.setContentView(view);
        dialog.getWindow().setLayout(width, (int) (width * 0.48));
        dialog.show();
        TextView tv_tablesetting_weekname = view.findViewById(R.id.tv_tablesetting_weekname);
        Button btn_setting_table_ok = view.findViewById(R.id.btn_setting_table_ok);
        Button btn_setting_table_quit = view.findViewById(R.id.btn_setting_table_quit);
        btn_setting_table_quit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    //3.实现消息提示弹窗
    private void  showDialogMessage(){
        Builder builder = new Builder(getActivity());
        builder.setCancelable(false);
        View view = View.inflate(getActivity(), R.layout.dialog_messagetips, null);
        AlertDialog dialog = builder.create();
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        dialog.show();
        dialog.setContentView(view);
        dialog.getWindow().setLayout(width, (int) (width * 0.48));
        dialog.show();
        EditText et_messagetips_dialog_eventname = view.findViewById(R.id.et_messagetips_dialog_eventname);
        EditText et_messagetips_dialog_eventtime = view.findViewById(R.id.et_messagetips_dialog_eventtime);
        Button btn_messagetips_dialog_ok = view.findViewById(R.id.btn_messagetips_dialog_ok);
        Button btn_messagetips_dialog_quit = view.findViewById(R.id.btn_messagetips_dialog_quit);
        btn_messagetips_dialog_quit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    //4.实现的使用用条款弹窗
    private void  showDialogLaw(){
        Builder builder = new Builder(getActivity());
        builder.setCancelable(false);
        View view = View.inflate(getActivity(), R.layout.dialog_provision, null);
        AlertDialog dialog = builder.create();
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        dialog.show();
        dialog.setContentView(view);
        dialog.getWindow().setLayout(width, (int) (width * 0.78));
        dialog.show();
        Button btn_provision_back = view.findViewById(R.id.btn_provision_back);
        btn_provision_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    //5.实现关于我们弹窗
    private void  showDialogAboutus(){
        Builder builder = new Builder(getActivity());
        builder.setCancelable(false);
        View view = View.inflate(getActivity(), R.layout.dialog_aboutwe, null);
        AlertDialog dialog = builder.create();
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        dialog.show();
        dialog.setContentView(view);
        dialog.getWindow().setLayout(width, (int) (width * 0.78));
        dialog.show();
        Button btn_about_back = view.findViewById(R.id.btn_about_back);
        btn_about_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
    //4.实现帮助反馈弹窗
    private void  showDialogHelp(){
        Builder builder = new Builder(getActivity());
        builder.setCancelable(false);
        View view = View.inflate(getActivity(), R.layout.dialog_help, null);
        AlertDialog dialog = builder.create();
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        dialog.show();
        dialog.setContentView(view);
        dialog.getWindow().setLayout(width, (int) (width * 0.78));
        dialog.show();
        Button btn_help_back = view.findViewById(R.id.btn_help_back);
        btn_help_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}
