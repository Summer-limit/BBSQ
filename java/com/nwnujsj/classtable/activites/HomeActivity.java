package com.nwnujsj.classtable.activites;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.nwnujsj.classtable.R;
import com.nwnujsj.classtable.fragments.PersonFragment;
import com.nwnujsj.classtable.fragments.SettingFragment;
import com.nwnujsj.classtable.fragments.TimetableFragment;

public class HomeActivity extends Activity {
    private FragmentTransaction bt;
    private FragmentManager fm;
    private GridView gv_home_menus;
    private int[] icons = {R.drawable.personal, R.drawable.timetable, R.drawable.setting};
    private String[] menuname = {"个性化", "课程表", "设置"};
  
  private void initData()
  {
      gv_home_menus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              fm = getFragmentManager();
              bt = fm.beginTransaction();
              switch (menuname[position]){
                  case "设置":
                      bt.replace(R.id.ll_home_body,new SettingFragment());
                      bt.commit();
                      break;
                  case "个性化":
                      bt.replace(R.id.ll_home_body,new PersonFragment(HomeActivity.this));
                      bt.commit();
                      break;
                  case "课程表":
                      bt.replace(R.id.ll_home_body,new TimetableFragment());
                      bt.commit();
                      break;
              }
          }
      });
  }

    private void initFragment() {
        MyAdapter myAdapter = new MyAdapter(null);
        gv_home_menus.setAdapter(myAdapter);
        fm = getFragmentManager();
        bt = fm.beginTransaction();
        bt.replace(R.id.ll_home_body, new TimetableFragment());
        bt.commit();
    }

    private void initView() {
        setContentView(R.layout.activity_home);
        gv_home_menus = findViewById(R.id.gv_home_menus);
    }

    public void onBack() {
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        initFragment();
        initData();
    }
  

    private class MyAdapter extends BaseAdapter {
        private MyAdapter(Object o) {
        }

        public int getCount() {
            return menuname.length;
        }

        public Object getItem(int paramInt) {
            return null;
        }

        public long getItemId(int paramInt) {
            return 0L;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(HomeActivity.this, R.layout.item_home_menus, null);
            }
            TextView tv_home_menus_name = convertView.findViewById(R.id.tv_home_menus_name);
            ImageView iv_home_menus_icon = convertView.findViewById(R.id.iv_home_menus_icon);
            tv_home_menus_name.setText(menuname[position]);
            iv_home_menus_icon.setImageResource(icons[position]);
            return convertView;
        }
    }
}
