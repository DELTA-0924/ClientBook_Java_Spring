package com.example.ClientBook.services;


import com.example.ClientBook.common.Mapper;
import com.example.ClientBook.common.enums.ResponseCode;
import com.example.ClientBook.models.Contact.ClientCreateRequest;
import com.example.ClientBook.models.Contact.IdDeleteRequest;
import com.example.ClientBook.models.Contact.ClientResponse;
import com.example.ClientBook.models.Contact.Response;
import com.example.ClientBook.models.entities.ClientEntity;
import com.example.ClientBook.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.ClientBook.common.enums.ResponseCode.SUCCES;

@Service
@AllArgsConstructor
public class ClientService {
    private ClientRepository clientRepository;
    public ResponseEntity<Response> createClient(ClientCreateRequest clientRequest){
        var client= Mapper.fromClientResponseToClientEntity(clientRequest);
        clientRepository.save(client);
        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().code(SUCCES).message(SUCCES.toString()).build());
    }
    public ResponseEntity<List<ClientResponse>> getListClient(){
        return ResponseEntity.status(HttpStatus.OK).body(
                            clientRepository.findAll().stream()
                                    .map(Mapper::fromClientEntityToContact)
                                    .collect(Collectors.toList())
        );
    }
    public ResponseEntity<Response>deleteClientById(IdDeleteRequest request){
        clientRepository.deleteById(request.id);
        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().code(SUCCES).message(SUCCES.toString()).build());
    }
    public ResponseEntity<Response>deleteClientByInn(String inn){
        clientRepository.deleteByInn(inn).orElseThrow(()->new EntityNotFoundException());

        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().code(SUCCES).message(SUCCES.toString()).build());
    }

    public ResponseEntity<Response>updateClient(ClientCreateRequest clientRequest){
        var client= Mapper.fromClientResponseToClientEntity(clientRequest);

        Optional<ClientEntity> clientOption= clientRepository.findByInn(client.inn);

        clientOption.ifPresent(entity->{
            ClientEntity clientEntity=entity;
            clientEntity.setFullName(client.fullName);
            clientEntity.setInn(client.inn);
            clientEntity.setDateOfBirth(client.dateOfBirth);
            clientRepository.save(clientEntity);
        } );
        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().code(SUCCES).message(SUCCES.toString()).build());
    }
    public ResponseEntity<ClientEntity>getClientByInn(String inn){
        var client =clientRepository.findByInn(inn);
        ClientEntity clientEtity=null;
        if(client.isPresent()){
            clientEtity=client.get();
        }else{
            throw new EntityNotFoundException();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientEtity);
    }
    public ResponseEntity<Response>DeleteAll(){
        clientRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body(Response.builder().code(SUCCES).message(SUCCES.toString()).build());
    }
}
