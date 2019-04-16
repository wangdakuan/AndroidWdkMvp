/**
 * Copyright (C), 2015-2019, 湖南靠谱科技股份有限公司
 * FileName: HttpIllegalStateException
 * Author: wangdakuan
 * Date: 2019/3/20 10:45 AM
 * Description: 异常处理
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 基础数据层描述
 */
package com.dodata.net.error;

/**
 * @ClassName: HttpIllegalStateException
 * @Description: 异常处理
 * @Author: wangdakuan
 * @Date: 2019/3/20 10:45 AM
 */
public class HttpIllegalStateException extends IllegalStateException {

    private int code;
    private String errorMsg;

    public HttpIllegalStateException(int code, String errorMsg) {
        super(errorMsg);
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
