package com.alvi.RestCrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class EmployeeExceptionhandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handlerException(EmployeeNotFoundException exc){


        EmployeeErrorResponse error=new EmployeeErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStemp(System.currentTimeMillis());
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse>handlerException(Exception exc){


        EmployeeErrorResponse error=new EmployeeErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStemp(System.currentTimeMillis());
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
}
