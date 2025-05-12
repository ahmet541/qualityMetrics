package com.CodeSculpture.app.client;

import com.CodeSculpture.app.config.OpenRouterConfig;
import com.CodeSculpture.app.models.interfaces.ChatRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component
public class LlmApiClient implements LlmApiClientInterface{
    private final String apiUrl;
    private final String apiKey;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public LlmApiClient(OpenRouterConfig config) {
        this.apiKey = config.getApiKey();
        this.apiUrl = config.getApiUrl();
        System.out.println(apiKey);
        System.out.println(apiUrl);
    }

    @Override
    public String ask(ChatRequest chatRequest) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {

            // move this to another method TODO
            HttpPost httpPost = new HttpPost(apiUrl);
            httpPost.setHeader("Authorization", "Bearer " + apiKey);
            httpPost.setHeader("Content-Type", "application/json");

            // Serialize request
            String json = objectMapper.writeValueAsString(chatRequest);
//            String json = "{ \"model\": \"qwen/qwen2.5-vl-72b-instruct:free\", \"messages\": [{\"role\": \"user\", \"content\": \"" + chatRequest.getMessages() + "\"}] }";
            System.out.println(json);
            httpPost.setEntity(new StringEntity(json));
            System.out.println(httpPost.getEntity());
            try (CloseableHttpResponse response = client.execute(httpPost)) {
                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println("HTTP Status Code: " + statusCode);
                String responseBody = EntityUtils.toString(response.getEntity());

                if (responseBody.contains("error")) {
                    System.out.println("Error Response: " + responseBody);
                    throw new RuntimeException("API request failed with status: " + statusCode + ", body: " + responseBody);
                }

                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(responseBody);
                // TODO this is for text-only requests, it supports multimodal request with images, etc. But requires additional parsing
                return jsonNode.path("choices").get(0).path("message").path("content").asText();
            }
        }
    }
}