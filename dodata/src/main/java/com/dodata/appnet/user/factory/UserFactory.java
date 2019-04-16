/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: UserFactory
 * Author: wangdakuan
 * Date: 2019/3/14 3:54 PM
 * Description: 工厂实现类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.dodata.appnet.user.factory;


import com.common.utils.NetworkUtils;
import com.dodata.appnet.user.interfaces.UserInteractor;
import com.dodata.appnet.user.source.UserDiaskSource;
import com.dodata.appnet.user.source.UserSource;
import com.dodata.cache.ObjectCache;
import com.dodata.cache.ObjectCacheImpl;

/**
 * @ClassName: UserFactory
 * @Description: 工厂实现类 区分内存与网络获取
 * @Author: wangdakuan
 * @Date: 2019/3/14 3:54 PM
 */
public class UserFactory {
    private ObjectCache objectCache;

    public UserFactory() {
        this(new ObjectCacheImpl());
    }

    public UserFactory(ObjectCacheImpl objectCache) {
        this.objectCache = objectCache;
    }

    /**
     * 数据不经常更新时每次都会优先取缓存
     *
     * @param name 缓存时的KEY
     * @return
     */
    public UserInteractor createHomeData(String name) {
        return createHomeData(name, false);
    }

    /**
     * 数据经常更新时每次都会优先取网络
     *
     * @param name   缓存的key
     * @param isWifi 是否判断网络  如果true 判断网络，当前手机没网情况下进行读取本地缓存数据
     * @return
     */
    public UserInteractor createHomeData(String name, boolean isWifi) {
        UserInteractor dataInteractor = null;
        if (isWifi) {
            if (!NetworkUtils.isAvailableByPing()) {
                if (this.objectCache.isCached(name)) {
                    dataInteractor = new UserDiaskSource(this.objectCache);
                }
            }
        } else {
            if (this.objectCache.isCached(name)) {
                dataInteractor = new UserDiaskSource(this.objectCache);
            }
        }
        if(null == dataInteractor){
            dataInteractor = createHomeStore();
        }
        return dataInteractor;
    }

    /**
     * 开启网络请求
     */
    private UserInteractor createHomeStore() {
        return new UserSource(this.objectCache);
    }
}