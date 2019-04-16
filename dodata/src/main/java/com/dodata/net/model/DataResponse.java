package com.dodata.net.model;

import java.io.Serializable;

/**
 * 作者：wangdakuan
 * 日期：2017/8/30 10:54
 * 邮箱：wangdakuan@kjtpay.com.cn
 * 功能：请求数据返回的对象
 */
public class DataResponse<T> implements Serializable {

    private static final long serialVersionUID = 5213230387175987834L;

    /**
     * 状态码
     */
    public Integer rstCode;

    /**
     * 状态说明
     */
    public String rstMsg;

    public Long serverTime;

//    public boolean isTokenError() {
//        if (rstCode != null && rstCode == 103) {
//            setRstMsg("登录超时或已经在其他设备登录，请重新登录");
//            return true;
//        } else
//            return false;
//    }

    public boolean isRequestSuccess() {
        if (rstCode != null && rstCode == 100) {
            return true;
        }
        if (rstCode != null && rstCode == 203) {
            return true;
        }
        if (rstCode != null && rstCode == 138) // 亲人关系与性别冲突
            return true;
        if (rstCode != null && rstCode == 139) //  对方被TA人添加，导致性别冲突,请联系对方注册后再添加
            return true;
        if (rstCode != null && rstCode == 115) {// 输入的号码是否注册
            return true;
        }
        if (rstCode != null && rstCode == 149) {// 合谱时候已添加但是对方未确认
            return true;
        }
        if (rstCode != null && rstCode == 200) {// 已经是亲人
            return true;
        }
        if (rstCode != null && rstCode == 160) {// 已经是亲人
            return true;
        }
        if (rstCode != null && rstCode == 161) {// 已经是亲人
            return true;
        }
        if (rstCode != null && rstCode == 204) {// 该号码已被已注册的会员使用
            return true;
        }
        if (rstCode != null && rstCode == 405) {// 评论已被删除！
            return true;
        }
        if (rstCode != null && rstCode == 406) {// 群公告详情已被删除！
            return true;
        }
        if (rstCode != null && rstCode == 500) {// 碟罗电话错误码
            return true;
        }
        if (rstCode!=null&&rstCode==156){//更换手机号,替换亲人
            return true;
        }
        if (rstCode!=null&&rstCode==301){//支付密码验证次数
            return true;
        }
        if (rstCode!=null&&rstCode==302){//如果操作者添加朋友   而要添加的那人的关系与操作者为亲人关系,操作者直接添加朋友成功
            return true;
        }
        if (rstCode!=null&&rstCode==303){//查看帖子详情页,帖子已被删除
            return true;
        }

        if (rstCode!=null&&rstCode==104){//孝行动已删除
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "LzyResponse{\n" +//
                "\tcode=" + rstCode + "\n" +//
                "\tmsg='" + rstMsg + "\'\n" +//
                "\ttime='" + serverTime + "\'\n" +//
                '}';
    }
}
