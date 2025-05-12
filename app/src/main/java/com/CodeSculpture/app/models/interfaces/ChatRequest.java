package com.CodeSculpture.app.models.interfaces;

import java.util.List;

public interface ChatRequest {
    String getModel();
    List<Message> getMessages();
}