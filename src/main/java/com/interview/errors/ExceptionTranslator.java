package com.interview.errors;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionTranslator {

	@ExceptionHandler(CustomException.class)
	@ResponseBody
	public CustomError processErrorCodeException(CustomException exception) {
		CustomError error = new CustomError();
		error.setError("Error code exception");
		error.setException(CustomException.class.getName());
		error.setErrorCode(exception.getErrorCode().toString());
		error.setMessage(exception.getMsg());
		error.setPath("");
		error.setStatus(exception.getErrorCode().toString());
		error.setErrorMessage(exception.getMsg());
		return error;
	}
}
