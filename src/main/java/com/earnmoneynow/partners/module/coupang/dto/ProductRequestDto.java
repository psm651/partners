package com.earnmoneynow.partners.module.coupang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductRequestDto {
    private String subId;
    private String imageSize;
    private String limit;
    private String keyword;
    private String srpLinkOnly;

    public ProductRequestDto() {
        this.imageSize = "512x512";
    }
}
