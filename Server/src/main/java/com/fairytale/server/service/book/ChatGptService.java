package com.fairytale.server.service.book;

import com.fairytale.server.model.book.dto.ChatGptRequestDto;
import com.fairytale.server.model.book.dto.ChatGptResponseDto;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatGptService {
    private final String API_URL = "https://api.openai.com/v1/chat/completions";
    private final String API_KEY = "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";

    public ChatGptResponseDto getChatGptResponse(ChatGptRequestDto requestDto) {
        System.out.println(requestDto.getPrompt());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + API_KEY);
        HttpEntity<ChatGptRequestDto> entity = new HttpEntity<>(requestDto, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ChatGptResponseDto> response = restTemplate.exchange(API_URL, HttpMethod.POST, entity, ChatGptResponseDto.class);

        return response.getBody();
    }
}
