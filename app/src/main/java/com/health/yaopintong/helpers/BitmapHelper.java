package com.health.yaopintong.helpers;

import android.content.Context;
import android.os.Environment;

import com.lidroid.xutils.BitmapUtils;

/**
 * 图片下载帮助类
 */
public class BitmapHelper {
    private static BitmapUtils utils;
    public static void init(Context context){
        utils = new BitmapUtils(context, Environment.getExternalStorageDirectory().getAbsolutePath(),1/8.0F,10*1024*1024);
//        utils.configDefaultBitmapMaxSize(100,100);
    }

    public static BitmapUtils getUtils() {
        return utils;
    }
}
