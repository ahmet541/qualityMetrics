package com.CodeSculpture.app.controllers;

import com.CodeSculpture.app.client.LlmApiClient;
import com.CodeSculpture.app.models.ChatRequestQwen;
import com.CodeSculpture.app.models.MultiMessage;
import com.CodeSculpture.app.models.TextContent;
import com.CodeSculpture.app.models.interfaces.ChatRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LlmController {
    private final LlmApiClient llmApiClient;

    public LlmController(LlmApiClient llmApiClient) {
        this.llmApiClient = llmApiClient;
    }

    @PostMapping("/ask")
    public String ask(@RequestBody String question) {
        try {
            ChatRequest request = new ChatRequestQwen(
                    List.of(new MultiMessage("user", List.of(new TextContent(question))))
            );
            return llmApiClient.ask(request);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}