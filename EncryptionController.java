package com.example.demo.controller;

import com.example.demo.model.EncryptionResponse;
import com.example.demo.service.EncryptionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EncryptionController {

    private final EncryptionService encryptionService;

    public EncryptionController(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

      @GetMapping("/encrypt")
    public EncryptionResponse encrypt(@RequestParam("message")  String message) {
        String encrypted = encryptionService.encrypt(message);
        
        return new EncryptionResponse(message,encrypted ,"encryption" );
    }

    @GetMapping("/decrypt")
    public EncryptionResponse decrypt(@RequestParam("message") String message) {
        String decrypted = encryptionService.decrypt(message);
            return new EncryptionResponse(message, decrypted, "decryption");
    }
}


