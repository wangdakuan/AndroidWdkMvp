package com.wdk.viewuser.fragment;

import android.support.annotation.Keep;
import android.view.View;

import com.wdk.baseapp.base.BaseFragment;
import com.wdk.baseapp.base.IViewDelegate;


/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: MyViewDelegate
 * Author: wangdakuan
 * Date: 2019/3/22 10:50 AM
 * Description: fragment管理用于外部model调用
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
@Keep
public class MyViewDelegate implements IViewDelegate {

    @Override
    public BaseFragment getFragment(String name) {
        return HomeUserFragment.newInstance("HomeUserFragment");
    }

    @Override
    public View getView(String name) {
        return null;
    }
}
