package com.earnmoneynow.partners.module.openAi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OpenAiRequestDto {
    private List<Messages> messages;
    private String model;

    @AllArgsConstructor
    @Builder
    @Getter
    public static class Messages {
        private String role;
        private String content;

    }
}
