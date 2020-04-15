package com.evol;

import lombok.Data;

@Data
public class ApiResult<T> {
    private int code;
    private boolean success;
    private String message;
    private final T data;

    public ApiResult(StatusCodeEnum status, T value){
        this.code = status.getCode();
        this.message = status.getDescription();
        this.data = value;
        this.success = this.code == StatusCodeEnum.SUCCESS.getCode();


    }

    public ApiResult(StatusCodeEnum status, String message, T value){
        this.code = status.getCode();
        this.message = message;
        this.data = value;
        this.success = this.code == StatusCodeEnum.SUCCESS.getCode();

    }

    public static <T> ApiResult<T> success(T value){
        ApiResult result = new ApiResult(StatusCodeEnum.SUCCESS, StatusCodeEnum.SUCCESS.getDescription(), value);
        return result;
    }

    public static <T> ApiResult<T> paramError(){
        ApiResult result = new ApiResult(StatusCodeEnum.PARAMS_ERROR, StatusCodeEnum.PARAMS_ERROR.getDescription(), null);
        return result;
    }

    public static <T> ApiResult<T> paramError(String message){
        ApiResult result = new ApiResult(StatusCodeEnum.PARAMS_ERROR, message, null);
        return result;
    }
}
