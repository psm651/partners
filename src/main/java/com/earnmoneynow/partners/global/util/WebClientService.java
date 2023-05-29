package com.earnmoneynow.partners.global.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;


@Slf4j
@Component
@RequiredArgsConstructor
public class WebClientService {

    private final WebClient webClient;

    public ResponseEntity<String> internalApiRequest(String baseUrl, String uri) {
        return webClient.mutate()
                .baseUrl(baseUrl)
                .build()
                .get()
                .uri(uri)
                .headers(headers -> {
                    headers.add("Content-type", "application/json");
                })
                .retrieve()
                .toEntity(String.class)
                .onErrorResume(WebClientResponseException.class, error -> {
                    if (error.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found"));
                    } else {
                        return Mono.error(error);
                    }
                })
                .block();

    }

    public ResponseEntity<String> coupangApiRequest(String baseUrl, String uri, String header) {
        return webClient.mutate()
                .baseUrl(baseUrl)
                .build()
                .get()
                .uri(uri)
                .header("Authorization", header.toString())
//                .headers(headers -> {
//                    headers.add("Content-type", "application/json");
//                })
                .retrieve()
                .toEntity(String.class)
                .onErrorResume(WebClientResponseException.class, error -> {
                    if (error.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found"));
                    } else {
                        return Mono.error(error);
                    }
                })
                .block();

    }

    public ResponseEntity<String> internalApiRequest(String baseUrl, String uri, Object requestBody) {
        return webClient.mutate()
                .baseUrl(baseUrl)
                .build()
                .post()
                .uri(uri)
//                .header("Authorization-Type", "Server")
                .headers(headers -> {
                    headers.add("Content-type", "application/json");
                })
                .bodyValue(requestBody)
                .retrieve()
                .toEntity(String.class)
                .onErrorResume(WebClientResponseException.class, error -> {
                    if (error.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found"));
                    } else {
                        return Mono.error(error);
                    }
                })
                .block();

    }

    public ResponseEntity<String> openAiRequest(String baseUrl, String apiKey, Object requestBody) {
        return webClient.mutate()
                .baseUrl(baseUrl)
                .build()
                .post()
                .header("Authorization", apiKey)
                .headers(headers -> {
                    headers.add("Content-type", "application/json");
                })
                .bodyValue(requestBody)
                .retrieve()
                .toEntity(String.class)
                .onErrorResume(WebClientResponseException.class, error -> {
                    if (error.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found"));
                    } else {
                        return Mono.error(error);
                    }
                })
                .block();

    }

    public ResponseEntity<String> coupangApiRequest(String baseUrl, String uri, String header, Object requestBody) {
        return webClient.mutate()
                .baseUrl(baseUrl)
                .build()
                .post()
                .uri(uri)
                .header("Authorization", header)
                .headers(headers -> {
                    headers.add("Content-type", "application/json");
                })
                .bodyValue(requestBody)
                .retrieve()
                .toEntity(String.class)
                .onErrorResume(WebClientResponseException.class, error -> {
                    if (error.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found"));
                    } else {
                        return Mono.error(error);
                    }
                })
                .block();

    }

    public ResponseEntity<String> internalApiPatchRequest(String baseUrl, String uri, Object requestBody) {
        return webClient.mutate()
                .baseUrl(baseUrl)
                .build()
                .patch()
                .uri(uri)
//                .header("Authorization-Type", "Server")
                .headers(headers -> {
                    headers.add("Content-type", "application/json");
                })
                .bodyValue(requestBody)
                .retrieve()
                .toEntity(String.class)
                .block();

    }

}