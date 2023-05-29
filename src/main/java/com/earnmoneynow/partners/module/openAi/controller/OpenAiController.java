package com.earnmoneynow.partners.module.openAi.controller;

import com.earnmoneynow.partners.module.openAi.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("open-ai")
@RequiredArgsConstructor
public class OpenAiController {
    private final OpenAiService openAiService;
    @GetMapping
    public ResponseEntity<String> getAiData(@RequestParam String message) {
        List<String> messages = Arrays.asList(message.split(","));
        String result = openAiService.getGPTData(messages);
        return ResponseEntity.ok(result);

    }

}
