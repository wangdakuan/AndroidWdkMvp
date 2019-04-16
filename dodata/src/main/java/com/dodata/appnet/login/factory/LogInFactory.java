/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: LogInFactory
 * Author: wangdakuan
 * Date: 2019/3/28 3:54 PM
 * Description: 工厂实现类 区分内存与网络获取
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.dodata.appnet.login.factory;

import com.common.utils.NetworkUtils;
import com.dodata.appnet.login.interactor.LogInInteractor;
import com.dodata.appnet.login.source.LogInDiaskSource;
import com.dodata.appnet.login.source.LogInSource;
import com.dodata.cache.ObjectCache;
import com.dodata.cache.ObjectCacheImpl;

 /**
  * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
  * FileName: LogInFactory
  * Author:
  * Date:
  * Description: 工厂实现类 区分内存与网络获取
  * History:
  * <author> <time> <version> <desc>
  * 作者姓名 修改时间 版本号 描述
  */
public class LogInFactory {
    private ObjectCache objectCache;

    public LogInFactory() {
        this(new ObjectCacheImpl());
    }

    public LogInFactory(ObjectCacheImpl objectCache) {
        this.objectCache = objectCache;
    }

    /**
     * 数据不经常更新时每次都会优先取缓存
     *
     * @param name 缓存时的KEY
     * @return
     */
    public LogInInteractor createLogInData(String name) {
        return createLogInData(name, false);
    }

    /**
     * 数据经常更新时每次都会优先取网络
     *
     * @param name   缓存的key
     * @param isWifi 是否判断网络  如果true 判断网络，当前手机没网情况下进行读取本地缓存数据
     * @return
     */
    public LogInInteractor createLogInData(String name, boolean isWifi) {
        LogInInteractor dataInteractor = null;
        if (isWifi) {
            if (!NetworkUtils.isAvailableByPing()) {
                if (this.objectCache.isCached(name)) {
                    dataInteractor = new LogInDiaskSource(this.objectCache);
                }
            }
        } else {
            if (this.objectCache.isCached(name)) {
                dataInteractor = new LogInDiaskSource(this.objectCache);
            }
        }
        if(null == dataInteractor){
            dataInteractor = createLogInStore();
        }
        return dataInteractor;
    }

    /**
     * 开启网络请求
     */
    private LogInInteractor createLogInStore() {
        return new LogInSource(this.objectCache);
    }
}