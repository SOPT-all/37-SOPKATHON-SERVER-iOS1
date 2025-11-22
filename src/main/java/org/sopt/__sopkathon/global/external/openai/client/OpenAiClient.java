package org.sopt.__sopkathon.global.external.openai.client;

import org.sopt.__sopkathon.global.external.openai.dto.request.ChatRequestMessage;
import org.sopt.__sopkathon.global.external.openai.dto.request.OpenAiRequest;
import org.sopt.__sopkathon.global.external.openai.dto.response.OpenAiResponse;
import org.sopt.__sopkathon.global.properties.OpenAiProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;

@Component
public class OpenAiClient {

    public static final String REQUEST_URI = "/chat/completions";

    private final RestClient restClient;
    private final OpenAiProperties properties;

    public OpenAiClient(OpenAiProperties properties) {
        this.properties = properties;
        this.restClient = RestClient.builder()
                .baseUrl(properties.baseUrl())
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + properties.secretKey())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public String sendRequest(List<ChatRequestMessage> messages) {
        OpenAiRequest request = new OpenAiRequest(
                properties.model(),
                messages,
                properties.maxTokens(),
                properties.temperature()
        );

        OpenAiResponse response = restClient.post()
                .uri(REQUEST_URI)
                .body(request)
                .retrieve()
                .body(OpenAiResponse.class);

        return parseContent(Objects.requireNonNull(response));
    }

    private String parseContent(OpenAiResponse response) {
        return response.choices().get(0).message().content().trim();
    }
}
