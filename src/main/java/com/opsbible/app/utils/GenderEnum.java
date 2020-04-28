package com.opsbible.app.utils;

public enum GenderEnum {

    MALE("M", "男"),
    FEMALE("F", "女");

    private String code;
    private String gender;

    GenderEnum(String code, String message) {
        this.code = code;
        this.gender = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return gender;
    }
}
