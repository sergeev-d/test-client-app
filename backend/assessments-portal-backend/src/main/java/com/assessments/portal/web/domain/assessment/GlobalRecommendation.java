package com.assessments.portal.web.domain.assessment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GlobalRecommendation {
    @JsonProperty("minValue")
    private String minValue;
    @JsonProperty("maxValue")
    private String maxValue;
    @JsonProperty("description")
    private String description;

    @JsonProperty("minValue")
    public String getMinValue() {
        return minValue;
    }

    @JsonProperty("minValue")
    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public GlobalRecommendation withMinValue(String minValue) {
        this.minValue = minValue;
        return this;
    }

    @JsonProperty("maxValue")
    public String getMaxValue() {
        return maxValue;
    }

    @JsonProperty("maxValue")
    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public GlobalRecommendation withMaxValue(String maxValue) {
        this.maxValue = maxValue;
        return this;
    }
}
