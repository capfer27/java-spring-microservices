package com.capfer.user_api.exception.advice;

import com.capfer.user_api.dto.error.ErrorDTO;
import com.capfer.user_api.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice(basePackages = "com.capfer.user_api.controller")
public class UserControllerAdvice {

    private static final String USER_NOT_FOUND = "User not found";

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFound(UserNotFoundException exception) {
         ErrorDTO errorDTO = new ErrorDTO(
                 HttpStatus.NOT_FOUND.value(),
                 USER_NOT_FOUND,
                 exception.getMessage(),
                 LocalDateTime.now()
         );
         return errorDTO;
    }
}
