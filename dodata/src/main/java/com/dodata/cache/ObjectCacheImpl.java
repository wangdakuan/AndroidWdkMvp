package com.dodata.cache;

import android.content.Context;
import android.text.TextUtils;

import com.common.utils.CacheUtils;

import org.reactivestreams.Subscriber;

import java.io.Serializable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


/**
 * 作者：wangdakuan
 * 主要功能：接口数据缓存
 * 创建时间：2017/6/23 09:48
 */
public class ObjectCacheImpl implements ObjectCache<Object> {
    CacheUtils aCache;

    public ObjectCacheImpl() {
        aCache = CacheUtils.getInstance();
    }

    @Override
    public synchronized Observable<Object> get(final String key) {
        return Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
//                String fileContent = aCache.getAsString(key);
                Object userEntity = aCache.getSerializable(key);
//                if (null != aClass) {
//                    userEntity = JSON.parseObject(fileContent, aClass);
//                }
                if (userEntity != null) {
                    e.onNext(userEntity);
                    e.onComplete();
                } else {
                    e.onError(new IllegalStateException());
                }
            }
        });
    }
//
//    @Override
//    public synchronized Observable<Object> get(final String key, final Class<?> aClass, final Class<?> bClass) {
//        return Observable.create(new Observable.OnSubscribe<Object>() {
//            @Override
//            public void call(Subscriber<? super Object> subscriber) {
//                String fileContent = aCache.getAsString(key);
//                Object userEntity = fileContent;
//                if (null != aClass) {
//                    if(aClass == JsonResponse.class){
//                        userEntity = JSON.parseObject(fileContent, aClass);
//                        JsonResponse response = (JsonResponse) userEntity;
//                        response.setData(JSON.parseObject(response.getData().toString(),bClass));
//                        userEntity = response;
//                    }
//                }
//                if (userEntity != null) {
//                    subscriber.onNext(userEntity);
//                    subscriber.onCompleted();
//                } else {
//                    subscriber.onError(new IllegalStateException());
//                }
//            }
//        });
//    }


//    @Override
//    public synchronized Observable<Object> getList(final String key, final Class<?> aClass, final Class<?> bClass) {
//        return Observable.create(new Observable.OnSubscribe<Object>() {
//            @Override
//            public void call(Subscriber<? super Object> subscriber) {
//                String fileContent = aCache.getAsString(key);
//                Object userEntity = fileContent;
//                if (null != aClass) {
//                    if(aClass == JsonResponse.class){
//                        userEntity = JSON.parseObject(fileContent, aClass);
//                        JsonResponse response = (JsonResponse) userEntity;
//                        response.setData(JSON.parseArray(response.getData().toString(),bClass));
//                        userEntity = response;
//                    }
//                }
//                if (userEntity != null) {
//                    subscriber.onNext(userEntity);
//                    subscriber.onCompleted();
//                } else {
//                    subscriber.onError(new IllegalStateException());
//                }
//            }
//        });
//    }


//    @Override
//    public synchronized Observable<Object> getList(final String key, final Class<?> aClass) {
//        return Observable.create(new Observable.OnSubscribe<Object>() {
//            @Override
//            public void call(Subscriber<? super Object> subscriber) {
//
//                String fileContent = aCache.getAsString(key);
//                Object userEntity = fileContent;
//                if (null != aClass) {
//                    userEntity = JSON.parseArray(fileContent, aClass);
//                }
//                if (userEntity != null) {
//                    subscriber.onNext(userEntity);
//                    subscriber.onCompleted();
//                } else {
//                    subscriber.onError(new IllegalStateException());
//                }
//            }
//        });
//    }

    @Override
    public void put(Serializable objectEntity, String key) {
        aCache.put(key, objectEntity, CacheUtils.DAY);
    }

    public void put(String key, String object) {
        aCache.put(key, object);
    }

    public Object getAsString(String key) {
        return aCache.getSerializable(key);
    }

    @Override
    public boolean isCached(String key) {
        return TextUtils.isEmpty(aCache.getString(key)) ? false : true;
    }
}

