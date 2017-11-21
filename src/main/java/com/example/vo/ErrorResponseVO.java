package com.example.vo;

public class ErrorResponseVO {
    /** The error code. */
    private String errorCode;

    /** The error message. */
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ErrorResponseVO [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
    }
}
