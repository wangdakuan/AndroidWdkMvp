package com.wdk.viewmain.page;

import android.os.Bundle;
import android.view.View;

import com.wdk.baseapp.base.BaseTitleActivity;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: TestActivity
 * Author: wangdakuan
 * Date: 2019/3/28 2:48 PM
 * Description: ${DESCRIPTION}
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class TestActivity extends BaseTitleActivity {
    /**
     * 用于自定义标题栏
     * @param layoutId 不传默认base里的标题栏
     */
    @Override
    protected void setTitleView(int layoutId) {
        super.setTitleView(layoutId);
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
