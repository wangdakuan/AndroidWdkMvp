package com.wdk.viewmain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: LoadingView
 * Author: wangdakuan
 * Date: 2019/3/25 1:41 PM
 * Description: ${DESCRIPTION}
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class LoadingView extends View {
    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView() {

        Bitmap dstBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.kaopu_icon);
        // 图片宽度的一半
        int dstWidth = dstBmp.getWidth() / 2;
        // 图片高度的一半
        int dstHeight = dstBmp.getHeight() / 2;


    }
}
