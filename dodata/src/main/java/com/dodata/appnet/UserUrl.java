package com.dodata.appnet;

import com.example.dodata.BuildConfig;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 11:36
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：我的模块中的接口
 */
public class UserUrl {
    public static String BASE_URL = BuildConfig.API_URL;

    public final static String CHECK_SIGN_IN = BASE_URL + "/session/check_login";

}
