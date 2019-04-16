package com.wdk.baseapp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.common.bar.UltimateBar;
import com.common.pageloading.PageStateLayout;
import com.common.utils.KeyBoardUtils;
import com.common.utils.ToastUtils;
import com.wdk.viewmodel.base.BasePresenter;
import com.wdk.viewmodel.base.IBaseMvpView;

/**
 * 作者：wangdakuan
 * 日期：2017/9/4 10:26
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：activity 基类
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBasePageView, IBaseMvpView {

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

    protected BaseActivity mActivity;
    protected UltimateBar mUltimateBar;

    protected PageStateLayout mLayout;

    protected BaseActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        mUltimateBar = new UltimateBar(this);
        mUltimateBar.setImmersionBar();
        mActivity = this;
        /**
         * 初始化数据方法
         */
        Bundle bundle = getIntent().getExtras();
        initData(bundle);
        initPageState();
        /**
         * 设置标题布局
         */
        setTitleView(0);
        /**
         * 初始化绑定总布局
         */
        setBaseView(bindLayout());

        /**
         * 初始化控件方法
         */
        initView(savedInstanceState, contentView);
        /**
         * 业务操作方法
         */
        doBusiness();
    }

    private void initPageState() {
        mLayout = new PageStateLayout(this);
        mLayout.setOnEmptyListener(null)
                .setOnErrorListener(null);
    }

    /**
     * 标题布局
     */
    protected void setTitleView(@LayoutRes int layoutId) {
        if (0 != layoutId) {
            titleView = LayoutInflater.from(this).inflate(layoutId, null);
            mUltimateBar.addMarginTopEqualStatusBarHeight(titleView, this);
        }
    }

    /**
     * 页面布局
     *
     * @param layoutId
     */
    protected void setBaseView(@LayoutRes int layoutId) {
        LinearLayout layout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        if (0 != layoutId) {
            contentView = LayoutInflater.from(this).inflate(layoutId, null);
            mLayout.load(layout, contentView);
            mLayout.onSucceed();
        }
        if (titleView != null) {
            layout.addView(titleView, 0);
        } else {
            if (null != contentView) {
                mUltimateBar.addMarginTopEqualStatusBarHeight(contentView, this);
            }
        }
        setContentView(layout, layoutParams);
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

    /**
     * 控件的点击事件初始化
     *
     * @param view
     */
//    @Override
//    public void onClick(final View view) {
//        View v = getCurrentFocus();
//        if (isFocusEditText(v, hideSoftByEditViewIds())) {
//            KeyBoardUtils.hideInputForce(this);
//            clearViewFocus(v, hideSoftByEditViewIds());
//        }
//        if (!isFastClick()) onWidgetClick(view);
//    }

    //region软键盘的处理

    /**
     * 清除editText的焦点
     *
     * @param v   焦点所在View
     * @param ids 输入框
     */
    public void clearViewFocus(View v, int... ids) {
        if (null != v && null != ids && ids.length > 0) {
            for (int id : ids) {
                if (v.getId() == id) {
                    v.clearFocus();
                    break;
                }
            }
            if (null != titleView) {
                titleView.setFocusable(true);
                titleView.setFocusableInTouchMode(true);
                titleView.requestFocus();
            } else {
                if (null != contentView) {
                    contentView.setFocusable(true);
                    contentView.setFocusableInTouchMode(true);
                    contentView.requestFocus();
                }
            }
        }
    }

    /**
     * 隐藏键盘
     *
     * @param v   焦点所在View
     * @param ids 输入框
     * @return true代表焦点在edit上
     */
    public boolean isFocusEditText(View v, int... ids) {
        if (null == v) {
            return false;
        }
        if (null == ids) {
            return false;
        }
        if (v instanceof EditText) {
            EditText tmp_et = (EditText) v;
            for (int id : ids) {
                if (tmp_et.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 是否触摸在指定view上面,对某个控件过滤
     *
     * @param views
     * @param ev
     * @return
     */
    public boolean isTouchView(View[] views, MotionEvent ev) {
        if (views == null || views.length == 0) return false;
        int[] location = new int[2];
        for (View view : views) {
            view.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            if (ev.getX() > x && ev.getX() < (x + view.getWidth())
                    && ev.getY() > y && ev.getY() < (y + view.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否触摸在指定view上面,对某个控件过滤
     *
     * @param ids
     * @param ev
     * @return
     */
    public boolean isTouchView(int[] ids, MotionEvent ev) {
        int[] location = new int[2];
        for (int id : ids) {
            View view = findViewById(id);
            if (view == null) continue;
            view.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            if (ev.getX() > x && ev.getX() < (x + view.getWidth())
                    && ev.getY() > y && ev.getY() < (y + view.getHeight())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (isTouchView(filterViewByIds(), ev)) return super.dispatchTouchEvent(ev);
            if (hideSoftByEditViewIds() == null || hideSoftByEditViewIds().length == 0)
                return super.dispatchTouchEvent(ev);
            View v = getCurrentFocus();
            if (isFocusEditText(v, hideSoftByEditViewIds())) {
                if (isTouchView(hideSoftByEditViewIds(), ev))
                    return super.dispatchTouchEvent(ev);
                //隐藏键盘
                KeyBoardUtils.hideInputForce(this);
                clearViewFocus(v, hideSoftByEditViewIds());

            }
        }
        return super.dispatchTouchEvent(ev);

    }

    /**
     * 传入EditText的Id
     * 没有传入的EditText不做处理
     *
     * @return id 数组
     */
    public int[] hideSoftByEditViewIds() {
        return null;
    }

    /**
     * 传入要过滤的View
     * 过滤之后点击将不会有隐藏软键盘的操作
     * 传入的控件点击后不会对显示的虚拟键盘做隐藏操作
     *
     * @return id 数组
     */
    public View[] filterViewByIds() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
//            mLayout.onSucceed();
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
//            mLayout.onSucceed();
        }
        ToastUtils.showShortSafe(msg);
    }

    /**
     * 接口请求错误()
     */
    @Override
    public void showErr(Throwable e) {
        if (null != mLayout) {
//            mLayout.onSucceed();
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
        return this;
    }
}
