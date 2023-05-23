package com.earnmoneynow.partners.module.tistory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TistoryCreateRequestDto {
    @JsonProperty("access_token")
    private String accessToken;
    private String output;
    private String title;
    private String tag;
    private Integer visibility;
    private String content;
    private String blogName;
}
