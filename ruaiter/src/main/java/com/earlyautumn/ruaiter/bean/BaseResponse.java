package com.earlyautumn.ruaiter.bean;

public class BaseResponse {

    public static final BaseResponse ERROR_RESPONSE = new BaseResponse(200, "error");
    public static final BaseResponse SUCCESS_RESPONSE = new BaseResponse(5010, "success");

    private Integer code;
    private String message;


    public BaseResponse() {
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
