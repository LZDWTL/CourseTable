package com.telephone.coursetable.LogMe;

import android.content.pm.ApplicationInfo;
import android.util.Log;

import com.telephone.coursetable.MyApp;

public class LogMe {

    private interface LogRunnable{
        void log(String tag, String msg);
    }

    private static LogRunnable e, w, i;
    private static LogRunnable no = (tag, msg) -> {};

    public static void init(){
        if ((MyApp.getApplicationInfo_me().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0) {
            e = Log::e;
            w = Log::w;
            i = Log::i;
        }else {
            e = w = i = no;
        }
    }

    public static void e(String tag, String msg){
        e.log(tag, msg);
    }
    public static void w(String tag, String msg){
        w.log(tag, msg);
    }
    public static void i(String tag, String msg){
        i.log(tag, msg);
    }
}