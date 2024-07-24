package com.example.ClientBook.api.controllers;

import com.example.ClientBook.models.Contact.ClientCreateRequest;
import com.example.ClientBook.models.Contact.IdDeleteRequest;
import com.example.ClientBook.models.Contact.ClientResponse;
import com.example.ClientBook.models.Contact.Response;
import com.example.ClientBook.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;
    @PostMapping("/create")
    ResponseEntity<Response> clientCreate(@RequestBody ClientCreateRequest request){
        return clientService.createClient(request);
    }
    @PostMapping("/update")
    ResponseEntity<Response>clientUpdate(@RequestBody ClientCreateRequest request){
        return clientService.updateClient(request);
    }
    @GetMapping("/list")
    ResponseEntity<List<ClientResponse>> clientList(){
        return clientService.getListClient();
    }
    @PostMapping("/delete")
    ResponseEntity<Response>deleteClient(@RequestBody String request){
        return clientService.deleteClientByInn(request);
    }
}
