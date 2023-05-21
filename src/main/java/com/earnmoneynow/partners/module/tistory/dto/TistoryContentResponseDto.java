package com.earnmoneynow.partners.module.tistory.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TistoryContentResponseDto {
    private TistoryItemDTO tistory;

    @Data
    public static class TistoryItemDTO {
        private String status;
        private ItemDTO item;
    }

    @Data
    public static class ItemDTO {
        private String url;
        private String secondaryUrl;
        private String id;
        private String slogan;
        private String title;
        private String content;
        private String categoryId;
        private String postUrl;
        private String visibility;
        private String acceptComment;
        private String acceptTrackback;
        private String comments;
        private String trackbacks;
        private String date;
        private String tags;
    }
}
