package com.example.HospitalMangement.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIService {

    @Value("${mistral.api.key}")
    private String apiKey;

    private static final String MISTRAL_URL = "https://api.mistral.ai/v1/chat/completions";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public String explainPrescription(String text) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(apiKey);
            headers.setContentType(MediaType.APPLICATION_JSON);

            String body = """
            {
              "model": "mistral-small",
              "messages": [
                {"role": "user", "content": "Explain this prescription in simple language: %s"}
              ]
            }
            """.formatted(text.replace("\"", "\\\""));

            HttpEntity<String> entity = new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(
                MISTRAL_URL, entity, String.class);

            JsonNode root = mapper.readTree(response.getBody());
            return root.path("choices")
                       .get(0)
                       .path("message")
                       .path("content")
                       .asText();

        } catch (Exception e) {
            return "Error explaining prescription: " + e.getMessage();
        }
    }
}
