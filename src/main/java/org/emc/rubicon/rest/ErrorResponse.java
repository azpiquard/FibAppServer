package org.emc.rubicon.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Test and learning exercise on Fibonacci Algorithm 3/15/2018
 */
@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Wrong input")
public class ErrorResponse {
    String errorCode;
    String message;

    public ErrorResponse(String errorCode, String message) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
