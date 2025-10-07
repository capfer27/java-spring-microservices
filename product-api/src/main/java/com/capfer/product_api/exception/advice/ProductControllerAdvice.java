package com.capfer.product_api.exception.advice;


import com.capfer.product_api.dto.error.ErrorDTO;
import com.capfer.product_api.exception.CategoryNotFoundException;
import com.capfer.product_api.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;

import static com.capfer.product_api.exception.constants.ExceptionMessages.CATEGORY_NOT_FOUND;
import static com.capfer.product_api.exception.constants.ExceptionMessages.PRODUCT_NOT_FOUND;

@ControllerAdvice(basePackages = "com.capfer.product_api.controller")
public class ProductControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorDTO handleProductNotFound(ProductNotFoundException productNotFoundException) {
        ErrorDTO errorDTO = new ErrorDTO (
                HttpStatus.NOT_FOUND.value(),
                PRODUCT_NOT_FOUND,
                productNotFoundException.getMessage(),
                LocalDateTime.now()
        );
        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorDTO handleCategoryNotFound(CategoryNotFoundException exception) {
        ErrorDTO errorDTO = new ErrorDTO (
                HttpStatus.NOT_FOUND.value(),
                CATEGORY_NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );
        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO processValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder builder = new StringBuilder("Invalid value for field(s):");
        for (FieldError fieldError : fieldErrors) {
            builder.append(" ");
            builder.append(fieldError.getField());
        }
        ErrorDTO errorDTO = new ErrorDTO(
                HttpStatus.BAD_REQUEST.value(),
                builder.toString(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return errorDTO;
    }
}
