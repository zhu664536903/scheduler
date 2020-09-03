package com.gczhu.schedule.result;

public class ResultObject {
    private int code;
    private String message;
    private Object data;

    public ResultObject(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultObject resultObjectOK(Object d){
        return new ResultObject(200,"响应成功",d);
    }
    public static ResultObject resultObjectError(String msg){
        return new ResultObject(500,msg,null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
