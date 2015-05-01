package com.health.yaopintong.helpers;

import android.content.Context;

import com.lidroid.xutils.DbUtils;

/**
 * 数据库帮助类
 */
public class DbHelper {
    private static DbUtils utils;
    public static void init(Context context){
        utils = DbUtils.create(context, "medicine");
        utils.configDebug(true);
        utils.configAllowTransaction(true);
    }

    public static DbUtils getUtils() {
        return utils;
    }
}
