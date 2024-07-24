package com.example.ClientBook.models.Contact;

import com.example.ClientBook.common.enums.ResponseCode;
import lombok.Builder;

@Builder
public class Response {
    public ResponseCode code;
    public String  message;
}
