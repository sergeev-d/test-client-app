package com.assessments.portal.web.domain.assessment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("value")
    private String value;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public Question withId(Long id) {
        this.id = id;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public Question withValue(String value) {
        this.value = value;
        return this;
    }
}
