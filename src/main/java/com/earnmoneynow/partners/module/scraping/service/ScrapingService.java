package com.earnmoneynow.partners.module.scraping.service;

import com.earnmoneynow.partners.global.util.WebClientService;
import com.earnmoneynow.partners.module.scraping.dto.TestResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ScrapingService {
    private final ObjectMapper objectMapper;
    private final WebClientService webClientService;

    public Optional<TestResponseDto> getScrap(String url) {
//        String uri = String.format("/business/%s", businessId);
        String uri = "";
        ResponseEntity<String> responseEntity = webClientService.internalApiRequest(url, uri);
        TestResponseDto testResponseDto;
        try {
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                testResponseDto = objectMapper.readValue(responseEntity.getBody(), TestResponseDto.class);
                return Optional.ofNullable(testResponseDto);
            } else {
                return Optional.empty();
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
