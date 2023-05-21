package com.earnmoneynow.partners.global.error.exception;

import com.earnmoneynow.partners.global.error.ErrorCode;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends CustomException {

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode, HttpStatus.NOT_FOUND);
    }
}
