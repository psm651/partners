package com.earnmoneynow.partners.module.tistory.service;

import com.earnmoneynow.partners.global.util.WebClientService;
import com.earnmoneynow.partners.module.tistory.dto.TistoryContentResponseDto;
import com.earnmoneynow.partners.module.tistory.dto.TistoryCreateRequestDto;
import com.earnmoneynow.partners.module.tistory.dto.TistoryCreateResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TistoryService {
    private final WebClientService webClientService;
    private final ObjectMapper objectMapper;

    @Value("${tistory.token.access-token}")
    private String accessToken;
    @Value("${tistory.url}")
    private String url;

    public TistoryContentResponseDto getContent(String blogName, Long postId) {
        String uri = String.format("/read?access_token=%s&blogName=%s&postId=%d&output=json", accessToken, blogName, postId);
        log.info(uri);

        ResponseEntity<String> responseEntity = webClientService.internalApiRequest(url, uri);
        log.info(responseEntity.toString());

        TistoryContentResponseDto tistoryContentResponseDto = null;
        try {
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                tistoryContentResponseDto = objectMapper.readValue(responseEntity.getBody(), TistoryContentResponseDto.class);
            }
            return tistoryContentResponseDto;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public TistoryCreateResponseDto createContent(TistoryCreateRequestDto tistoryCreateRequestDto) {
        String uri = "/write";
        ResponseEntity<String> responseEntity = webClientService.internalApiRequest(url, uri, tistoryCreateRequestDto);

        try {
            TistoryCreateResponseDto tistoryCreateResponseDto = objectMapper.readValue(responseEntity.getBody(), TistoryCreateResponseDto.class);
            return tistoryCreateResponseDto;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
