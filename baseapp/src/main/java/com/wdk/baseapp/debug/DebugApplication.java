/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: DebugApplication
 * Author: wangdakuan
 * Date: 2019/3/21 11:21 AM
 * Description: 单独运行使用的Application
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.wdk.baseapp.debug;

import com.wdk.baseapp.base.BaseApplication;

/**
 * @ClassName: DebugApplication
 * @Description: java类作用描述
 * @Author: wangdakuan
 * @Date: 2019/3/21 11:21 AM
 */
public class DebugApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        login();
    }

    /**
     * 在这里模拟登陆，然后拿到sessionId或者Token
     * 这样就能够在组件请求接口了
     */
    private void login() {
    }
}
