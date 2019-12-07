package com.lckgroup.canteensys.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lckgroup.canteensys.util.constant.RespCode;

import java.util.Date;

public class ResponseVO<T> {
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private T data;
    @JsonProperty("timestamp")
    private Date timestamp = new Date();

    public void success(T data){
        this.status = RespCode.SUCCESS_CODE;
        this.message = RespCode.MSG_SUCCESS;
        this.data = data;
    }
    public void serverError() {
        this.status = RespCode.FAILURE_CODE;
        this.message = RespCode.MSG_SERVER_ERROR;
    }

    public void clientError() {
        this.status = RespCode.FAILURE_CODE;
        this.message = RespCode.MSG_CLIENT_DATA_ERROR;
    }

    public void error(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public void success(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
