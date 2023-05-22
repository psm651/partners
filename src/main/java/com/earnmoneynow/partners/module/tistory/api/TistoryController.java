package com.earnmoneynow.partners.module.tistory.api;

import com.earnmoneynow.partners.module.tistory.dto.TistoryContentResponseDto;
import com.earnmoneynow.partners.module.tistory.service.TistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("tistory")
public class TistoryController {
    private final TistoryService tistoryService;

    @GetMapping("{blogName}/{postId}")
    public ResponseEntity<TistoryContentResponseDto> getContent(@PathVariable String blogName, @PathVariable Long postId) {
        TistoryContentResponseDto tistoryContentResponseDto = tistoryService.getContent(blogName, postId);
        return ResponseEntity.status(HttpStatus.OK).body(tistoryContentResponseDto);
    }
}
