/**
 * FileName: IBaseMvpView
 * Author: wangdakuan
 * Date: 2019/3/14 2:20 PM
 * Description: MVP基础类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.wdk.viewmodel.base;

import android.content.Context;

/**
 * @ClassName: IBaseMvpView
 * @Description: MVP基础类
 * @Author: wangdakuan
 * @Date: 2019/3/14 2:20 PM
 */
public interface IBaseMvpView {
    /**
     * 显示正在加载view
     */
    void showLoading();
    /**
     * 关闭正在加载view
     */
    void hideLoading();
    /**
     * 显示提示
     * @param msg
     */
    void showToast(String msg);
    /**
     * 显示请求错误提示
     */
    void showErr(Throwable e);

    /**
     * 获取上下文
     * @return 上下文
     */
    Context getContext();
}