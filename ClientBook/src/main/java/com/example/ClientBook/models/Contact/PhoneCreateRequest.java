package com.example.ClientBook.models.Contact;

import lombok.Builder;

@Builder
public class PhoneCreateRequest {
    public String number;
    public String typeNumber;
    public String clientInn;

}
