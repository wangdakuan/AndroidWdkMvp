/**
 * FileName: UserView
 * Author: wangdakuan
 * Date: 2019/3/14 3:16 PM
 * Description: 个人信息的View
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.wdk.viewmodel.user.viewinteractor;

import com.wdk.viewmodel.base.IBaseMvpView;

/**
 * @ClassName: UserView
 * @Description: 个人信息的View
 * @Author: wangdakuan
 * @Date: 2019/3/14 3:16 PM
 */
public interface UserView extends IBaseMvpView {
    void showData(String data);
}