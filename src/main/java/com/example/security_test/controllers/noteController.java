package com.example.security_test.controllers;

import com.example.security_test.Entity.Note;
import com.example.security_test.Entity.User;
import com.example.security_test.service.NoteService;
import com.example.security_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class noteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private UserService userService;

    //save note to db
    @PostMapping("/notes")
    public String saveNote(@ModelAttribute Note note, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        note.setUser(user);
        noteService.save(note);
        return "redirect:/dashboard";
    }

    //get all notes of user
    @GetMapping("/MyNotes")
    public String MyNotes(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<Note> notes = noteService.findByUser(user);
        model.addAttribute("notes", notes);
        model.addAttribute("username", user.getUsername());
        return "dashboard";
    }

    //add new note form
    @GetMapping("/notes/new")
    public String newNote(Model model) {
        model.addAttribute("note", new Note());
        return "note_form";
    }

    //Show edit form
    @GetMapping("/notes/edit/{id}")
    public String editNote(@PathVariable("id") Long id, Model model, Principal principal) {
        Note note = noteService.findById(id);
        model.addAttribute("note", note);
        return "note_form";
    }

    //Update note
    @PostMapping("/notes/update/{id}")
    public String updateNote(@PathVariable Long id, @ModelAttribute Note note, Principal principal) {
        Note existingNote = noteService.findById(id);
        //User user=userService.findByUsername(principal.getName());
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        noteService.save(existingNote);
        return "redirect:/dashboard";
    }

    //DELETE NOTE
    @GetMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable("id") Long id, Principal principal) {
        Note note = noteService.findById(id);
        noteService.delete(id);
        return "redirect:/dashboard";
    }
}
