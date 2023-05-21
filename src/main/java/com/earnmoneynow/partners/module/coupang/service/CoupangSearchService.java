package com.earnmoneynow.partners.module.coupang.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CoupangSearchService {
    private final HmacGenerator hmacGenerator;
    @Value("${coupang.token.access-key}")
    private String accessKey;
    @Value("${coupang.token.secret-key}")
    private String secretKey;
    @Value("${coupang.url}")
    private String domain;
}
