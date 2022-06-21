package com.nwnujsj.classtable.application;

import android.app.Application;
import org.xutils.x;

public class SplashApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
