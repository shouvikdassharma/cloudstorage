package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.SecureRandom;
import java.util.Base64;

@Controller
@RequestMapping("/credentials")
public class CredentialController {
    private CredentialService credentialService;
    private UserService userService;

    public CredentialController(CredentialService credentialService, UserService userService, EncryptionService encryptionService) {
        this.credentialService = credentialService;
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    private EncryptionService encryptionService;

    @PostMapping("/save")
    public  String saveCredentials(Credential credential, Model model, Authentication authentication)
    {
        User user=userService.getUser(authentication.getName());
        Integer userId=user.getUserId();

        SecureRandom random =new SecureRandom();
        byte[] key= new byte[16];
        random.nextBytes(key);
        String encondedKey= Base64.getEncoder().encodeToString(key);
        String encryptedPassword=encryptionService.encryptValue(credential.getPassword(),encondedKey);
        credential.setKey(encondedKey);
        credential.setPassword(encryptedPassword);

        if(credential.getCredentialId()==null)
        {
            credential.setUserId(userId);
            credentialService.insert(credential);
        }
        else {
            credentialService.update(credential);

        }
        model.addAttribute("success",true);


        return "result";


    }
    @GetMapping("/delete/{credentialId}")
    public String delete(Integer credentialId)
    {
        credentialService.delete(credentialId);
        return "result";
    }

}
