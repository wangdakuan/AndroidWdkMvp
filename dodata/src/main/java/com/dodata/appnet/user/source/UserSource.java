/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: UserSource
 * Author: wangdakuan
 * Date: 2019/3/14 4:13 PM
 * Description: home网络获取类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.dodata.appnet.user.source;

import com.dodata.appnet.ConsumerSource;
import com.dodata.appnet.UserUrl;
import com.dodata.appnet.model.user.UserInfoData;
import com.dodata.appnet.user.interfaces.UserInteractor;
import com.dodata.cache.ObjectCache;
import com.dodata.net.callback.JsonConvert;
import com.lzy.okgo.OkGo;
import com.lzy.okrx2.adapter.ObservableBody;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @ClassName: UserSource
 * @Description: user网络获取类
 * @Author: wangdakuan
 * @Date: 2019/3/14 4:13 PM
 */
public class UserSource implements UserInteractor {

    private ObjectCache mObjectCache;

    /**
     */
    public UserSource(ObjectCache objectCache) {
        this.mObjectCache = objectCache;
    }

    @Override
    public Observable<UserInfoData> getUser(HashMap<String, String> hashMap) {
        JSONObject object = new JSONObject(new HashMap());
        return OkGo.<UserInfoData>post(UserUrl.CHECK_SIGN_IN)//
                .upJson(object)
                .converter(new JsonConvert<UserInfoData>() {
                })//
                .adapt(new ObservableBody<UserInfoData>())//
                .doOnNext(new ConsumerSource<UserInfoData>(mObjectCache,UserUrl.CHECK_SIGN_IN + object.toString()));
    }
}