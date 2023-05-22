package com.earnmoneynow.partners.module.tistory.service;

import com.earnmoneynow.partners.global.util.WebClientService;
import com.earnmoneynow.partners.module.scraping.dto.TestResponseDto;
import com.earnmoneynow.partners.module.tistory.dto.TistoryContentResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TistoryService {
    @Value("${tistory.token.access-token}")
    private String accessToken;
    private final WebClientService webClientService;
    private final ObjectMapper objectMapper;
    @Value("${tistory.url}")
    private String url;

    public Optional<TistoryContentResponseDto> getContent(int postId, String blogName) {
        String uri = "";
        ResponseEntity<String> responseEntity = webClientService.internalApiRequest(url, uri);
        TistoryContentResponseDto tistoryContentResponseDto;
        try {
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                tistoryContentResponseDto = objectMapper.readValue(responseEntity.getBody(), TistoryContentResponseDto.class);
                return Optional.ofNullable(tistoryContentResponseDto);
            } else {
                return Optional.empty();
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
