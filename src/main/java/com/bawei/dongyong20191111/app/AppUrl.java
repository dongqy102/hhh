package com.bawei.dongyong20191111.app;

import android.app.Application;
import android.content.Context;

/**
 * @auther:董青勇
 * @Date: 2019/11/11
 * @Time: 8:57
 * @Description:
 */
public class AppUrl extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
