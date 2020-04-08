package com.boots.repository;

import com.boots.entity.LetterState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetterStateRepository extends JpaRepository<LetterState, Long> {

}
