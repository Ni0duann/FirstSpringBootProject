package com.demo.demo;

public class Response <T>{
    private T data;
    private boolean success;
    private String errorMsg;

    public static <k> Response<k> newSuccess(k data) {
        Response<k> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static Response<Void> newFail(String erroMsg) {
        Response<Void> response = new Response<>();
        response.setErrorMsg(erroMsg);
        response.setSuccess(false);
        return response;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
