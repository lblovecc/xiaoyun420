package com.xiaoyun.base.excpetion;

public class ZjsException extends RuntimeException {
    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public ZjsException(String errorCode) {
        super("");
        this.errorCode = errorCode;
    }
}
