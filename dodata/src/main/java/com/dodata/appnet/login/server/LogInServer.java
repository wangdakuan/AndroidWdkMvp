/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: LogInFactory
 * Author: wangdakuan
 * Date: 2019/3/28 5:17 PM
 * Description: 功能的服务层
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.dodata.appnet.login.server;

import com.dodata.appnet.login.factory.LogInFactory;
import com.dodata.appnet.login.interactor.LogInInteractor;
import com.dodata.net.utils.JsonUtils;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName:  LogInServer
 * Author:
 * Date:
 * Description: 功能的服务层
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class LogInServer {
    LogInFactory mLogInFactory;

    public LogInServer() {
        this(new LogInFactory());
    }

    public LogInServer(LogInFactory factory) {
        this.mLogInFactory = factory;
    }
}