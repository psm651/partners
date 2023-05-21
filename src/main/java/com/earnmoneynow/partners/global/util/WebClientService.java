package com.earnmoneynow.partners.global.util;

import com.earnmoneynow.partners.global.error.ErrorCode;
import com.earnmoneynow.partners.global.error.exception.CustomException;
import com.earnmoneynow.partners.module.newsPick.dto.RequestDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Locale;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebClientService {

    private final WebClient webClient;
    @Value("${server.port:8080}")
    private int serverPort;

    public WebClient getWebClient() {
        String authorizationHeader = getAuthorizationHeader();
        String baseUrl = "http://127.0.0.1:" + serverPort;

        return webClient.mutate()
                .defaultHeader("Authorization", authorizationHeader)
                .baseUrl(baseUrl)
                .build();
    }

    private String getAuthorizationHeader() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request.getHeader("Authorization");
    }

    public ResponseEntity<String> request(RequestDto requestDto) {
        WebClient client = getWebClient();
        String uri = requestDto.getUrl();
        String method = requestDto.getMethod().toUpperCase(Locale.ROOT);

        try {
            if (method.equals("GET") || method.equals("DELETE")) {
                return request(client, uri, method);
            } else {
                Object body = requestDto.getBody();
                return requestWithBody(client, uri, method, body);
            }
        } catch (Exception e) {
            log.error("webClient Error : {}", e.getMessage());
            throw new CustomException(ErrorCode.WEBCLIENT_REQUEST_FAIL);
        }
    }

    private ResponseEntity<String> request(WebClient client, String uri, String method) {
        return client.method(HttpMethod.valueOf(method))
                .uri(uri)
                .retrieve()
                .onStatus(
                        status -> status.value() != 200,
                        r -> Mono.empty()
                )
                .toEntity(String.class)
                .block();
    }

    private ResponseEntity<String> requestWithBody(WebClient client, String uri, String method, Object body) {
        return client.method(HttpMethod.valueOf(method))
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(body)
                .retrieve()
                .onStatus(
                        status -> status.value() != 200,
                        r -> Mono.empty()
                )
                .toEntity(String.class)
                .block();
    }

    public Object request(String baseUrl, String uri, Object object) {
        return webClient.mutate()
                .baseUrl(baseUrl)
                .build()
                .get()
                .uri(uri)
                .header("Authorization-Type", "Server")
                .retrieve()
                .bodyToMono(object.getClass())
                .flux()
                .toStream()
                .findFirst()
                .orElseThrow();

    }
}
