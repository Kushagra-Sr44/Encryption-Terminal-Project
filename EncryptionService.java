package com.example.demo.service;

import org.springframework.stereotype.Service;
@Service
public class EncryptionService {

    private static final int SHIFT = 5;

    public String encrypt(String text) {
    

        return process(text,shift) ;
    }

    public String decrypt(String text) {
        return process(text,26-shift);
    }

    private String process(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            
            if (Character.isLetter(character)) {
                
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                
      
                char transformed = (char) ((int )base+((int)character-base+shift)%(26));
                
                result.append(transformed);
            } else {
                
                result.append(character); 
            }
        }
        
        return result.toString();
    }
}


