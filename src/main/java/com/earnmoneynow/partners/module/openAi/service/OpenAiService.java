package com.earnmoneynow.partners.module.openAi.service;

import com.earnmoneynow.partners.global.util.WebClientService;
import com.earnmoneynow.partners.module.openAi.dto.OpenAiRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OpenAiService {
    private final WebClientService webClientService;
    private final ObjectMapper objectMapper;
    @Value("${open-ai.token.api-key}")
    private String apiKey;
    @Value("${open-ai.url}")
    private String url;

    public String getGPTData(List<String> messages) {
        List<OpenAiRequestDto.Messages> messageDtoList = messages.stream().map(message -> OpenAiRequestDto.Messages.builder()
                .role("user")
                .content(message)
                .build()).collect(Collectors.toList());
        OpenAiRequestDto openAiRequestDto = OpenAiRequestDto.builder()
                .messages(messageDtoList)
                .model("gpt-3.5-turbo")
                .build();
        ResponseEntity<String> responseEntity = webClientService.openAiRequest(url, apiKey, openAiRequestDto);
        return responseEntity.getBody().toString();
    }
}
