package com.imis.frame.utils;

/**
 * Description: 返回前台的信息类
 * Author: zcx
 * Date: Created in 2019/8/4 22:54
 * Version: 1.0
 */
public class OperateInfo {

    //操作执行成功标识
    private boolean operateSuccess = true;
    //操作后的提示信息
    private String operateMessage = "操作成功";
    //错误信息
    private Object errorInfo;
    //返回前台的json数据
    private String data;

    public boolean isOperateSuccess() {
        return operateSuccess;
    }

    public void setOperateSuccess(boolean operateSuccess) {
        this.operateSuccess = operateSuccess;
    }

    public String getOperateMessage() {
        return operateMessage;
    }

    public void setOperateMessage(String operateMessage) {
        this.operateMessage = operateMessage;
    }

    public Object getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(Object errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
