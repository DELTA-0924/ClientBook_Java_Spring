package com.example.ClientBook.models.Contact;

import lombok.Builder;

@Builder
public class PhoneResponse {
    public Long id;
    public String number;
    public String typeNumber;
    public String fullName;
}
