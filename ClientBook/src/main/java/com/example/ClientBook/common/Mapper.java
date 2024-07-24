package com.example.ClientBook.common;

import com.example.ClientBook.common.enums.TypeNumber;
import com.example.ClientBook.models.Contact.*;
import com.example.ClientBook.models.entities.ClientEntity;
import com.example.ClientBook.models.entities.OldPhoneEntity;
import com.example.ClientBook.models.entities.PhoneEntity;

import java.time.ZoneId;

public class Mapper {
    static  public ClientEntity fromClientResponseToClientEntity(ClientCreateRequest clientRequest){
        var clientEntity = ClientEntity.builder()
                .fullName(clientRequest.fullName)
                .dateOfBirth(clientRequest.dateOfBirth)
                .inn(clientRequest.inn)
                .build();
        return clientEntity;
    }
    static public ClientResponse fromClientEntityToContact(ClientEntity clientEntity){
        var clientResponse = ClientResponse.builder()
                .id(clientEntity.id)
                .fullName(clientEntity.fullName)
                .dateOfBirth(clientEntity.dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .inn(clientEntity.inn)
                .createdDate(clientEntity.createdDate)
                .build();
        return clientResponse;
    }
    static public PhoneEntity fromPhoneRequestToPhoneEntity(PhoneCreateRequest phoneCreateRequest){
        var phoneEntity = PhoneEntity.builder()
                .number(phoneCreateRequest.number)
                .type(TypeNumber.valueOf(phoneCreateRequest.typeNumber))
                .build();
        return phoneEntity;
    }
    static public PhoneResponse fromPhoneEntityToPhoneResponse(PhoneEntity phoneEntity){
        var phoneResponse = PhoneResponse.builder()
                .id(phoneEntity.id)
                .number(phoneEntity.number)
                .typeNumber(phoneEntity.getType().toString())
                .fullName(phoneEntity.client.fullName)
                .build();
        return phoneResponse;
    }
    static public OldPhoneResponse fromOldPhoneEnityToOldPhoneResponse(OldPhoneEntity oldPhoneEntity){
        var oldphones= OldPhoneResponse.builder()

                .number(oldPhoneEntity.number)
                .typeNumber(oldPhoneEntity.typeNumber)
                .operation(oldPhoneEntity.operation)
                .fullname(oldPhoneEntity.client.fullName)
                .build();
        return oldphones;
    }
}
