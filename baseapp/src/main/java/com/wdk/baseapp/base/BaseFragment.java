/**
 * FileName: BaseFragment
 * Author: wangdakuan
 * Date: 2019/3/14 2:48 PM
 * Description: fragment基类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.wdk.baseapp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.common.bar.UltimateBar;
import com.common.pageloading.PageStateLayout;
import com.common.utils.ToastUtils;
import com.wdk.viewmodel.base.BasePresenter;
import com.wdk.viewmodel.base.IBaseMvpView;

/**
 * @ClassName: BaseFragment
 * @Description: fragment基类
 * @Author: wangdakuan
 * @Date: 2019/3/14 2:48 PM
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements IBasePageView, IBaseMvpView {

    public T mPresenter;

    /**
     * 当前Activity渲染的视图View
     */
    protected View contentView;
    /**
     * 标题视图view
     */
    protected View titleView;
    /**
     * 上次点击时间
     */
    private long lastClick = 0;

    protected Activity mActivity;

    protected PageStateLayout mLayout;
    protected UltimateBar mUltimateBar;

    /**
     * ViewPager时进行当前显示页面刷新
     */
    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;
    protected boolean isDataInitiated;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        mUltimateBar = new UltimateBar(mActivity);
        /**
         * 初始化数据方法
         */
        Bundle bundle = getArguments();
        initData(bundle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initPageState();
        /**
         * 设置标题布局
         */
        setTitleView(0);

        return getBaseView(bindLayout());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /**
         * 初始化控件方法
         */
        initView(savedInstanceState, view);

        /**
         * 业务操作方法
         */
        doBusiness();
    }

    /**
     * ViewPager 时使用
     * 当前页面刷新
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }

    /**
     * ViewPager 时使用
     * 当前页面刷新
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();
    }

    /**
     * ViewPager 时使用
     * 当前页面刷新
     */
    public void fetchData() {

    }

    /**
     * ViewPager 时使用
     * 当前页面刷新
     */
    public boolean prepareFetchData() {
        return prepareFetchData(false);
    }

    /**
     * ViewPager 时使用
     * 当前页面刷新
     */
    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }


    private void initPageState() {
        mLayout = new PageStateLayout(mActivity);
        mLayout.setOnEmptyListener(null)
                .setOnErrorListener(null);
    }

    /**
     * 标题布局
     */
    protected void setTitleView(@LayoutRes int layoutId) {
        if (0 != layoutId) {
            titleView = LayoutInflater.from(mActivity).inflate(layoutId, null);
        }
    }

    /**
     * 页面布局
     *
     * @param layoutId
     */
    protected View getBaseView(@LayoutRes int layoutId) {
        LinearLayout layout = new LinearLayout(mActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        if (0 != layoutId) {
            contentView = LayoutInflater.from(mActivity).inflate(layoutId, null);
            if (titleView != null) {
                layout.addView(titleView, 0);
            }
            mLayout.load(layout, contentView);
            mLayout.onSucceed();
        }
        layout.setLayoutParams(layoutParams);
        return layout;
    }

    /**
     * 判断是否快速点击
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    private boolean isFastClick() {
        long now = System.currentTimeMillis();
        if (now - lastClick >= 200) {
            lastClick = now;
            return false;
        }
        return true;
    }

//    /**
//     * 控件的点击事件初始化
//     *
//     * @param view
//     */
//    @Override
//    public void onClick(final View view) {
//        if (!isFastClick()) onWidgetClick(view);
//    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != mPresenter) {
            mPresenter.detachView();
        }

    }

    /**
     * 显示请求框
     */
    @Override
    public void showLoading() {
        if (null != mLayout) {
            mLayout.onRequesting();
        }
    }

    /**
     * 隐藏请求框
     */
    @Override
    public void hideLoading() {
        if (null != mLayout) {
            mLayout.onSucceed();
        }
    }

    /**
     * 接口请求提示
     *
     * @param msg
     */
    @Override
    public void showToast(String msg) {
        if (null != mLayout) {
            mLayout.onSucceed();
        }
        ToastUtils.showShortSafe(msg);
    }

    /**
     * 接口请求错误()
     */
    @Override
    public void showErr(Throwable e) {
        if (null != mLayout) {
            mLayout.onSucceed();
        }
        ToastUtils.showShortSafe(e.getMessage());
    }

    /**
     * 获取上下文
     *
     * @return
     */
    @Override
    public Context getContext() {
        return this.getActivity();
    }
}