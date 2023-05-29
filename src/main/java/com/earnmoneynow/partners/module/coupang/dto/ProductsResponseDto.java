package com.earnmoneynow.partners.module.coupang.dto;


import lombok.Data;

import java.util.List;

@Data
public class ProductsResponseDto {
    private String rCode;
    private String rMessage;
    private List<ProductData> data;

    @Data
    public static class ProductData {
        private String categoryName;
        private boolean isRocket;
        private boolean isFreeShipping;
        private long productId;
        private String productImage;
        private String productName;
        private int productPrice;
        private String productUrl;
    }
}
