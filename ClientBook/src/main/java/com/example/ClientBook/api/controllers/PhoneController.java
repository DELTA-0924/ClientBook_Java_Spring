package com.example.ClientBook.api.controllers;

import com.example.ClientBook.models.Contact.*;
import com.example.ClientBook.services.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/phone")
@AllArgsConstructor
public class PhoneController {
    private PhoneService phoneService;
    @GetMapping("/list")
    public ResponseEntity<List<PhoneResponse>>phoneList(){
        return phoneService.listPhone();
    }
    @PostMapping("/create")
    public ResponseEntity<Response>phoneCreate(@RequestBody PhoneCreateRequest request){
        return phoneService.createPhone(request);
    }
    @PutMapping("/update")
    public ResponseEntity<Response>phoneUpdate(@RequestParam String phone,@RequestParam Long id){
        return phoneService.updatePhone(phone,id);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Response>phoneDelete(@RequestParam Long  id){
        return phoneService.deletePhone(Long.valueOf(id));
    }
    @GetMapping("/oldphone")
    public ResponseEntity<List<OldPhoneResponse>> phoneOld(){
        return phoneService.listOldPhone();
    }
}
