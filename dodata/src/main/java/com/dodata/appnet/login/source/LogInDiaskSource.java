/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: LogInDiaskSource
 * Author: wangdakuan
 * Date: 2019/3/28 4:13 PM
 * Description: 缓存获取类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.dodata.appnet.login.source;

import com.dodata.appnet.login.interactor.LogInInteractor;
import com.dodata.cache.ObjectCache;


/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: LogInDiaskSource
 * Author:
 * Date:
 * Description: 缓存获取类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class LogInDiaskSource implements LogInInteractor {
    private final ObjectCache objectCache;

    public LogInDiaskSource(ObjectCache objectCache) {
        this.objectCache = objectCache;
    }
}