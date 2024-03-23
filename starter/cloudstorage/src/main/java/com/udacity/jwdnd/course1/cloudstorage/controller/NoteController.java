package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class NoteController {
    private UserService userService;

    public NoteController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    private NoteService noteService;

    @PostMapping("/notes")
    public String createAndUpdateNote(Model model, Note note, Authentication authentication)
    {
        User user=userService.getUser(authentication.getName());
        Integer userId=user.getUserId();

        if(note.getNoteId()==null)
        {
            note.setUserId(userId);
            noteService.createNote(note);
        }
        else
        {
            noteService.updateNote(note);
        }
        model.addAttribute("success",true);
        return "result";
    }
    @GetMapping("/notes/delete/{noteId}")
    public String delete(@PathVariable("noteId") Integer noteId)
    {
        noteService.deleteNote(noteId);
        return "result";
    }


}
