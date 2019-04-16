/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: StartMainPage
 * Author: wangdakuan
 * Date: 2019/3/20 2:38 PM
 * Description: 入口页面
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.wdk.viewmain.page;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.common.utils.ActivityUtils;
import com.wdk.baseapp.base.BaseActivity;
import com.wdk.viewmain.R;
import com.wdk.viewmain.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ClassName: StartMainPage
 * @Description: 入口页面
 * @Author: wangdakuan
 * @Date: 2019/3/20 2:38 PM
 */
public class StartMainPage extends BaseActivity {

    @BindView(R2.id.fragment_content)
    LinearLayout mFragmentContent;

    @Override
    public void initData(Bundle bundle) {
    }

    @Override
    public int bindLayout() {
        return R.layout.start_page_main;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this);
    }

    @Override
    public void doBusiness() {
        ActivityUtils.navigateTo(HomePage.class);
    }

}