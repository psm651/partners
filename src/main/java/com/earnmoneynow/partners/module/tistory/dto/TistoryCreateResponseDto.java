package com.earnmoneynow.partners.module.tistory.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TistoryCreateResponseDto {
    public static Tistory tistory;

    @Getter
    @NoArgsConstructor
    private static class Tistory {
        private String status;
        private Integer postId;
        private String url;
    }
}
