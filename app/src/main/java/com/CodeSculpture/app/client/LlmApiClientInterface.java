package com.CodeSculpture.app.client;

import com.CodeSculpture.app.models.interfaces.ChatRequest;

public interface LlmApiClientInterface {
    String ask(ChatRequest chatRequest) throws Exception;
}
