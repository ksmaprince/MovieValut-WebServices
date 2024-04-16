package com.khun.movievault.advice;

import com.khun.movievault.exception.UserInvalidCredentialException;
import com.khun.movievault.exception.UserDuplicateException;
import com.khun.movievault.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MovieVaultExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserDuplicateException.class)
    public Map<String, String> handleUserDuplicateErrors(UserDuplicateException userDuplicateException){
        var errorMap = new HashMap<String, String>();
        errorMap.put("Error Message", userDuplicateException.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> handleUserNotFoundError(UserNotFoundException userNotFoundException){
        var errorMap = new HashMap<String, String>();
        errorMap.put("Error Message", userNotFoundException.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UserInvalidCredentialException.class)
    public Map<String, String> handleInvalidUserError(UserInvalidCredentialException invalidUserCredentialException){
        var errorMap = new HashMap<String, String>();
        errorMap.put("Error Message", invalidUserCredentialException.getMessage());
        return errorMap;
    }
}