package com.assessments.portal.web.repository;

import com.assessments.portal.web.domain.assessment.AssessmentResultDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentResultRepository extends JpaRepository<AssessmentResultDAO, Long> {
}
