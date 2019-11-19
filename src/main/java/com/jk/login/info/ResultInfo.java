package com.jk.login.info;

/**
* @description: 反馈给前端的信息
* @author: Jacks丶
* @date: 2019-11-19 18:26:55
* @version: 1.0
*/
public class ResultInfo<T> {
    //反馈给前端的信息
    private String msg;
    //请求状态信息
    private Boolean success = false;
    //返回具体的数据
    private T detail = null;

    @Override
    public String toString() {
        return "ResultInfo{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", detail=" + detail +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}
