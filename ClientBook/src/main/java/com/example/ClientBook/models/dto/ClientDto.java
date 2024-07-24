package com.example.ClientBook.models.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@Data
public class ClientDto {
    public String fullName;
    public String inn;
    public Date dateOfBirth;
    public Date createdDate;
}
