/**
 * Copyright (C), 2019, 湖南靠谱科技股份有限公司
 * FileName: &Activity&
 * Author: wangdakuan
 * Date: 2019/3/28 3:54 PM
 * Description: 页面
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.wdk.viewmain.page;

import android.os.Bundle;
import android.view.View;

import com.wdk.baseapp.base.BaseFragment;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: &Activity&
 * Author:
 * Date:
 * Description: 根据UED页面展示
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class LoginFragment extends BaseFragment {

    public static final String TAG = "LoginFragment";

     public static BaseFragment newInstance(String tag) {
          Bundle bundle = new Bundle();
          bundle.putString("TAG", TAG);
          LoginFragment fragment = new LoginFragment();
          fragment.setArguments(bundle);
          return fragment;
     }

    /**
     * 处理上个页面的数据，或初始化数据
     * @param bundle 传递过来的bundle
     */
    @Override
    public void initData(Bundle bundle) {

    }

    /**
     * 页面展示的布局
     * @return
     */
    @Override
    public int bindLayout() {
        return 0;
    }

    /**
     * 初始化控件
     * @param savedInstanceState
     * @param view
     */
    @Override
    public void initView(Bundle savedInstanceState, View view) {

    }

    /**
     * 基本页面逻辑处理
     */
    @Override
    public void doBusiness() {

    }
}