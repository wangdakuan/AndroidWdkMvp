package com.wdk.viewpost.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.common.utils.ActivityUtils;
import com.wdk.baseapp.base.BaseFragment;
import com.wdk.viewmodel.base.BasePresenter;
import com.wdk.viewmodel.user.UserPresenter;
import com.wdk.viewmodel.user.viewinteractor.UserView;
import com.wdk.viewpost.R;
import com.wdk.viewpost.R2;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: HomePostFragment
 * Author: wangdakuan
 * Date: 2019/3/22 10:47 AM
 * Description: 首页帖子列表页面
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class HomePostFragment extends BaseFragment<BasePresenter> implements UserView {

    public static final String TAG = "HomePostFragment";

    @BindView(R2.id.btn_page)
    Button mBtnPage;
    @BindView(R2.id.btn_request)
    Button mBtnRequest;
    private View view;
    private Unbinder unbinder;
    private UserPresenter mUserPresenter;

    public static BaseFragment newInstance(String tag) {
        Bundle bundle = new Bundle();
        bundle.putString("TAG", tag);
        HomePostFragment fragment = new HomePostFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home_post;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void doBusiness() {
        mUserPresenter = new UserPresenter();
        mUserPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mUserPresenter.detachView();
    }

    @OnClick({R2.id.btn_page, R2.id.btn_request})
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_page) {
            ActivityUtils.navigateUrlTo("/view_activity/MayDayActivityPage");
        } else if (i == R.id.btn_request) {
            mUserPresenter.getUser(new HashMap<String, String>());
        } else {
        }
    }

    @Override
    public void showData(String data) {

    }
}
