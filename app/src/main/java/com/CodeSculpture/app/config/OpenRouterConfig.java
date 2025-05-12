package com.CodeSculpture.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "open-router")
@Data
public class OpenRouterConfig {
    private String apiKey;
    private String apiUrl;
}
