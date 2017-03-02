package com.lyl.broadcastreceiverdemo;

import android.util.Log;

/**
 * 类名：LogUtils <br/>
 * 描述：统一Log打印工具类，方便关闭log
 * 创建时间：2016/01/25 21:07
 *
 * @author wangmingshuo
 * @version 1.0
 */
public class LogUtils {

    /** 设置是否打印log */
    private static boolean DEBUG = true;

    public static void exception(Exception e) {
        if (DEBUG) {
            e.printStackTrace();
        }
    }

    public static void i(String msg) {
        if (DEBUG) {
            Log.i(getFunctionName(), msg);
        }
    }

    public static void i(String tag, String msg) {
        if (DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void v(String msg) {
        if (DEBUG) {
            Log.v(getFunctionName(), msg);
        }
    }

    public static void v(String tag, String msg) {
        if (DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void d(String msg) {
        if (DEBUG) {
            Log.d(getFunctionName(), msg);
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void e(String msg) {
        if (DEBUG) {
            Log.e(getFunctionName(), msg);
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void w(String msg) {
        if (DEBUG) {
            Log.w(getFunctionName(), msg);
        }
    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, msg);
        }
    }

    private static String getFunctionName() {
        StackTraceElement caller = new Throwable().fillInStackTrace().getStackTrace()[2];
        return caller.getFileName() + "." + caller.getMethodName() + "(" + caller.getLineNumber() + ")";
    }

}
