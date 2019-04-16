package com.wdk.baseapp.base;

import android.support.annotation.Keep;
import android.view.View;

/**
 * 作者：wangdakuan
 * 日期：2018/8/27 15:32
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：
 */
@Keep
public interface IViewDelegate {

    BaseFragment getFragment(String name);

    View getView(String name);
}
