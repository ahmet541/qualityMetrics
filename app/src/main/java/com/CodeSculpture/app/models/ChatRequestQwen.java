package com.CodeSculpture.app.models;

import com.CodeSculpture.app.models.interfaces.ChatRequest;
import com.CodeSculpture.app.models.interfaces.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ChatRequestQwen implements ChatRequest {
    private String model;
    private List<Message> messages;

    public ChatRequestQwen(List<Message> messages) {
        this.model = "qwen/qwen2.5-vl-72b-instruct:free";
        this.messages = messages;
    }
}