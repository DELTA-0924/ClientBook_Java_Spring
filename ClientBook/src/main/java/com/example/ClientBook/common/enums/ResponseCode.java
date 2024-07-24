package com.example.ClientBook.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ResponseCode {
    SUCCES(1,"Succes"),
    PAGE_NOT_FOUND(2,"Pаge not found"),
    OBJECT_NOT_FOUND(3,"Object not found or doesn't exist"),
    INTERNAL_SERVER_ERROR(4,"Internal Server Error"),
    ALREADY_EXIST(5,"Already Exist"),
    NULL_FIELD(6,"Null Field"),
    CONFLICT(7," Нарушение ограничений поля ");
    private final int code;
    private final String message;

    @Override
    public String toString() {
        return message;
    }
}
