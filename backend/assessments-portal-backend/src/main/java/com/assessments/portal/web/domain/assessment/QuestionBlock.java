package com.assessments.portal.web.domain.assessment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionBlock {
    @JsonProperty("block")
    private Block block;

    @JsonProperty("block")
    public Block getBlock() {
        return block;
    }

    @JsonProperty("block")
    public void setBlock(Block block) {
        this.block = block;
    }

    public QuestionBlock withBlock(Block block) {
        this.block = block;
        return this;
    }
}
