/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: BaseSource
 * Author: wangdakuan
 * Date: 2019/3/14 4:42 PM
 * Description: 缓存
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.dodata.appnet;

import com.dodata.cache.ObjectCache;

import java.io.Serializable;

import io.reactivex.functions.Consumer;

/**
 * @ClassName: BaseSource
 * @Description: 缓存
 * @Author: wangdakuan
 * @Date: 2019/3/14 4:42 PM
 */
public class BaseSource {

    protected ObjectCache objectCache;

    protected Consumer<Object> saveToCacheAction(final String key) {
        return new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                if (o != null) {
                    objectCache.put((Serializable) o, key);
                }
            }
        };
    }
}