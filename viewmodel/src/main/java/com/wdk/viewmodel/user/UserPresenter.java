/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: UserPresenter
 * Author: wangdakuan
 * Date: 2019/3/14 5:14 PM
 * Description: home
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.wdk.viewmodel.user;

import com.dodata.appnet.model.user.UserInfoData;
import com.dodata.appnet.user.server.UserServer;
import com.wdk.viewmodel.MYObserver;
import com.wdk.viewmodel.base.BasePresenter;
import com.wdk.viewmodel.user.viewinteractor.UserView;

import java.util.HashMap;


/**
 * @ClassName: UserPresenter
 * @Description: user
 * @Author: wangdakuan
 * @Date: 2019/3/14 5:14 PM
 */
public class UserPresenter extends BasePresenter<UserView> {

    private UserServer mHomeServer;

    public UserPresenter() {
        mHomeServer = new UserServer();
    }

    public void getUser(HashMap<String, String> hashMap) {
        mHomeServer.getUser(new MYObserver<UserInfoData>(getView(),this){
            @Override
            public void onNext(UserInfoData userInfoDataDataResponse) {
                super.onNext(userInfoDataDataResponse);
                getView().showData("-----通过-----");
            }
        },hashMap);
    }
}