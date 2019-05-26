package com.assessments.portal.web.controllers;

import com.assessments.portal.common.results.ApiResult;
import com.assessments.portal.common.security.TokenManager;
import com.assessments.portal.web.domain.assessment.Assessment;
import com.assessments.portal.web.domain.assessment.AssessmentResult;
import com.assessments.portal.web.services.AssessmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api")
public class AssessmentController {
    private TokenManager tokenManager;
    private AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService, TokenManager tokenManager) {
        this.tokenManager = tokenManager;
        this.assessmentService = assessmentService;
    }

    @PostMapping("/assessments")
    private ResponseEntity<ApiResult> addAssessments(@RequestHeader Map<String, String> headers, @RequestBody Assessment assessment){
        String authHeader = headers.get("authorization");

        if (authHeader != null && !authHeader.isEmpty()){
            Long userId = tokenManager.verifyJwt(authHeader.split("\\s")[1]);
            return ResponseEntity.
                    ok(ApiResult.
                            blank().
                            add("id", assessmentService.addAssessment(assessment, userId))
                    );
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResult.error("user not found", "401"));
        }

    }

    @GetMapping("/assessments")
    private ResponseEntity<ApiResult> getAssessment(@RequestHeader Map<String, String> headers){
        return ResponseEntity.ok(ApiResult.blank().add("assessments", assessmentService.getAllAssessments()));
    }

    @GetMapping("/user_assessments")
    private ResponseEntity<ApiResult> getUserAssessment(@RequestHeader Map<String, String> headers){
        String authHeader = headers.get("authorization");

        if (authHeader != null && !authHeader.isEmpty()){
            Long userId = tokenManager.verifyJwt(authHeader.split("\\s")[1]);
            return ResponseEntity.ok(ApiResult.blank().add("assessments", assessmentService.getAssessmentsById(userId)));
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResult.error("user not found", "401"));
        }
    }


    @DeleteMapping("/assessments")
    private ResponseEntity<ApiResult> deleteAssessment(@RequestHeader Map<String, String> headers,
                                                       @RequestParam(value = "assessmentId") long assessmentId){
        //check user
        //check user assessment
        //delete assessment (change status)?
        assessmentService.deleteAssessment(assessmentId);
        return ResponseEntity.ok().body(ApiResult.blank());
    }

    @PatchMapping("/assessments")
    private ResponseEntity<?> updateAssessment(@RequestHeader Map<String, String> headers,
                                                       @RequestBody Assessment assessment){
        assessmentService.updateAssessment(assessment);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/assessments-result")
    private ResponseEntity<ApiResult> getAssessmentsResult(@RequestHeader Map<String, String> headers){
        String authHeader = headers.get("authorization");

        if (authHeader != null && !authHeader.isEmpty()){
            Long userId = tokenManager.verifyJwt(authHeader.split("\\s")[1]);
            return ResponseEntity.ok(
                    ApiResult.blank()
                            .add("assessmentsResult", assessmentService.getAssessmentsResult(userId)));
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResult.error("user not found", "401"));
        }
    }

    @PostMapping("/assessments-result")
    private ResponseEntity<ApiResult> saveUserAssessmentResult(@RequestHeader Map<String, String> headers,
                                                               @RequestBody AssessmentResult result){
        String authHeader = headers.get("authorization");

        if (authHeader != null && !authHeader.isEmpty()){
            Long userId = tokenManager.verifyJwt(authHeader.split("\\s")[1]);
            assessmentService.addAssessmentResult(userId, result);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResult.error("user not found", "401"));
        }
    }
}
