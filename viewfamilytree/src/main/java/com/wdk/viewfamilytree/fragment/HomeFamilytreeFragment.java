package com.wdk.viewfamilytree.fragment;

import android.os.Bundle;
import android.view.View;

import com.wdk.baseapp.base.BaseFragment;
import com.wdk.viewfamilytree.R;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: HomeFamilytreeFragment
 * Author: wangdakuan
 * Date: 2019/3/22 10:54 AM
 * Description: 首页五缘谱
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class HomeFamilytreeFragment extends BaseFragment {


    public static BaseFragment newInstance(String tag) {
        Bundle bundle = new Bundle();
        bundle.putString("TAG", tag);
        HomeFamilytreeFragment fragment = new HomeFamilytreeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home_familytree;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {

    }

    @Override
    public void doBusiness() {

    }
}
