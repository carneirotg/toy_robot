package com.code.boundary.robot.rest;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private String msg;
    
    private HttpStatus status;
    
    public ErrorResponse(HttpStatus status, String msg) {
        super();
        this.msg = msg;
        this.status = status;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
