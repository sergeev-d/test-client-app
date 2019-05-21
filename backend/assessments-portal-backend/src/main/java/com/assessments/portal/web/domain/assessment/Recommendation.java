package com.assessments.portal.web.domain.assessment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "minValue",
        "maxValue",
        "description"
})

public class Recommendation {
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

    public Recommendation withMinValue(String minValue) {
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

    public Recommendation withMaxValue(String maxValue) {
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

    public Recommendation withDescription(String description) {
        this.description = description;
        return this;
    }
}
