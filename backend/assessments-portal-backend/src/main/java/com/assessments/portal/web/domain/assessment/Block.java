package com.assessments.portal.web.domain.assessment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public class Block {
    @JsonProperty("name")
    private String name;
    @JsonProperty("questions")
    private List<Question> questions = Collections.emptyList();
    @JsonProperty("recommendations")
    private List<Recommendation> recommendations = Collections.emptyList();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Block withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("questions")
    public List<Question> getQuestions() {
        return questions;
    }

    @JsonProperty("questions")
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Block withQuestions(List<Question> questions) {
        this.questions = questions;
        return this;
    }

    @JsonProperty("recommendations")
    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    @JsonProperty("recommendations")
    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public Block withRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
        return this;
    }
}
