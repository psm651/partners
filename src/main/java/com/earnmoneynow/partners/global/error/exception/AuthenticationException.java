package com.earnmoneynow.partners.global.error.exception;

import com.earnmoneynow.partners.global.error.ErrorCode;
import org.springframework.http.HttpStatus;

public class AuthenticationException extends CustomException {

	public AuthenticationException(ErrorCode errorCode) {
		super(errorCode, HttpStatus.UNAUTHORIZED);
	}
}
