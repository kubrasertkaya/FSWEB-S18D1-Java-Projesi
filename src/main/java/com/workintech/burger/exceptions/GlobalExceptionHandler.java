package com.workintech.burger.exceptions;

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
    public ResponseEntity handlerMappingException(MethodArgumentNotValidException exception){
        List errorList=exception.getBindingResult().
                getFieldErrors().stream().map(fieldError -> {
                    Map<String,String> errorMap=new HashMap<>();
                    errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
                    return errorMap;
                }).collect(Collectors.toList());
      return ResponseEntity.badRequest().body(errorList);
    }
}
