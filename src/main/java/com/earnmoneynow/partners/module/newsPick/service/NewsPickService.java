package com.earnmoneynow.partners.module.newsPick.service;

import com.earnmoneynow.partners.global.util.WebClientService;
import com.earnmoneynow.partners.module.newsPick.dto.RequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NewsPickService {

//    private final WebClientService webClientService;
//    private final ObjectMapper objectMapper;
//
//    public BatchResponse requestBatching(BatchRequestDto batchRequestDto) {
//        List<RequestDto> requests = batchRequestDto.getRequests();
//        List<BatchResponseBody> responses = new ArrayList<>();
//
//        for (RequestDto request : requests) {
//            request.validDto(request);
//            BatchResponseBody response = request(request);
//            responses.add(response);
//        }
//
//        return new BatchResponse(responses);
//    }
//
//    private BatchResponseBody request(RequestDto requestDto) {
//        BatchResponseBody responseBody = new BatchResponseBody(requestDto.getId(), new HashMap<>());
//        ResponseEntity<String> response = webClientService.request(requestDto);
//
//        try {
//            int statusCode = response.getStatusCodeValue();
//
//            switch (statusCode) {
//                case 200:
//                case 204:
//                    break;
//                default:
//                    responseBody.setSuccessful(false);
//                    break;
//            }
//
//            if (response.getBody() != null) {
//                Object body = objectMapper.readValue(response.getBody(), Object.class);
//                responseBody.setBody(body);
//            }
//        } catch (Exception e) {
//            log.error("failed to read webclient response body : {}", e.getMessage());
//            responseBody.setSuccessful(false);
//        }
//
//        return responseBody;
//    }
}
