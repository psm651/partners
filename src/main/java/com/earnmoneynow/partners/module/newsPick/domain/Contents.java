package com.earnmoneynow.partners.module.newsPick.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "contents")
public class Contents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contents_id")
    private Integer contentsId;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "img")
    private String img;

    @Column(name = "click_count")
    private Integer clickCount;

    @Column(name = "contents_date")
    private LocalDateTime contentsDate;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
