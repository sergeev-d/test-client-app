package com.assessments.portal.web.domain.assessment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "assessmentId",
        "assessmentName",
        "blocks",
        "resultBlockData",
        "recommendation",
        "createDate"
})

public class AssessmentResult {
    @JsonProperty("assessmentId")
    private Long assessmentId;
    @JsonProperty("assessmentName")
    private String assessmentName;
    @JsonProperty("blocks")
    private List<String> blocks = Collections.emptyList();
    @JsonProperty("resultBlockData")
    private List<String> resultBlockData = Collections.emptyList();
    @JsonProperty("recommendation")
    private String recommendation;
    @JsonProperty("createDate")
    private Date createDate;

    @JsonProperty("assessmentId")
    public Long getAssessmentId() {
        return assessmentId;
    }
    @JsonProperty("assessmentId")
    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public AssessmentResult withAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
        return this;
    }

    @JsonProperty("assessmentName")
    public String getAssessmentName() {
        return assessmentName;
    }

    @JsonProperty("assessmentName")
    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public AssessmentResult withAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
        return this;
    }

    @JsonProperty("blocks")
    public List<String> getBlocks() {
        return blocks;
    }

    @JsonProperty("blocks")
    public void setBlocks(List<String> blocks) {
        this.blocks = blocks;
    }

    public AssessmentResult withBlocks(List<String> blocks) {
        this.blocks = blocks;
        return this;
    }

    @JsonProperty("resultBlockData")
    public List<String> getResultBlockData() {
        return resultBlockData;
    }

    @JsonProperty("resultBlockData")
    public void setResultBlockData(List<String> resultBlockData) {
        this.resultBlockData = resultBlockData;
    }

    public AssessmentResult withResultBlockData(List<String> resultBlockData) {
        this.resultBlockData = resultBlockData;
        return this;
    }

    @JsonProperty("recommendation")
    public String getRecommendation() {
        return recommendation;
    }

    @JsonProperty("recommendation")
    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public AssessmentResult withRecommendation(String recommendation) {
        this.recommendation = recommendation;
        return this;
    }

    @JsonProperty("createDate")
    public Date getCreateDate() {
        return createDate;
    }

    @JsonProperty("createDate")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AssessmentResult withCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }
}
