package com.earnmoneynow.partners.module.newsPick.repository;

import com.earnmoneynow.partners.module.newsPick.domain.Contents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ContentsRepositoryTest {

    @Autowired
    private ContentsRepository contentsRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createContents() {
        Contents contents = Contents.builder()
                .contentsDate(LocalDateTime.now())
                .title("test제목")
                .link("link.com")
                .img("img.com")
                .build();
        //given
        Contents savedContents = contentsRepository.save(contents);
        //when
        Optional<Contents> optionalContents = contentsRepository.findById(1L);

        assertThat(optionalContents.isPresent()).isTrue();

        //then
        Contents finedContents = optionalContents.get();
        assertThat(finedContents.getTitle()).isEqualTo(savedContents.getTitle());
        assertThat(finedContents.getLink()).isEqualTo(savedContents.getLink());
        assertThat(finedContents.getImg()).isEqualTo(savedContents.getImg());
    }

}