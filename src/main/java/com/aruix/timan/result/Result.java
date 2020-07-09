package com.aruix.timan.result;

public class Result {
    private int code;

    public Result code(int code) {
        this.code = code;
        return this;
    }
    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}