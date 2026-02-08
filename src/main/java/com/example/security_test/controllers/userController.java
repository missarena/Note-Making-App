package com.example.security_test.controllers;

import com.example.security_test.Entity.Note;
import com.example.security_test.Entity.User;
import com.example.security_test.service.NoteService;
import com.example.security_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class userController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private NoteService noteService;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/user_register")
    public String userRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam  String username,@RequestParam  String password ,@RequestParam  String confirmPassword,
        Model model){
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }

        if (userService.existsByUsername(username)) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        userService.saveUser(user);

        return "redirect:/login";

    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        String username = principal.getName(); // logged-in user
        User user = userService.findByUsername(username);

        List<Note> notes = noteService.findByUser(user);
        model.addAttribute("notes", notes);
        model.addAttribute("username", username);

        return "MyNotes"; // thymeleaf template
    }




}
