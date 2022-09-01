package com.tw.bankapi.util.exceptions;

import com.tw.bankapi.util.KeyResponseInterface;

public class BankApiException extends RuntimeException{
    //Variables to adapt the exception into the api envelope
    private String responseCode;
    private String codeValue;
    private String messageValue;
    private Object data = null;

    public BankApiException() {
    }

    public BankApiException(KeyResponseInterface responseCode) {
        super(responseCode.getValue());
        this.responseCode = responseCode.getValue();
    }

    public BankApiException(String responseCode) {
        super(responseCode);
        this.responseCode = responseCode;
    }

    public BankApiException(String codeValue, String messageValue) {
        super(messageValue);
        this.codeValue = codeValue;
        this.messageValue = messageValue;
    }

    public BankApiException(KeyResponseInterface responseCode, Object data) {
        super(responseCode.getValue());
        this.responseCode = responseCode.getValue();
        this.data = data;
    }

    public BankApiException(String responseCode, Object data) {
        super(responseCode);
        this.responseCode = responseCode;
        this.data = data;
    }

    public BankApiException(String codeValue, String messageValue, Object data) {
        super(messageValue);
        this.codeValue = codeValue;
        this.messageValue = messageValue;
        this.data = data;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getMessageValue() {
        return messageValue;
    }

    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}