package com.assessments.portal.web.domain.assessment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Assessment {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("status")
    private String status;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("companyTypeId")
    private Integer companyTypeId;
    @JsonProperty("industryId")
    private Integer industryId;
    @JsonProperty("userId")
    private Long userId;
    @JsonProperty("strategy")
    private Integer strategy;
    @JsonProperty("create_date")
    private Date createDate;
    @JsonProperty("questionBlocks")
    private List<QuestionBlock> questionBlocks = Collections.emptyList();
    @JsonProperty("global_recommendations")
    private List<GlobalRecommendation> globalRecommendations = Collections.emptyList();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public Assessment withId(Long id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Assessment withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Assessment withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Assessment withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Assessment withComment(String comment) {
        this.comment = comment;
        return this;
    }

    @JsonProperty("companyTypeId")
    public Integer getCompanyTypeId() {
        return companyTypeId;
    }

    @JsonProperty("companyTypeId")
    public void setCompanyTypeId(Integer companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    public Assessment withCompanyTypeId(Integer companyTypeId) {
        this.companyTypeId = companyTypeId;
        return this;
    }

    @JsonProperty("industryId")
    public Integer getIndustryId() {
        return industryId;
    }

    @JsonProperty("industryId")
    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public Assessment withIndustryId(Integer industryId) {
        this.industryId = industryId;
        return this;
    }

    @JsonProperty("userId")
    public Long getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Assessment withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @JsonProperty("strategy")
    public Integer getStrategy() {
        return strategy;
    }

    @JsonProperty("strategy")
    public void setStrategy(Integer strategy) {
        this.strategy = strategy;
    }

    public Assessment withStrategy(Integer strategy) {
        this.strategy = strategy;
        return this;
    }

    @JsonProperty("questionBlocks")
    public List<QuestionBlock> getQuestionBlocks() {
        return questionBlocks;
    }

    @JsonProperty("questionBlocks")
    public void setQuestionBlocks(List<QuestionBlock> questionBlocks) {
        this.questionBlocks = questionBlocks;
    }

    public Assessment withQuestionBlocks(List<QuestionBlock> questionBlocks) {
        this.questionBlocks = questionBlocks;
        return this;
    }

    @JsonProperty("global_recommendations")
    public List<GlobalRecommendation> getGlobalRecommendations() {
        return globalRecommendations;
    }

    @JsonProperty("global_recommendations")
    public void setGlobalRecommendations(List<GlobalRecommendation> globalRecommendations) {
        this.globalRecommendations = globalRecommendations;
    }

    public Assessment withGlobalRecommendations(List<GlobalRecommendation> globalRecommendations) {
        this.globalRecommendations = globalRecommendations;
        return this;
    }

    @JsonProperty("create_date")
    public Date getCreateDate() {
        return createDate;
    }

    @JsonProperty("create_date")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Assessment withCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }
}
