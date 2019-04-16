/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: LogInPresenter
 * Author: wangdakuan
 * Date: 2019/3/28 3:54 PM
 * Description: Presenter处理view层与data层数据交互
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.wdk.viewmodel.login;

import com.wdk.viewmodel.login.viewinteractor.LogInView;
import com.wdk.viewmodel.base.BasePresenter;
import com.dodata.appnet.login.server.LogInServer;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: LogInPresenter
 * Author:
 * Date:
 * Description: Presenter处理view层与data层数据交互
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class LogInPresenter extends BasePresenter<LogInView> {

     private LogInServer mLogInServer;

     public LogInPresenter() {
         mLogInServer = new LogInServer();
     }

}