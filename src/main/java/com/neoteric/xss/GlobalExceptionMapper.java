package com.neoteric.xss;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
class GlobalExceptionMApper {
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 409
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public String handleNotFound(HttpServletRequest req, NotFoundException ex) {
        return ex.getMessage();
    }
}