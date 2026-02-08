package com.example.security_test.service;

import com.example.security_test.Entity.Note;
import com.example.security_test.Entity.User;
import com.example.security_test.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    public List<Note> findByUser(User user) {
        return noteRepository.findByUser(user);
    }

    public void save(Note note) {
        noteRepository.save(note);
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }


}
