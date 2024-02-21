package com.esalon.exception_handler;
import com.esalon.config.RunTimeExceptionPlaceHolder;
import com.esalon.exceptions.UserAlreadyExistsException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class SystemExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(RunTimeExceptionPlaceHolder.class)
    public Map<String, String> handleBusinessExceptions(RunTimeExceptionPlaceHolder ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public Map<String, String> handleBusinessExceptionsOne(UserAlreadyExistsException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ExpiredJwtException.class)
    public Map<String, String> handleInvalidExceptions(ExpiredJwtException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }




}
