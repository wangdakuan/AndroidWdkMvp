package com.dodata.appnet;


import com.dodata.cache.ObjectCache;

import java.io.Serializable;

import io.reactivex.functions.Consumer;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: ConsumerSource
 * Author: wangdakuan
 * Date: 2019/3/25 2:43 PM
 * Description: ${DESCRIPTION}
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class ConsumerSource<T> implements Consumer<T> {

    protected ObjectCache mObjectCache;
    protected String mKey;

    public ConsumerSource(ObjectCache objectCache, String key) {
        mObjectCache = objectCache;
        mKey = key;
    }

    @Override
    public void accept(T t) throws Exception {
        if (t != null) {
            mObjectCache.put((Serializable) t, mKey);
        }
    }
}
