package com.example.ClientBook.services;

import com.example.ClientBook.common.Mapper;
import com.example.ClientBook.common.enums.ResponseCode;
import com.example.ClientBook.models.Contact.*;
import com.example.ClientBook.models.entities.ClientEntity;
import com.example.ClientBook.models.entities.OldPhoneEntity;
import com.example.ClientBook.models.entities.PhoneEntity;
import com.example.ClientBook.repositories.ClientRepository;
import com.example.ClientBook.repositories.OldPhoneRepository;
import com.example.ClientBook.repositories.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.ClientBook.common.enums.ResponseCode.SUCCES;

@Service
@AllArgsConstructor
public class PhoneService {
    private PhoneRepository phoneRepository;
    private OldPhoneRepository oldPhoneRepository;
    private ClientService clientService;
    public ResponseEntity<List<PhoneResponse>>listPhone(){
        return ResponseEntity.ok().body(
                phoneRepository.findAll().stream()
                        .map(Mapper::fromPhoneEntityToPhoneResponse)
                        .collect(Collectors.toList()));
    }
    @Transactional
    public ResponseEntity<Response>createPhone(PhoneCreateRequest phoneRequest){
        if(phoneRequest.clientInn==null)
            System.out.println("inn is null");
        ResponseEntity< ClientEntity >clientResponse=clientService.getClientByInn(phoneRequest.clientInn);
        var clientEntity=clientResponse.getBody();
        var phoneEntity=Mapper.fromPhoneRequestToPhoneEntity(phoneRequest);
        phoneEntity.setClient(clientEntity);

        phoneRepository.save(phoneEntity);
        return ResponseEntity.ok().body(Response.builder().code(SUCCES).message(SUCCES.toString()).build());
    }
    public ResponseEntity<Response>deletePhone(Long id){
        phoneRepository.deleteById(id);
        return ResponseEntity.ok().body(Response.builder().code(SUCCES).message(SUCCES.toString()).build());
    }
    @Transactional
    public ResponseEntity<Response>updatePhone(String phone,Long id){

        Optional<PhoneEntity> phoneOptional=phoneRepository.findById(id);
        phoneOptional.ifPresent(p->{
            var phoneEntity=p;
            phoneEntity.setNumber(phone);
            oldPhoneRepository.flush();
        });
        return ResponseEntity.ok().body(Response.builder().code(SUCCES).message(SUCCES.toString()).build());
    }
    public ResponseEntity<List<OldPhoneResponse>>listOldPhone(){
        return ResponseEntity.ok().body(
                oldPhoneRepository.findAll().stream()
                        .map(Mapper::fromOldPhoneEnityToOldPhoneResponse)
                        .collect(Collectors.toList())
        );
    }
    @Transactional
    public ResponseEntity<Response>DeleteAll(){
        phoneRepository.deleteAll();
        return ResponseEntity.ok().body(Response.builder().code(SUCCES).message(SUCCES.toString()).build());
    }

}
