package com.assessments.portal.web.domain.assessment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GlobalRecommendation {
    @JsonProperty("minValue")
    private Integer minValue;
    @JsonProperty("maxValue")
    private Integer maxValue;
    @JsonProperty("description")
    private String description;

    @JsonProperty("minValue")
    public Integer getMinValue() {
        return minValue;
    }

    @JsonProperty("minValue")
    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public GlobalRecommendation withMinValue(Integer minValue) {
        this.minValue = minValue;
        return this;
    }

    @JsonProperty("maxValue")
    public Integer getMaxValue() {
        return maxValue;
    }

    @JsonProperty("maxValue")
    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public GlobalRecommendation withMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
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

    public GlobalRecommendation withDescription(String description) {
        this.description = description;
        return this;
    }
}
