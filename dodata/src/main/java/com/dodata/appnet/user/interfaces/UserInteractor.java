/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: UserInteractor
 * Author: wangdakuan
 * Date: 2019/3/14 4:09 PM
 * Description: home的接口
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.dodata.appnet.user.interfaces;

import com.dodata.appnet.model.user.UserInfoData;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * @ClassName: UserInteractor
 * @Description: user的接口
 * @Author: wangdakuan
 * @Date: 2019/3/14 4:09 PM
 */
public interface UserInteractor {
    /**
     * 用户信息
     * @param hashMap
     * @return
     */
    Observable<UserInfoData> getUser(HashMap<String,String> hashMap);
}