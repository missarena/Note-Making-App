package com.example.security_test.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private ChatClient chatClient;

    public AIService(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    public String summarize(String message){
        return chatClient.prompt().user("Summarize in 5 bullet points:\n"+message)
                .call().content();
    }

}
