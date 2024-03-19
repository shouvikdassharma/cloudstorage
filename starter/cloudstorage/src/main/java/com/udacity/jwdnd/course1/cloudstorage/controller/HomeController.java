package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private UserService userService;
    private EncryptionService encryptionService;
    private CredentialService credentialService;

    public HomeController(UserService userService, EncryptionService encryptionService, CredentialService credentialService, FileService fileService, NoteService noteService) {
        this.userService = userService;
        this.encryptionService = encryptionService;
        this.credentialService = credentialService;
        this.fileService = fileService;
        this.noteService = noteService;
    }

    private FileService fileService;
    private NoteService noteService;



    @GetMapping
    public String getHomePage(Authentication authentication,Model model,EncryptionService encryptionService,CredentialService credentialService,FileService fileService,NoteService noteService) {
       User user = userService.getUser(authentication.getName());
       Integer userId=user.getUserId();

       List<Note> noteList=this.noteService.getNotes(userId);
       model.addAttribute("notes",noteList);

       List<File> fileList=this.fileService.getFiles(userId);
       model.addAttribute("files",fileList);
       List<Credential> credentialList=this.credentialService.getCredentials(userId);
       model.addAttribute("credentials",credentialList);
       model.addAttribute("encryptionService",encryptionService);


        return "home";
    }
}

