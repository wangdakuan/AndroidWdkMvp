package com.wdk.viewactivity.page;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wdk.baseapp.base.BaseTitleActivity;
import com.wdk.viewactivity.R;

/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: MayDayActivityPage
 * Author: wangdakuan
 * Date: 2019/3/22 10:57 AM
 * Description: 五一活动
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
@Route(path = "/view_activity/MayDayActivityPage")
public class MayDayActivityPage extends BaseTitleActivity {

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.page_may_day_activity;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {

    }

    @Override
    public void doBusiness() {

    }
}
