package com.assessments.portal.web.domain.assessment;

import java.util.List;

public class ResultContext {
    private List<String> blocks;
    private List<String> blocksResults;

    public List<String> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<String> blocks) {
        this.blocks = blocks;
    }

    public List<String> getBlocksResults() {
        return blocksResults;
    }

    public void setBlocksResults(List<String> blocksResults) {
        this.blocksResults = blocksResults;
    }
}
