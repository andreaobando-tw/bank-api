package com.tw.bankapi.util;

public class ResponseObject extends ResponseObjectAbstract {

    public ResponseObject(Integer status, String code, String message, Object data) {
        super(status, code, message, data );
    }

    public ResponseObject() {
    }
}
