package com.tw.bankapi.util;

public class ResponseObject extends ResponseObjectAbstract {

    public ResponseObject(Integer status, String code, String message, Object data, String appInfo) {
        super(status, code, message, data,appInfo );
    }

    public ResponseObject() {
    }
}
