/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: BaseApplication
 * Author: wangdakuan
 * Date: 2019/3/20 12:08 PM
 * Description: Application基类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.wdk.baseapp.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.common.BuildConfig;
import com.common.utils.AppUtils;
import com.common.utils.CrashUtils;
import com.common.utils.LogUtils;
import com.wdk.viewmodel.OkHttpUtils;

/**
 * @ClassName: BaseApplication
 * @Description: Application基类
 * @Author: wangdakuan
 * @Date: 2019/3/20 12:08 PM
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.LOG_SHOWS_DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        /**
         * App工具类初始化（不初始化Utils部分方法会报错）
         */
        AppUtils.init(this);
        /**
         * 错误日志
         */
        CrashUtils.init();
        /**
         * 请求初始化
         */
        OkHttpUtils.initOkGo(this);
        LogUtils.getConfig().setGlobalTag("LKH");
        LogUtils.getConfig().setLogSwitch(BuildConfig.LOG_SHOWS_DEBUG);

    }
}