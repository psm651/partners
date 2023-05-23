package com.earnmoneynow.partners.module.tistory.api;

import com.earnmoneynow.partners.module.tistory.dto.TistoryContentResponseDto;
import com.earnmoneynow.partners.module.tistory.dto.TistoryCreateRequestDto;
import com.earnmoneynow.partners.module.tistory.dto.TistoryCreateResponseDto;
import com.earnmoneynow.partners.module.tistory.service.TistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("tistory/{blogName}")
public class TistoryController {
    private final TistoryService tistoryService;

    @GetMapping("/{postId}")
    public ResponseEntity<TistoryContentResponseDto> getContent(@PathVariable String blogName, @PathVariable Long postId) {
        TistoryContentResponseDto tistoryContentResponseDto = tistoryService.getContent(blogName, postId);
        return ResponseEntity.status(HttpStatus.OK).body(tistoryContentResponseDto);
    }

    @PostMapping("")
    public ResponseEntity<TistoryCreateResponseDto> postContent(@PathVariable String blogName, @ModelAttribute TistoryCreateRequestDto tistoryCreateRequestDto) {
        tistoryCreateRequestDto.setBlogName(blogName);
        TistoryCreateResponseDto tistoryCreateResponseDto = tistoryService.createContent(tistoryCreateRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(tistoryCreateResponseDto);
    }
}
