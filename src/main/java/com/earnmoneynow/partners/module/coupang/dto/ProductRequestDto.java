package com.earnmoneynow.partners.module.coupang.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequestDto {
    private String subId;
    private String imageSize = "512x512";
    private String limit;
    private String keyword;
    private String srpLinkOnly;

}
