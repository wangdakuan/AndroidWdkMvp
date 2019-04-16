package com.wdk.viewmain.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.common.utils.ClassUtils;
import com.wdk.baseapp.base.BaseFragment;
import com.wdk.baseapp.base.BaseTitleActivity;
import com.wdk.baseapp.base.IViewDelegate;
import com.wdk.viewmain.R;
import com.wdk.viewmain.R2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: HomePage
 * Author: wangdakuan
 * Date: 2019/3/22 11:09 AM
 * Description: ${DESCRIPTION}
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class HomePage extends BaseTitleActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R2.id.fragment_content)
    LinearLayout mFragmentContent;
    @BindView(R2.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;

    private Fragment mFragmentOne;
    private Fragment mFragmentTwo;
    private Fragment mFragmentThree;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.page_home;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setBarBackgroundColor(R.color.colorAccent);//set background color for navigation bar
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round, "").setActiveColorResource(R.color.colorPrimary)
                .setInactiveIconResource(R.mipmap.ic_launcher_round).setInActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round, "").setActiveColorResource(R.color.colorPrimary)
                        .setInactiveIconResource(R.mipmap.ic_launcher_round).setInActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher_round, "").setActiveColorResource(R.color.colorPrimary)
                        .setInactiveIconResource(R.mipmap.ic_launcher_round).setInActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * 初始化默认页面
     */
    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mFragmentOne = getHomePostFragment();
        if (null != mFragmentOne) {
            transaction.replace(R.id.fragment_content, mFragmentOne).commit();
        }
    }

    /**
     * 帖子
     *
     * @return
     */
    private BaseFragment getHomePostFragment() {
        BaseFragment newsFragment = null;
        List<IViewDelegate> viewDelegates = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.wdk.viewpost");
        if (viewDelegates != null && !viewDelegates.isEmpty()) {
            newsFragment = viewDelegates.get(0).getFragment("HomePostFragment");
        }
        return newsFragment;
    }

    /**
     * 个人信息
     *
     * @return
     */
    private BaseFragment getHomeUserFragment() {
        BaseFragment newsFragment = null;
        List<IViewDelegate> viewDelegates = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.wdk.viewuser.fragment");
        if (viewDelegates != null && !viewDelegates.isEmpty()) {
            newsFragment = viewDelegates.get(0).getFragment("HomeUserFragment");
        }
        return newsFragment;
    }

    /**
     * 五缘谱
     *
     * @return
     */
    private BaseFragment getHomeFamilytreeFragment() {
        BaseFragment newsFragment = null;
        List<IViewDelegate> viewDelegates = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.wdk.viewfamilytree.fragment");
        if (viewDelegates != null && !viewDelegates.isEmpty()) {
            newsFragment = viewDelegates.get(0).getFragment("HomeFamilytreeFragment");
        }
        return newsFragment;
    }


    @Override
    public void doBusiness() {

    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mFragmentOne == null) {
                    mFragmentOne = getHomePostFragment();
                }
                if (null != mFragmentOne) {
                    transaction.replace(R.id.fragment_content, mFragmentOne);
                }
                break;
            case 1:
                if (mFragmentTwo == null) {
                    mFragmentTwo = getHomeFamilytreeFragment();
                }
                if (null != mFragmentTwo) {
                    transaction.replace(R.id.fragment_content, mFragmentTwo);
                }
                break;
            case 2:
                if (mFragmentThree == null) {
                    mFragmentThree = getHomeUserFragment();
                }
                if (null != mFragmentThree) {
                    transaction.replace(R.id.fragment_content, mFragmentThree);
                }
                break;
            default:
                if (mFragmentOne == null) {
                    mFragmentOne = getHomePostFragment();
                }
                if (null != mFragmentOne) {
                    transaction.replace(R.id.fragment_content, mFragmentOne);
                }
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
