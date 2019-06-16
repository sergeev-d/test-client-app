package com.assessments.portal.web.domain.assessment;

public enum AssessmentStatus {
    DRAFT("Новая"),
    ACTIVE("Активная"),
    INACTIVE("Не активная");

    private String status;

    AssessmentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
