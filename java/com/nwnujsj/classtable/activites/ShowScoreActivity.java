package com.nwnujsj.classtable.activites;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import androidx.annotation.Nullable;
import com.nwnujsj.classtable.R;
import com.nwnujsj.classtable.domain.DataBean;
import com.nwnujsj.classtable.domain.InfoBean;
import com.nwnujsj.classtable.domain.ScoreBean;
import com.nwnujsj.classtable.utils.ButtonUtils;
import com.nwnujsj.classtable.utils.SpinerPopWindow;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ShowScoreActivity extends Activity {
    private ListAdapter adapter;
    private Button btn_showscore_back;
    private Button btn_showscore_getGPA;
    private int intoschooltime = 0;
    private ListView lv_person_showscore;
    private AlertDialog showGPA;
    private String termname = null;
    private TextView tv_person_showscore_title;
    private List<ScoreBean> list=new ArrayList<>();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        System.out.println("show");
        //模拟课程数
        for (int i=0;i<6;i++){
            final ScoreBean bean = new ScoreBean();
            bean.setScore("99");
            bean.setCredit("6");
            bean.setType("必修");
            bean.setYear("2018");
            bean.setName("移动应用开发");
            list.add(bean);
        }
        initView();
    }


    private void initView() {
        setContentView(R.layout.activity_personal_showscore);
        lv_person_showscore = findViewById(R.id.lv_person_showscore);
        Button btn_showscore_back = findViewById(R.id.btn_showscore_back);
        Button btn_showscore_getGPA = findViewById(R.id.btn_showscore_getGPA);

        btn_showscore_getGPA.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Builder builder = new Builder(ShowScoreActivity.this);
                builder.setCancelable(false);
                View view = View.inflate(ShowScoreActivity.this, R.layout.dialog_showscore_showgpa, null);
                Button btn_showscore_showgpa_back = view.findViewById(R.id.btn_showscore_showgpa_back);
                TextView tv_showscore_showgpa = view.findViewById(R.id.tv_showscore_showgpa);
                AlertDialog showGPADialog = builder.create();
                int i = ShowScoreActivity.this.getWindowManager().getDefaultDisplay().getWidth();
                showGPADialog.show();
                showGPADialog.setContentView(view);
                showGPADialog.getWindow().setLayout(i, (int) (i * 0.46D));
                tv_showscore_showgpa.setText("你的绩点为：4.5");
                btn_showscore_showgpa_back.setOnClickListener(new OnClickListener() {
                    public void onClick(View paramAnonymousView) {
                        if (!ButtonUtils.isFastDoubleClick(R.id.tv_showscore_showgpa)) {
                            showGPADialog.dismiss();
                        }
                    }
                });

            }
        });

        btn_showscore_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lv_person_showscore.setAdapter(new myAdapter());
    }

    private class myAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
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
            if (convertView==null){
                convertView = View.inflate(ShowScoreActivity.this,R.layout.item_activity_showscore,null);
            }
            TextView tv_showscore_classcredit = convertView.findViewById(R.id.tv_showscore_classcredit);
            TextView tv_showscore_classname = convertView.findViewById(R.id.tv_showscore_classname);
            TextView tv_showscore_classtype = convertView.findViewById(R.id.tv_showscore_classtype);
            TextView tv_showscore_classscore = convertView.findViewById(R.id.tv_showscore_classscore);
            tv_showscore_classcredit.setText(list.get(position).getCredit());
            tv_showscore_classtype.setText(list.get(position).getType());
            tv_showscore_classname.setText(list.get(position).getName());
            tv_showscore_classscore.setText(list.get(position).getScore());
            return convertView;
        }
    }
}
