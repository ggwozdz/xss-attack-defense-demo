package com.neoteric.xss;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ggwozdz on 20.09.15.
 */
@ControllerAdvice
public class ExceptionMapper {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public String handleNotFound(HttpServletRequest req, NotFoundException ex) {
        return ex.getMessage();
    }
}
