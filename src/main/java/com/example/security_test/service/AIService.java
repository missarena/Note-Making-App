package com.example.security_test.service;

import com.example.security_test.Entity.AiResponse;
import com.example.security_test.repository.AiResponseRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AIService {

    private ChatClient chatClient;
    @Autowired
    private AiResponseRepository aiResponseRepository;

    public AIService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    public String summarize(String noteContent,Long noteId){
        String summary=chatClient.prompt().user("Summarize in 5 bullet points:\n"+noteContent).call().content();
        AiResponse aiResponse=new AiResponse();
        aiResponse.setNoteId(noteId);
        aiResponse.setType("SUMMARY");
        aiResponse.setResponse(summary);
        aiResponse.setCreatedAt(LocalDateTime.now());

        aiResponseRepository.save(aiResponse);
        return summary;

    }

    public String getLatestSummary(Long noteId){
        List<AiResponse> list=aiResponseRepository.findByNoteIdAndTypeOrderByCreatedAtDesc(noteId,"SUMMARY");
        if(list.size()==0){
            return "No summary found for this note";
        }
        return list.get(0).getResponse();

    }

}
