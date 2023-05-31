package com.example.springboot.example.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "result结果",description = "后端返回给前端的结果")
public class Result<T> implements Serializable {
    @ApiModelProperty(value = "返回的结果code，200表示成功")
    private String statusCode = ResultType.SUCCESS.getCode();

    @ApiModelProperty(value = "返回的提示信息")
    private String message = ResultType.SUCCESS.getName();

    @ApiModelProperty(value = "返回数据结果，可以为空")
    private T data = null;

    public String getStatusCode() { return statusCode; }

    public void setStatusCode(String statusCode) { this.statusCode = statusCode; }

    public String getMessage(){return message;}

    public void setMessage(String message){this.message = message;}

    public T getData(){return data;}

    public void setData(T data){this.data = data;}

    public void addError(){this.addError(""); }

    public void addError(String message){
        this.message = message;
        this.statusCode = ResultType.INTERNAL_SERVER_ERROR.getCode();
        if(this.message == null || "".equals(this.message)){
            this.message = ResultType.INTERNAL_SERVER_ERROR.getName();
        }
    }

    public void success(){this.success(""); }

    public void success(String message){
        this.message = message;
        this.statusCode = ResultType.SUCCESS.getCode();
        if(this.message == null || "".equals(this.message)){
            this.message = ResultType.SUCCESS.getName();
        }
    }

    public void fail(){this.fail(""); }

    public void fail(String message){
        this.message = message;
        this.statusCode = ResultType.FAIL.getCode();
        if(this.message == null || "".equals(this.message)){
            this.message = ResultType.FAIL.getName();
        }
    }

    public void unauthorized(){this.unauthorized(""); }

    public void unauthorized(String message){
        this.message = message;
        this.statusCode = ResultType.UNAUTHORIZED.getCode();
        if(this.message == null || "".equals(this.message)){
            this.message = ResultType.UNAUTHORIZED.getName();
        }
    }

    public void notFound(){this.notFound(""); }

    public void notFound(String message){
        this.message = message;
        this.statusCode = ResultType.NOT_FOUNT.getCode();
        if(this.message == null || "".equals(this.message)){
            this.message = ResultType.NOT_FOUNT.getName();
        }
    }

    public void againLogin(){this.againLogin(""); }

    public void againLogin(String message){
        this.message = message;
        this.statusCode = ResultType.AGAIN_LOGIN.getCode();
        if(this.message == null || "".equals(this.message)){
            this.message = ResultType.AGAIN_LOGIN.getName();
        }
    }
}
