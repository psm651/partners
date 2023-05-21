package com.earnmoneynow.partners.module.scraping.service;

import com.earnmoneynow.partners.global.util.WebClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ScrapingService {
    private final ObjectMapper objectMapper;
    private final WebClientService webClientService;

    public String getScrap(String url) {
        webClientService.getWebClient();

        return "";
    }

}
