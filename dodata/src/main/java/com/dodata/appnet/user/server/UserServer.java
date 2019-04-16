/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: UserServer
 * Author: wangdakuan
 * Date: 2019/3/14 5:17 PM
 * Description: Home功能的服务层
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.dodata.appnet.user.server;

import com.dodata.appnet.UserUrl;
import com.dodata.appnet.user.factory.UserFactory;
import com.dodata.appnet.user.interfaces.UserInteractor;
import com.dodata.net.utils.JsonUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @ClassName: UserServer
 * @Description: user功能的服务层
 * @Author: wangdakuan
 * @Date: 2019/3/14 5:17 PM
 */
public class UserServer {
    UserFactory homeFactory;

    public UserServer() {
        this(new UserFactory());
    }

    public UserServer(UserFactory homeFactory) {
        this.homeFactory = homeFactory;
    }

    public void getUser(Observer subscriber, HashMap<String, String> hashMap) {
        UserInteractor dataInteractor = homeFactory.createHomeData(UserUrl.CHECK_SIGN_IN + JsonUtils.formatJson(hashMap));
        dataInteractor.getUser(hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}