package com.example.ClientBook.api.controllers;

import com.example.ClientBook.common.enums.ResponseCode;
import com.example.ClientBook.models.Contact.Response;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> HandleGlobalExeption(Exception ex) {
        var response = Response.builder().code(ResponseCode.INTERNAL_SERVER_ERROR).message(ResponseCode.INTERNAL_SERVER_ERROR.toString()).build();
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Response> HandleNullPointerException(Exception ex) {
        var response = Response.builder().code(ResponseCode.NULL_FIELD).message(ResponseCode.NULL_FIELD.toString()).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Response> HandleConstraintException(Exception ex) {
        var response = Response.builder().code(ResponseCode.CONFLICT).message(ResponseCode.CONFLICT.toString()).build();
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Response>HandleEntityNotFoundException(Exception ex) {
        var response = Response.builder().code(ResponseCode.OBJECT_NOT_FOUND).message(ResponseCode.OBJECT_NOT_FOUND.toString()).build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
