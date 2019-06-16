package com.assessments.portal.web.domain.assessment;

import com.assessments.portal.web.domain.AbstractBaseEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Transactional
@Table(name = "assessment_result")
public class AssessmentResultDAO extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "assessment_id", nullable = false)
    private Long assessmentId;

    @Column(name = "assessment_name", nullable = false)
    private String assessmentName;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Lob
    @Column(name = "recommendation")
    private String recommendation;

    @Lob
    @Column(name = "ctx")
    private String ctx;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @Column(name = "blocks", nullable = false)
//    private List<String> blocks;
//
//    @ElementCollection
//    @Column(name = "blocks_result_data", nullable = false)
//    private List<String> blocksResultData;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getCtx() {
        return ctx;
    }

    public void setCtx(String ctx) {
        this.ctx = ctx;
    }

    //    public List<String> getBlocks() {
//        return blocks;
//    }
//
//    public void setBlocks(List<String> blocks) {
//        this.blocks = blocks;
//    }
//
//    public List<String> getBlocksResultData() {
//        return blocksResultData;
//    }
//
//    public void setBlocksResultData(List<String> blocksResultData) {
//        this.blocksResultData = blocksResultData;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssessmentResultDAO that = (AssessmentResultDAO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(assessmentId, that.assessmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, assessmentId);
    }

    @Override
    public String toString() {
        return "AssessmentResultDAO{" +
                "id=" + id +
                ", userId=" + userId +
                ", assessmentId=" + assessmentId +
                ", assessmentName='" + assessmentName + '\'' +
                ", createDate=" + createDate +
                ", recommendation='" + recommendation + '\'' +
//                ", blocks=" + blocks +
//                ", blocksResultData=" + blocksResultData +
                '}';
    }
}
