/**
 * FileName: BasePresenter
 * Author: wangdakuan
 * Date: 2019/3/14 2:36 PM
 * Description: MVP的presenter基类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.wdk.viewmodel.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @ClassName: BasePresenter
 * @Description: MVP的presenter基类
 * @Author: wangdakuan
 * @Date: 2019/3/14 2:36 PM
 */
public class BasePresenter<V extends IBaseMvpView> {
    /**
     * 订阅者的统计
     */
    private CompositeDisposable compositeDisposable;
    /**
     * 绑定的view
     */
    private V mvpView;

    private IBaseMvpView mMvpView;

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mvpView = null;
        dispose();
    }

    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached() {
        return mvpView != null;
    }

    /**
     * 获取连接的view
     */
    public V getView() {
        return mvpView;
    }

    /**
     * 记录请求的订阅者
     *
     * @param disposable
     */
    public void onSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    /**
     * 撤销
     */
    private void dispose() {
        if (compositeDisposable != null) compositeDisposable.dispose();
    }
}