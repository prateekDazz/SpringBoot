package com.eCommerce.Ecommerce.Application.Exception;

import com.eCommerce.Ecommerce.Application.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponseDto>handlecategoryNotFoundException(CategoryNotFoundException exception, WebRequest webRequest)
    {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(LocalDateTime.now(),exception.getMessage(),webRequest.getDescription(false), "CATEGORY_NOT_FOUND");
        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }
}
