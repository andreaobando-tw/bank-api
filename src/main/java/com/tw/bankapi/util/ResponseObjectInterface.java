package com.tw.bankapi.util;

public interface ResponseObjectInterface {
    void setStatus(Integer status);

    void setCode(String code);

    void setMessage(String message);

    void setData(Object data);
}
