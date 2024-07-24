package com.example.ClientBook.models.Contact;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public class OldPhoneResponse
{
    public String number;
    public String typeNumber;
    public String operation;
    public String fullname;
}
