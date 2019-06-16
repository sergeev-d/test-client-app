package com.assessments.portal.web.repository;

import com.assessments.portal.web.domain.assessment.AssessmentDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessmentRepository extends JpaRepository<AssessmentDAO, Long> {
    List<AssessmentDAO> findByUserId(Long userId);
}
