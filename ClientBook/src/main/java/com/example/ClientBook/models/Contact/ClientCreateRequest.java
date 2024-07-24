package com.example.ClientBook.models.Contact;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Builder
@Getter
@Setter
public class ClientCreateRequest {
    public String fullName;
    public String inn;
    public Date dateOfBirth;
}
