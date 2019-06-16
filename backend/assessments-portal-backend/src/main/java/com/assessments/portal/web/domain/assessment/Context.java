package com.assessments.portal.web.domain.assessment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Context {
    @JsonProperty("questionBlocks")
    private List<QuestionBlock> questionBlocks;

    @JsonProperty("globalRecommendations")
    public List<GlobalRecommendation> globalRecommendations;

    @JsonProperty("questionBlocks")
    public List<QuestionBlock> getQuestionBlocks() {
        return questionBlocks;
    }
    @JsonProperty("questionBlocks")
    public void setQuestionBlocks(List<QuestionBlock> questionBlocks) {
        this.questionBlocks = questionBlocks;
    }
    @JsonProperty("globalRecommendations")
    public List<GlobalRecommendation> getGlobalRecommendations() {
        return globalRecommendations;
    }
    @JsonProperty("globalRecommendations")
    public void setGlobalRecommendations(List<GlobalRecommendation> globalRecommendations) {
        this.globalRecommendations = globalRecommendations;
    }

    public Context withQuestions(List<QuestionBlock> questions){
        this.questionBlocks = questions;
        return this;
    }

    public Context withGlobalRecommendations(List<GlobalRecommendation> globalRecommendations){
        this.globalRecommendations = globalRecommendations;
        return this;
    }
}
