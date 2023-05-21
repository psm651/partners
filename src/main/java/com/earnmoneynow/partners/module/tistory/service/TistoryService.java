package com.earnmoneynow.partners.module.tistory.service;

import com.earnmoneynow.partners.global.util.WebClientService;
import com.earnmoneynow.partners.module.tistory.dto.TistoryContentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TistoryService {
    @Value("${tistory.token.access-token}")
    private String accessToken;
    private final WebClientService webClientService;

    public TistoryContentResponseDto getContent(int postId, String blogName) {


        return null;
    }
}
