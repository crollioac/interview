package com.interview.errors;

import java.util.Objects;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer errorCode;
	private String msg;

	public CustomException(Integer errorCode, String msg) {
		super();
		Objects.requireNonNull(errorCode);
		this.errorCode = errorCode;
		this.msg = msg;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
