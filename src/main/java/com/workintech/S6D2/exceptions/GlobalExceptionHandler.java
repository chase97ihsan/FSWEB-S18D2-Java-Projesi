package com.workintech.S6D2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    ResponseEntity handleBindErrors(MethodArgumentNotValidException exception) {
        List errorList = exception.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> {
                    Map<String, String> errorMap = new HashMap<>();
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errorMap;
                }).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errorList);
    }
    @ExceptionHandler
    public ResponseEntity<FruitResponse> globalHandler(Exception exception) {
        FruitResponse fruitResponse = new FruitResponse
                (HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity(fruitResponse, HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<FruitResponse> globalHandler(FruitException fruitException) {
        FruitResponse fruitResponse = new FruitResponse
                (fruitException.getHttpStatus().value(), fruitException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity(fruitResponse, HttpStatus.BAD_REQUEST);

    }
}
