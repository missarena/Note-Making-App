package com.example.security_test.controllers;

import com.example.security_test.Entity.Note;
import com.example.security_test.service.AIService;
import com.example.security_test.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ai")
public class AIController {

    private final AIService aiService;

    private final NoteService noteService;

    public AIController(AIService aiService, NoteService noteService) {
        this.aiService = aiService;
        this.noteService = noteService;
    }

    @GetMapping("/summarize/{noteId}")
    public String summarize(@PathVariable Long noteId, Model model) {

        Note note = noteService.getNoteById(noteId);

        if (note == null) {
            return "error";
        }

        String summary = aiService.summarize(note.getContent());

        model.addAttribute("note", note);
        model.addAttribute("summary", summary);
        return "summary";
    }

}