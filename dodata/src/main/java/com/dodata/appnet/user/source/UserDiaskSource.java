/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: UserDiaskSource
 * Author: wangdakuan
 * Date: 2019/3/14 4:13 PM
 * Description: home缓存获取类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.dodata.appnet.user.source;

import com.dodata.appnet.UserUrl;
import com.dodata.appnet.model.user.UserInfoData;
import com.dodata.appnet.user.interfaces.UserInteractor;
import com.dodata.cache.ObjectCache;
import com.dodata.net.utils.JsonUtils;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @ClassName: UserDiaskSource
 * @Description: user缓存获取类
 * @Author: wangdakuan
 * @Date: 2019/3/14 4:13 PM
 */
public class UserDiaskSource implements UserInteractor {
    private final ObjectCache objectCache;

    public UserDiaskSource(ObjectCache objectCache) {
        this.objectCache = objectCache;
    }
    @Override
    public Observable<UserInfoData> getUser(HashMap<String, String> hashMap) {
        return this.objectCache.get(UserUrl.CHECK_SIGN_IN + JsonUtils.formatJson(hashMap));
    }
}