package com.earnmoneynow.partners.module.tistory.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonRootName(value = "tistory")
public class TistoryCreateResponseDto {
    private String status;
    private Integer postId;
    private String url;
}
