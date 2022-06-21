package com.nwnujsj.classtable.utils;

import android.util.Base64;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.cookie.DbCookieStore;
import org.xutils.x;

import java.net.HttpCookie;
import java.util.List;

public class LoginUtil {
    private static final int PASSWORDWRONG = 1;
    private static final int SERVERFAIL = 3;
    private static final int UESRNOTFIND = 0;

    public static void login() {
        String url = "http://cas.nwnu.edu.cn/checkPageUser";
        RequestParams params = new RequestParams(url);
        params.addBodyParameter("verifyCode","");
        params.addBodyParameter("username","201971010230");
        String password="Mjj980915";
        String base64= Base64.encodeToString(password.getBytes(), Base64.DEFAULT);
        params.addBodyParameter("password",base64);
        System.out.println("登录");
        x.http().post(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                System.out.println(result);
                DbCookieStore instance = DbCookieStore.INSTANCE;
                List<HttpCookie> cookies = instance.getCookies();
                for (HttpCookie cookie : cookies) {
                    String name = cookie.getName();
                    String value = cookie.getValue();
                    System.out.println("name:"+name+"Value:"+value);
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                System.out.println("失败");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

}
