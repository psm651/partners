package com.earnmoneynow.partners.module.coupang.service;

import com.earnmoneynow.partners.global.util.WebClientService;
import com.earnmoneynow.partners.module.coupang.dto.ProductRequestDto;
import com.earnmoneynow.partners.module.coupang.dto.ProductsResponseDto;
import com.earnmoneynow.partners.module.coupang.dto.SearchedProductResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Service
@Slf4j
public class CoupangSearchService {
    private static final String POST_METHOD = "POST";
    private static final String GET_METHOD = "GET";
    private final HmacGenerator hmacGenerator;
    private final WebClientService webClientService;
    private final ObjectMapper objectMapper;
    @Value("${coupang.token.access-key}")
    private String accessKey;
    @Value("${coupang.token.secret-key}")
    private String secretKey;
    @Value("${coupang.url}")
    private String url;

    public ProductsResponseDto getGoldBoxProducts(ProductRequestDto productRequestDto) {
        String subId = productRequestDto.getSubId();
        String imageSize = productRequestDto.getImageSize();
        String uri = String.format("/v2/providers/affiliate_open_api/apis/openapi/v1/products/goldbox?subId=%s&imageSize=%s", subId, imageSize);
        String authorization = hmacGenerator.generate(GET_METHOD, uri, secretKey, accessKey);
        ResponseEntity<String> responseEntity = webClientService.coupangApiRequest(url, uri, authorization);

        ProductsResponseDto productsResponseDto = null;
        try {
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                productsResponseDto = objectMapper.readValue(responseEntity.getBody(), ProductsResponseDto.class);
            }
            return productsResponseDto;
        } catch (JsonMappingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ProductsResponseDto getBestProducts(String categoryId, ProductRequestDto productRequestDto) {
        String subId = productRequestDto.getSubId();
        String imageSize = productRequestDto.getImageSize();
        String uri = String.format("/v2/providers/affiliate_open_api/apis/openapi/v1/products/bestcategories/%s?subId=%s&imageSize=%s", categoryId, subId, imageSize);
        String authorization = hmacGenerator.generate(GET_METHOD, uri, secretKey, accessKey);
        ResponseEntity<String> responseEntity = webClientService.coupangApiRequest(url, uri, authorization);
        log.info(responseEntity.toString());

        ProductsResponseDto productsResponseDto = null;
        try {
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                productsResponseDto = objectMapper.readValue(responseEntity.getBody(), ProductsResponseDto.class);
            }
            return productsResponseDto;
        } catch (JsonMappingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public SearchedProductResponseDto getSearchedProduct(ProductRequestDto productRequestDto) {
        String subId = productRequestDto.getSubId();
        String imageSize = productRequestDto.getImageSize();
        String keyword = URLEncoder.encode(productRequestDto.getKeyword(), StandardCharsets.UTF_8);
        String uri = String.format("/v2/providers/affiliate_open_api/apis/openapi/v1/products/search?keyword=%s&subId=%s&imageSize=%s", keyword, subId, imageSize);
        String authorization = hmacGenerator.generate(GET_METHOD, uri, secretKey, accessKey);
        ResponseEntity<String> responseEntity = webClientService.coupangApiRequest(url, uri, authorization);
        log.info(responseEntity.toString());

        SearchedProductResponseDto searchedProductResponseDto = null;
        try {
            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                searchedProductResponseDto = objectMapper.readValue(responseEntity.getBody(), SearchedProductResponseDto.class);
            }
            return searchedProductResponseDto;
        } catch (JsonMappingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
