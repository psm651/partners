package com.earnmoneynow.partners.module.coupang.dto;

import lombok.Data;

import java.util.List;

@Data
public class SearchedProductResponseDto {
    private String rCode;
    private String rMessage;
    private DataObject data;

    @Data
    public static class DataObject {
        private String landingUrl;
        private List<ProductData> productData;
    }

    @Data
    public static class ProductData {
        private String keyword;
        private int rank;
        private boolean isRocket;
        private boolean isFreeShipping;
        private long productId;
        private String productImage;
        private String productName;
        private int productPrice;
        private String productUrl;
    }
}
