package com.nwnujsj.classtable.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.nwnujsj.classtable.R;
import com.nwnujsj.classtable.activites.HomeActivity;
import com.nwnujsj.classtable.activites.ShowScoreActivity;
import com.nwnujsj.classtable.domain.InfoBean;
import com.nwnujsj.classtable.utils.ButtonUtils;
import com.nwnujsj.classtable.utils.SpinerPopWindow;

@SuppressLint("ValidFragment")
public class PersonFragment extends Fragment implements OnClickListener {
    private String intentflag = "当前所有课程";
    private ImageView iv_personal_picture;
    private LinearLayout ll_personal_lingyin;
    private LinearLayout ll_personal_score;
    private LinearLayout ll_personal_siliu;
    private LinearLayout ll_personal_zixi;
    private Dialog login;
    private SpinerPopWindow<String> mSpinerPopWindow;
    private AlertDialog ringmanager;
    private AlertDialog siliu;
    private InfoBean studentinfo;
    private String[] termname = {"当前所有课程", "大一第一学期", "大一第二学期", "大二第一学期", "大二第二学期", "大三第一学期", "大三第二学期", "大四第一学期", "大四第二学期"};
    private TextView tv_personal_academy;
    private TextView tv_personal_major;
    private TextView tv_personal_name;
    private TextView tv_personal_studentid;
    private TextView tv_personal_termname;
    private HomeActivity homeActivity;
    private View view;


    public PersonFragment(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal, null);
        initView();
        initData();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_personal_score:
                Dialoglookup();
                break;
            case R.id.ll_personal_siliu:
                System.out.println("四六级");
                DialogSiliu();
                break;
            case R.id.ll_personal_linyin:
                break;
            case R.id.ll_personal_liuyan:
                break;
            default:
                break;


        }
    }


    private void DialogRingManager() {

    }

    private void DialogSiliu() {
        Builder builder = new Builder(getActivity());
        builder.setCancelable(false);
        View view = View.inflate(getActivity(), R.layout.dialog_lookup_siliu, null);
        Button btn_siliu_back = view.findViewById(R.id.btn_siliu_back);
        AlertDialog siliudialog = builder.create();
        int i = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        siliudialog.show();
        siliudialog.setContentView(view);
        siliudialog.getWindow().setLayout(i, (int) (i * 0.46D));
        btn_siliu_back.setOnClickListener(new OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (!ButtonUtils.isFastDoubleClick(R.id.btn_siliu_back)) {
                    siliudialog.dismiss();
                }
            }
        });
    }

    private void Dialoglookup() {
        Builder builder = new Builder(getActivity());
        builder.setCancelable(false);
        View view = View.inflate(getActivity(), R.layout.dialog_personal_lookupscore, null);
        Button btn_score_lookup = view.findViewById(R.id.btn_score_lookup);
        Button btn_score_quit = view.findViewById(R.id.btn_score_quit);
        TextView tv_personal_termname = view.findViewById(R.id.tv_personal_termname);
        tv_personal_termname.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mSpinerPopWindow.setWidth(tv_personal_termname.getWidth());
                mSpinerPopWindow.showAsDropDown(tv_personal_termname);
            }
        });
        mSpinerPopWindow = new SpinerPopWindow<String>(getActivity(), termname, new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSpinerPopWindow.dismiss();
                intentflag = termname[position];
                tv_personal_termname.setText(intentflag);
            }
        });
        AlertDialog lookupDialog = builder.create();
        int i = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        lookupDialog.show();
        lookupDialog.setContentView(view);
        lookupDialog.getWindow().setLayout(i, (int) (i * 0.46D));
        btn_score_lookup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity, ShowScoreActivity.class));
            }
        });
        btn_score_quit.setOnClickListener(new OnClickListener() {
            public void onClick(View paramAnonymousView) {
                if (!ButtonUtils.isFastDoubleClick(R.id.btn_siliu_back)) {
                    lookupDialog.dismiss();
                }
            }
        });
    }

    private void initView() {
        tv_personal_academy = view.findViewById(R.id.tv_personal_academy);
        tv_personal_studentid = view.findViewById(R.id.tv_personal_studentid);
        tv_personal_name = view.findViewById(R.id.tv_personal_name);
        tv_personal_major = view.findViewById(R.id.tv_personal_major);
        ll_personal_score = view.findViewById(R.id.ll_personal_score);
        ll_personal_lingyin = view.findViewById(R.id.ll_personal_linyin);
        ll_personal_siliu = view.findViewById(R.id.ll_personal_siliu);
        iv_personal_picture = view.findViewById(R.id.iv_personal_picture);
        ll_personal_zixi = view.findViewById(R.id.ll_personal_liuyan);
        ll_personal_lingyin.setOnClickListener(this);
        ll_personal_score.setOnClickListener(this);
        ll_personal_siliu.setOnClickListener(this);
        ll_personal_zixi.setOnClickListener(this);
    }
    private void initData() {
        tv_personal_academy.setText("计算机科学与工程学院");
        tv_personal_major.setText("计算机科学与技术");
        tv_personal_name.setText("孟姣姣");
        tv_personal_studentid.setText("201971010230");
        iv_personal_picture.setImageResource(R.drawable.lll);

    }
}


