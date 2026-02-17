package com.example.security_test.repository;

import com.example.security_test.Entity.AiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface AiResponseRepository extends JpaRepository<AiResponse, Long> {
    List<AiResponse> findByNoteIdAndType(Long noteId, String type);

    List<AiResponse> findByNoteIdAndTypeOrderByCreatedAtDesc(Long noteId, String summary);
}
