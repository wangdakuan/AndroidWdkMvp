package com.wdk.viewmodel;

import android.app.Application;
import android.content.Context;

import com.common.BuildConfig;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: OkHttpUtils
 * Author: wangdakuan
 * Date: 2019/3/22 10:07 AM
 * Description: ${DESCRIPTION}
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class OkHttpUtils {

    public static void initOkGo(Context context) {

        HttpHeaders headers = new HttpHeaders();
        HttpParams params = new HttpParams();
        //----------------------------------------------------------------------------------------//

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //log相关
        if (BuildConfig.LOG_SHOWS_DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("LKH");
            loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);        //log打印级别，决定了log显示的详细程度
            loggingInterceptor.setColorLevel(Level.INFO);                               //log颜色级别，决定了log在控制台显示的颜色
            builder.addInterceptor(loggingInterceptor);                                 //添加OkGo默认debug日志
        }
        //超时时间设置，默认60秒
        builder.readTimeout(15000L, TimeUnit.MILLISECONDS);      //全局的读取超时时间
        builder.writeTimeout(15000L, TimeUnit.MILLISECONDS);     //全局的写入超时时间
        builder.connectTimeout(15000L, TimeUnit.MILLISECONDS);   //全局的连接超时时间
        builder.cookieJar(new CookieJarImpl(new DBCookieStore(context)));              //使用数据库保持cookie，如果cookie不过期，则一直有效

        //https相关设置，以下几种方案根据需要自己设置
        //方法一：信任所有证书,不安全有风险
        HttpsUtils.SSLParams sslParams1 = HttpsUtils.getSslSocketFactory();
        builder.sslSocketFactory(sslParams1.sSLSocketFactory, sslParams1.trustManager);
        //配置https的域名匹配规则，详细看demo的初始化介绍，不需要就不要加入，使用不当会导致https握手失败
        builder.hostnameVerifier(new SafeHostnameVerifier());

        // 其他统一的配置
        OkGo.getInstance().init((Application) context)                           //必须调用初始化
                .setOkHttpClient(builder.build())               //建议设置OkHttpClient，不设置会使用默认的
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(0)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(headers)                      //全局公共头
                .addCommonParams(params);                       //全局公共参数
    }

    private static class SafeHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            //验证主机名是否匹配
            //return hostname.equals("server.jeasonlzy.com");
            return true;
        }
    }
}
