package com.assessments.portal.web.domain.assessment;

import java.util.Date;

public class AssessmentResult {
    private Long id;
    private Long assessmentId;
    private String assessmentName;
    private Date createdDate;
    private String status;
    private String link;

    public AssessmentResult(Long id, Long assessmentId, String assessmentName, Date createdDate, String status, String link) {
        this.id = id;
        this.assessmentId = assessmentId;
        this.assessmentName = assessmentName;
        this.createdDate = createdDate;
        this.status = status;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
