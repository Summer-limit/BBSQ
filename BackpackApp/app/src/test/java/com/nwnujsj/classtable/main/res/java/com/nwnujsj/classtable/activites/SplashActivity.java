package com.nwnujsj.classtable.activites;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.*;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import com.nwnujsj.classtable.R;
import com.nwnujsj.classtable.domain.Josnbean;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@SuppressLint({"SdCardPath"})
public class SplashActivity extends Activity {
    protected static final int ERROR = 0;
    private static final int LOADNAIN = 1;
    private static final int SHOWUPDATEDIALOG = -1;
    private Josnbean appInfo;
    private ProgressBar pb_splash_loading;
    private RelativeLayout rl_splash;
    private TextView tv_splash_version;
    private String versionName;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(@NonNull Message msg) {
            //正常操作
            switch (msg.what) {
                case ERROR:
                    Toast.makeText(SplashActivity.this, (String) msg.obj, Toast.LENGTH_LONG);
                    break;
                case LOADNAIN:
                    loadMain();
                    break;
                case SHOWUPDATEDIALOG:
                    showUpdateDialog();
                    break;
                default:
                    break;
            }
        }
    };

    //动态申请SD卡读写权限
    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //初始化动画
    private void initAnimation() {

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        alphaAnimation.setDuration(1000L);
        alphaAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        scaleAnimation.setDuration(1000L);
        scaleAnimation.setFillAfter(true);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        //旋转动画不太好看，不添加
        //animationSet.addAnimation(rotateAnimation);
        rl_splash.startAnimation(animationSet);
    }

    private void initData() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo info = packageManager.getPackageInfo(getPackageName(), 0);
            versionName = info.versionName;
            tv_splash_version.setText(versionName);
        } catch (PackageManager.NameNotFoundException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //初始化界面
    private void initView() {
        setContentView(R.layout.activity_splash);
        rl_splash = findViewById(R.id.rl_splash);
        tv_splash_version = findViewById(R.id.tv_splash_version);
        pb_splash_loading = findViewById(R.id.pb_splash_loading);
    }

    //加载首页
    private void loadMain() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    //下载新版本安装包
    @SuppressLint("WrongConstant")
    protected void downLoadNewApk() {
        RequestParams params = new RequestParams(appInfo.getPath());
        params.setAutoRename(true);//断点下载
        params.setSaveFilePath("/mnt/sdcard/xx.apk");
        x.http().get(params, new Callback.ProgressCallback<File>() {
            @Override
            public void onSuccess(File result) {
                pb_splash_loading.setVisibility(8);
                installApk();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                pb_splash_loading.setVisibility(8);
                Toast.makeText(getApplicationContext(), "新版本下载失败！", 1).show();
                loadMain();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(SplashActivity.this, "安装包下载取消", 1).show();
            }

            @Override
            public void onFinished() {
                Toast.makeText(SplashActivity.this, "安装包下载完成", 1).show();
            }

            @Override
            public void onWaiting() {
                Toast.makeText(SplashActivity.this, "安装包下载中", 1).show();
            }

            @Override
            public void onStarted() {
                Toast.makeText(SplashActivity.this, "安装包下载开始", 1).show();
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                System.out.println("下载中");
                pb_splash_loading.setVisibility(0);
                pb_splash_loading.setMax((int) total);
                pb_splash_loading.setProgress((int) current);
            }
        });

    }


    protected void installApk() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setDataAndType(Uri.fromFile(new File("/mnt/sdcard/xx.apk")), "application/vnd.android.package-archive");
        startActivityForResult(intent, 0);
    }

    //版本检查
    protected boolean isVersion(String currversionName) {
        if (currversionName.equals(versionName)) {
            return true;
        }
        return false;
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        loadMain();
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //动态申请权限
        verifyStoragePermissions(this);
        x.view().inject(this);
        initView();
        initData();
        initAnimation();
        checkVersion();
    }

    protected void parseJsonFromString(String data) throws JSONException {
        JSONObject info = new JSONObject(data);
        appInfo = new Josnbean();
        appInfo.setDesc(info.getString("desc"));
        appInfo.setPath(info.getString("url"));
        appInfo.setVersion(info.getString("version"));
    }

    //询问用户是否安装新版本
    protected void showUpdateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                loadMain();
            }
        });
        builder.setTitle("更新提示").setMessage("检测到有新版本，该版本更新如下：" + appInfo.getDesc());
        builder.setPositiveButton("更新", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int anonymous) {
                downLoadNewApk();
            }
        });
        builder.setNegativeButton("取消", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int anonymous) {
                loadMain();
            }
        });
        builder.show();
    }

    //版本检查
    private void checkVersion() {
        //开线程联网
        new Thread() {
            private HttpURLConnection conn;
            private BufferedReader reader;
            private Message msg = new Message();
            @Override
            public void run() {
                super.run();
                try {
                    String path = "http://47.108.51.34/classTable/info.json";
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    InputStreamReader is = new InputStreamReader(conn.getInputStream(), "gbk");
                    BufferedReader bufferedReader = new BufferedReader(is);
                    String data = bufferedReader.readLine();
                    //解析json字符串
                    parseJsonFromString(data);
                    //对比版本号
                    boolean isVersion = isVersion(appInfo.getVersion());
                    if (!isVersion) {
                        //版本不一致，开始更新
                        msg.what = SHOWUPDATEDIALOG;
                    } else {
                        //版本一致，加载主页
                        msg.what = LOADNAIN;
                    }
                    is.close();
                    conn.disconnect();
                } catch (MalformedURLException e) {
                    msg.what = ERROR;
                    msg.obj = "亲，网络故障，请稍后再试";
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    msg.what = ERROR;
                    msg.obj = "亲，网络故障，请稍后再试";
                    e.printStackTrace();
                } catch (JSONException e) {
                    msg.what = ERROR;
                    msg.obj = "亲，网络故障，请稍后再试";
                    e.printStackTrace();
                } catch (IOException e) {
                    msg.what = ERROR;
                    msg.obj = "亲，网络故障，请稍后再试";
                    e.printStackTrace();
                } finally {
                    handler.sendMessage(msg);
                }
            }
        }.start();

    }
}