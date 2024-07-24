package com.example.ClientBook.models.Contact;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Setter
@Getter
public class ClientResponse {
    public Long id;
    public String fullName;
    public String inn;
    public LocalDate dateOfBirth;
    public Date createdDate;

}
