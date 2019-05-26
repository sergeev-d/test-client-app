package com.assessments.portal.web.services;

import com.assessments.portal.web.domain.assessment.Assessment;
import com.assessments.portal.web.domain.assessment.AssessmentResult;

import java.util.List;

public interface AssessmentService {
    List<Assessment> getAssessmentsById(Long userId);
    List<Assessment> getAllAssessments();
    Long addAssessment(Assessment assessment, Long userId);
    void deleteAssessment(Long id);
    void updateAssessment(Assessment assessment);
    void addAssessmentResult(Long userId, AssessmentResult result);
    List<AssessmentResult> getAssessmentsResult(Long userId);
}
