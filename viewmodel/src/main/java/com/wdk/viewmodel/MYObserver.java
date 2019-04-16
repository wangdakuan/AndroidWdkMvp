/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: MYObserver
 * Author: wangdakuan
 * Date: 2019/3/20 10:02 AM
 * Description: 请求回调监听
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.wdk.viewmodel;

import com.dodata.net.model.DataResponse;
import com.wdk.viewmodel.base.BasePresenter;
import com.wdk.viewmodel.base.IBaseMvpView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @ClassName: MYObserver
 * @Description: 请求回调监听
 * @Author: wangdakuan
 * @Date: 2019/3/20 10:02 AM
 */
public class MYObserver<T> implements Observer<T> {

    private IBaseMvpView mView;
    private BasePresenter mP;

    public MYObserver(IBaseMvpView view, BasePresenter p) {
        this.mView = view;
        this.mP = p;
    }

    /**
     * 开始加入订阅者开始
     * @param d
     */
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if (null != mView) {
            mView.showLoading();
        }
        if(null != mP){
            mP.onSubscribe(d);
        }
    }

    /**
     * 成功数据返回（只要接口回调成功）
     * @param t
     */
    @Override
    public void onNext(@NonNull T t) {
        if (null != mView && t instanceof DataResponse) {
            mView.showToast(((DataResponse) t).rstMsg);
        }
    }

    /**
     * 代码异常，程序报错（注意不是接口数据 错误）
     * @param e
     */
    @Override
    public void onError(@NonNull Throwable e) {
        if (null != mView) {
            mView.showErr(e);
        }
    }

    /**
     * 订阅者完成
     */
    @Override
    public void onComplete() {
        if (null != mView) {
            mView.hideLoading();
        }
    }


}