package com.tw.bankapi.util;

public enum BankApiResponse implements KeyResponseInterface {
    SUCCESSFUL_TRANSACTION("SUCCESSFUL_TRANSACTION"),
    USER_NO_FOUND_LOGIN("USER_NO_FOUND_LOGIN"),
    INCOMPLETE_PARAMETERS("INCOMPLETE_PARAMETERS"),

    PARAMETER_NULL("PARAMETER_NULL");

    public final String key;

    BankApiResponse(String key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return key;
    }
}
