package com.earnmoneynow.partners.module.newsPick.repository;

import com.earnmoneynow.partners.module.newsPick.domain.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Long> {

}
