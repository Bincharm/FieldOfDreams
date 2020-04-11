package com.boots.repository;

import com.boots.entity.LetterState;
import com.boots.model.ReportUserModel;
import com.boots.model.ReportWordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<LetterState, Long> {


}
