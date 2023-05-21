package com.earnmoneynow.partners.module.newsPick.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("contents")
public class NewsPickController {

    @GetMapping("{contentsId}")
    public ResponseEntity<MappingJacksonValue> getContents(@PathVariable int contentsId) {

        return null;
    }

}
