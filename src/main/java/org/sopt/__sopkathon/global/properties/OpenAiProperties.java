package org.sopt.__sopkathon.global.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "openai")
public record OpenAiProperties(
        String secretKey,
        String baseUrl,
        String model,
        int maxTokens,
        double temperature
) {
}
