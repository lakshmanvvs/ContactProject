package com.example.controller.advice;

import com.example.vo.ContactUtil;
import com.example.vo.ErrorResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ContactcontrollerAdvice {
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    ResponseEntity<Object> handleControllerException(HttpServletRequest req, Throwable ex) {
        ErrorResponseVO errorResponse = new ErrorResponseVO();
        ex.printStackTrace();
        if (ex instanceof HttpMediaTypeNotSupportedException) {
            errorResponse.setErrorCode(ContactUtil.CM_API_001_CODE);
            errorResponse.setErrorMessage(ContactUtil.CM_API_001_DESC);
            return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
        } else if (ex instanceof HttpMessageNotReadableException) {
            errorResponse.setErrorCode(ContactUtil.CM_API_002_CODE);
            errorResponse.setErrorMessage(ContactUtil.CM_API_002_DESC);
            return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
            errorResponse.setErrorCode(ContactUtil.CM_API_003_CODE);
            errorResponse.setErrorMessage(ContactUtil.CM_API_003_DESC);
            return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
        } else if (ex instanceof HttpClientErrorException) {
            errorResponse.setErrorCode(ContactUtil.CM_API_006_CODE);
            errorResponse.setErrorMessage(ContactUtil.CM_API_006_DESC);
            return new ResponseEntity<Object>(errorResponse, ((HttpClientErrorException) ex).getStatusCode());
        } else if (ex instanceof IllegalArgumentException) {
            errorResponse.setErrorCode(ContactUtil.CM_API_005_CODE);
            errorResponse.setErrorMessage(ContactUtil.CM_API_005_DESC);
            return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
        } else {
            ex.printStackTrace();
            errorResponse.setErrorCode(ContactUtil.CM_API_006_CODE);
            errorResponse.setErrorMessage(ContactUtil.CM_API_006_DESC);
            return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    ResponseEntity<Object> handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentTypeMismatchException ex) {
        ErrorResponseVO errorResponse = new ErrorResponseVO();
        MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;

        errorResponse.setErrorCode(ContactUtil.CM_API_007_CODE);
        //errorResponse.setErrorMessage("Invalid argument(s) passed");
        errorResponse.setErrorMessage(exception.getParameter().getParameterName() + ContactUtil.CM_API_007_DESC);
        return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    ResponseEntity<Object> handleMethodArgumentTypeMismatchException(HttpServletRequest req, MethodArgumentTypeMismatchException ex) {
        ErrorResponseVO errorResponse = new ErrorResponseVO();
        MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;

        errorResponse.setErrorCode(ContactUtil.CM_API_007_CODE);
        //errorResponse.setErrorMessage("Invalid argument(s) passed");
        errorResponse.setErrorMessage(exception.getParameter().getParameterName() + ContactUtil.CM_API_007_DESC);
        return new ResponseEntity<Object>(errorResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    ResponseEntity<Object> handleMissingServletRequestParameterException(HttpServletRequest req, MissingServletRequestParameterException ex) {
        ErrorResponseVO errorResponse = new ErrorResponseVO();
        MissingServletRequestParameterException exception = (MissingServletRequestParameterException) ex;

        errorResponse.setErrorCode(ContactUtil.CM_API_008_CODE);
        //errorResponse.setErrorMessage("One or more required parameters are missing");
        errorResponse.setErrorMessage(exception.getParameterName() + ContactUtil.CM_API_008_DESC);
        return new ResponseEntity<Object>(errorResponse, HttpStatus.EXPECTATION_FAILED);
    }
}
