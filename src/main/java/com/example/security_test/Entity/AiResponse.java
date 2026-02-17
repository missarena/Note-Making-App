package com.example.security_test.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class AiResponse {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long noteId;
    private String type; //summary,quiz flashcard
    @Column(columnDefinition="TEXT")
    private String response;

    private LocalDateTime createdAt;

}
